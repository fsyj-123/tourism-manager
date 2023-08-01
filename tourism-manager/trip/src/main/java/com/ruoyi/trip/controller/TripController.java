package com.ruoyi.trip.controller;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.guide.domain.TourGuideInfo;
import com.ruoyi.guide.service.ITourGuideInfoService;
import com.ruoyi.trip.dto.TravelItineraryDto;
import com.ruoyi.trip.dto.TripDto;
import com.ruoyi.trip.entity.TouristInfo;
import com.ruoyi.trip.entity.TravelItinerary;
import com.ruoyi.trip.service.TouristInfoService;
import com.ruoyi.trip.service.TravelItineraryService;
import lombok.Data;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trip/manage")
public class TripController {

    @Resource
    private TravelItineraryService travelItineraryServiceImpl;

    @Resource
    private TouristInfoService touristInfoServiceImpl;

    @Resource
    private ITourGuideInfoService tourGuideInfoServiceImpl;

    @PostMapping
    public AjaxResult insert(@RequestBody TravelItineraryDto travelItinerary) {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        travelItinerary.setTourGuideId(Math.toIntExact(user.getUserId()));
        Date start = DateUtils.parseDate(travelItinerary.getStartTime());
        Date end = DateUtils.parseDate(travelItinerary.getEndTime());
        TravelItinerary itinerary = new TravelItinerary();
        BeanUtil.copyProperties(travelItinerary, itinerary);
        itinerary.setTripStartTime(start);
        itinerary.setTripEndTime(end);
        travelItineraryServiceImpl.insert(itinerary);
        return AjaxResult.success("success", itinerary.getItineraryId());
    }


    @PostMapping("/list")
    public AjaxResult insertList(@RequestBody List<TouristInfo> list) {
        touristInfoServiceImpl.batchInsert(list);
        return AjaxResult.success();
    }

    /**
     * itineraryId 行程单ID
     * teamName 团队名
     * tripStartTime 行程开始时间
     * tripEndTime 行程结束时间
     * name 导游名
     * phone 导游手机号
     * comment 转为字符串后的JSON数组，格式如下[{"location":"地点A","startTime":"2023-07-30 08:00:00","endTime":"2023-07-30 12:00:00","remark":"备注1"}]
     * teamMember 队伍成员，JSON数组，格式为[{name: "成员名", identityId: "手机号"}]
     */
    @GetMapping("/list")
    public AjaxResult getTripList() {
        return AjaxResult.success(touristInfoServiceImpl.getList());
    }

    @GetMapping("/list/true")
    public AjaxResult getTripListWithPerson() {
        List<TripDto> list = touristInfoServiceImpl.getList();
        SysUser loginUser = SecurityUtils.getLoginUser().getUser();
        TourGuideInfo guideInfo = tourGuideInfoServiceImpl.selectByPhone(loginUser.getUserName());
        if (guideInfo != null) {
            AjaxResult.success(list.stream().filter(item -> item.getName() != null && item.getName().equals(guideInfo.getName())).collect(Collectors.toList()));
        }
        return AjaxResult.success(list);
    }
}
