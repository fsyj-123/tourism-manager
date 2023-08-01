package com.ruoyi.complaint.service;

import java.util.List;
import com.ruoyi.complaint.domain.ComplaintRecords;

/**
 * 游客投诉管理Service接口
 * 
 * @author fs
 * @date 2023-08-01
 */
public interface IComplaintRecordsService 
{
    /**
     * 查询游客投诉管理
     * 
     * @param complaintId 游客投诉管理主键
     * @return 游客投诉管理
     */
    public ComplaintRecords selectComplaintRecordsByComplaintId(Long complaintId);

    /**
     * 查询游客投诉管理列表
     * 
     * @param complaintRecords 游客投诉管理
     * @return 游客投诉管理集合
     */
    public List<ComplaintRecords> selectComplaintRecordsList(ComplaintRecords complaintRecords);

    /**
     * 新增游客投诉管理
     * 
     * @param complaintRecords 游客投诉管理
     * @return 结果
     */
    public int insertComplaintRecords(ComplaintRecords complaintRecords);

    /**
     * 修改游客投诉管理
     * 
     * @param complaintRecords 游客投诉管理
     * @return 结果
     */
    public int updateComplaintRecords(ComplaintRecords complaintRecords);

    /**
     * 批量删除游客投诉管理
     * 
     * @param complaintIds 需要删除的游客投诉管理主键集合
     * @return 结果
     */
    public int deleteComplaintRecordsByComplaintIds(Long[] complaintIds);

    /**
     * 删除游客投诉管理信息
     * 
     * @param complaintId 游客投诉管理主键
     * @return 结果
     */
    public int deleteComplaintRecordsByComplaintId(Long complaintId);
}
