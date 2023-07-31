package com.ruoyi.complaint.mapper;

import java.util.List;
import com.ruoyi.complaint.domain.ComplaintRecords;

/**
 * 游客投诉管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-31
 */
public interface ComplaintRecordsMapper 
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
     * 删除游客投诉管理
     * 
     * @param complaintId 游客投诉管理主键
     * @return 结果
     */
    public int deleteComplaintRecordsByComplaintId(Long complaintId);

    /**
     * 批量删除游客投诉管理
     * 
     * @param complaintIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteComplaintRecordsByComplaintIds(Long[] complaintIds);
}
