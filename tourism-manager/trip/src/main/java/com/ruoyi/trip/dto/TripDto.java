package com.ruoyi.trip.dto;

import com.ruoyi.trip.entity.TouristInfo;
import lombok.Data;

import java.util.List;

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
@Data
public class TripDto {
    private Long itineraryId;
    private String teamName;
    private String tripStartTime;
    private String tripEndTime;
    private String name;
    private String phone;
    private String comment;
    private List<TouristInfo> teamMembers;

}
