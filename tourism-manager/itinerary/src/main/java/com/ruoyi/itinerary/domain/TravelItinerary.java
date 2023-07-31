package com.ruoyi.itinerary.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 行程单对象 travel_itinerary
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public class TravelItinerary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long itineraryId;

    /** 关联的旅行社信息表的旅行社 */
    @Excel(name = "关联的旅行社信息表的旅行社")
    private Long agencyId;

    /** 团队名称 */
    @Excel(name = "团队名称")
    private String teamName;

    /** 目的地 */
    @Excel(name = "目的地")
    private String destination;

    /** 行程开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "行程开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tripStartTime;

    /** 行程结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "行程结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tripEndTime;

    /** 电子行程单的详细内容 */
    @Excel(name = "电子行程单的详细内容")
    private String comment;

    /** 关联的导游 */
    @Excel(name = "关联的导游")
    private Long tourGuideId;

    public void setItineraryId(Long itineraryId) 
    {
        this.itineraryId = itineraryId;
    }

    public Long getItineraryId() 
    {
        return itineraryId;
    }
    public void setAgencyId(Long agencyId) 
    {
        this.agencyId = agencyId;
    }

    public Long getAgencyId() 
    {
        return agencyId;
    }
    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
    }
    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public String getDestination() 
    {
        return destination;
    }
    public void setTripStartTime(Date tripStartTime) 
    {
        this.tripStartTime = tripStartTime;
    }

    public Date getTripStartTime() 
    {
        return tripStartTime;
    }
    public void setTripEndTime(Date tripEndTime) 
    {
        this.tripEndTime = tripEndTime;
    }

    public Date getTripEndTime() 
    {
        return tripEndTime;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }
    public void setTourGuideId(Long tourGuideId) 
    {
        this.tourGuideId = tourGuideId;
    }

    public Long getTourGuideId() 
    {
        return tourGuideId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itineraryId", getItineraryId())
            .append("agencyId", getAgencyId())
            .append("teamName", getTeamName())
            .append("destination", getDestination())
            .append("tripStartTime", getTripStartTime())
            .append("tripEndTime", getTripEndTime())
            .append("comment", getComment())
            .append("tourGuideId", getTourGuideId())
            .toString();
    }
}
