package com.ruoyi.trip.controller;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.trip.dto.TravelItineraryDto;
import com.ruoyi.trip.entity.TouristInfo;
import com.ruoyi.trip.entity.TravelItinerary;
import com.ruoyi.trip.service.TouristInfoService;
import com.ruoyi.trip.service.TravelItineraryService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/trip/manage")
public class TripController {

    @Resource
    private TravelItineraryService travelItineraryServiceImpl;

    @Resource
    private TouristInfoService touristInfoServiceImpl;

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


}
