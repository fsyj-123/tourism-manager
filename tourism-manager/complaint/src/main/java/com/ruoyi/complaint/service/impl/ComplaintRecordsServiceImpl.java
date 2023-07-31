package com.ruoyi.complaint.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.complaint.mapper.ComplaintRecordsMapper;
import com.ruoyi.complaint.domain.ComplaintRecords;
import com.ruoyi.complaint.service.IComplaintRecordsService;

/**
 * 游客投诉管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-31
 */
@Service
public class ComplaintRecordsServiceImpl implements IComplaintRecordsService 
{
    @Autowired
    private ComplaintRecordsMapper complaintRecordsMapper;

    /**
     * 查询游客投诉管理
     * 
     * @param complaintId 游客投诉管理主键
     * @return 游客投诉管理
     */
    @Override
    public ComplaintRecords selectComplaintRecordsByComplaintId(Long complaintId)
    {
        return complaintRecordsMapper.selectComplaintRecordsByComplaintId(complaintId);
    }

    /**
     * 查询游客投诉管理列表
     * 
     * @param complaintRecords 游客投诉管理
     * @return 游客投诉管理
     */
    @Override
    public List<ComplaintRecords> selectComplaintRecordsList(ComplaintRecords complaintRecords)
    {
        return complaintRecordsMapper.selectComplaintRecordsList(complaintRecords);
    }

    /**
     * 新增游客投诉管理
     * 
     * @param complaintRecords 游客投诉管理
     * @return 结果
     */
    @Override
    public int insertComplaintRecords(ComplaintRecords complaintRecords)
    {
        complaintRecords.setCreateTime(DateUtils.getNowDate());
        return complaintRecordsMapper.insertComplaintRecords(complaintRecords);
    }

    /**
     * 修改游客投诉管理
     * 
     * @param complaintRecords 游客投诉管理
     * @return 结果
     */
    @Override
    public int updateComplaintRecords(ComplaintRecords complaintRecords)
    {
        return complaintRecordsMapper.updateComplaintRecords(complaintRecords);
    }

    /**
     * 批量删除游客投诉管理
     * 
     * @param complaintIds 需要删除的游客投诉管理主键
     * @return 结果
     */
    @Override
    public int deleteComplaintRecordsByComplaintIds(Long[] complaintIds)
    {
        return complaintRecordsMapper.deleteComplaintRecordsByComplaintIds(complaintIds);
    }

    /**
     * 删除游客投诉管理信息
     * 
     * @param complaintId 游客投诉管理主键
     * @return 结果
     */
    @Override
    public int deleteComplaintRecordsByComplaintId(Long complaintId)
    {
        return complaintRecordsMapper.deleteComplaintRecordsByComplaintId(complaintId);
    }
}
