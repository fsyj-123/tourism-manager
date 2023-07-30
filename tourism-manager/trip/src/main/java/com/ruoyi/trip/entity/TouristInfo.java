package com.ruoyi.trip.entity;

import lombok.Data;

@Data
public class TouristInfo {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 游客姓名
    */
    private String name;

    /**
    * 游客身份证
    */
    private String identityId;

    /**
    * 行程单id
    */
    private Integer travelItineraryId;
}