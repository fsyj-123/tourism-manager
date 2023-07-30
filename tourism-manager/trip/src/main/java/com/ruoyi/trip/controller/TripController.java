package com.ruoyi.trip.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.trip.entity.TravelItinerary;
import com.ruoyi.trip.service.TravelItineraryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/trip/manage")
public class TripController {

    @Resource
    public TravelItineraryService travelItineraryServiceImpl;

    @PostMapping
    public AjaxResult insert(@RequestBody TravelItinerary travelItinerary) {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        travelItinerary.setTourGuideId(Math.toIntExact(user.getUserId()));
        travelItineraryServiceImpl.insert(travelItinerary);
        return AjaxResult.success("success");
    }

}
