package com.ruoyi.trip.entity;

import java.util.Date;
import lombok.Data;

@Data
public class TravelItinerary {
    /**
    * 行程单ID，主键自增
    */
    private Integer itineraryId;

    /**
    * 外键，关联到旅行社信息表的旅行社ID
    */
    private Integer agencyId;

    /**
    * 团队名称
    */
    private String teamName;

    /**
    * 目的地
    */
    private String destination;

    /**
    * 行程开始日期
    */
    private Date tripStartTime;

    /**
    * 行程结束日期
    */
    private Date tripEndTime;

    /**
    * 描述
    */
    private String comment;

    /**
    * 关联到导游
    */
    private Integer tourGuideId;
}