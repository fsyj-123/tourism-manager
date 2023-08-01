package com.ruoyi.outbound_travel_audit.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.outbound_travel_audit.mapper.OutboundTravelAuditMapper;
import com.ruoyi.outbound_travel_audit.domain.OutboundTravelAudit;
import com.ruoyi.outbound_travel_audit.service.IOutboundTravelAuditService;

/**
 * 出境管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
@Service
public class OutboundTravelAuditServiceImpl implements IOutboundTravelAuditService 
{
    @Autowired
    private OutboundTravelAuditMapper outboundTravelAuditMapper;

    /**
     * 查询出境管理
     * 
     * @param id 出境管理主键
     * @return 出境管理
     */
    @Override
    public OutboundTravelAudit selectOutboundTravelAuditById(Long id)
    {
        return outboundTravelAuditMapper.selectOutboundTravelAuditById(id);
    }

    /**
     * 查询出境管理列表
     * 
     * @param outboundTravelAudit 出境管理
     * @return 出境管理
     */
    @Override
    public List<OutboundTravelAudit> selectOutboundTravelAuditList(OutboundTravelAudit outboundTravelAudit)
    {
        return outboundTravelAuditMapper.selectOutboundTravelAuditList(outboundTravelAudit);
    }

    /**
     * 新增出境管理
     * 
     * @param outboundTravelAudit 出境管理
     * @return 结果
     */
    @Override
    public int insertOutboundTravelAudit(OutboundTravelAudit outboundTravelAudit)
    {
        outboundTravelAudit.setCreateTime(DateUtils.getNowDate());
        return outboundTravelAuditMapper.insertOutboundTravelAudit(outboundTravelAudit);
    }

    /**
     * 修改出境管理
     * 
     * @param outboundTravelAudit 出境管理
     * @return 结果
     */
    @Override
    public int updateOutboundTravelAudit(OutboundTravelAudit outboundTravelAudit)
    {
        return outboundTravelAuditMapper.updateOutboundTravelAudit(outboundTravelAudit);
    }

    /**
     * 批量删除出境管理
     * 
     * @param ids 需要删除的出境管理主键
     * @return 结果
     */
    @Override
    public int deleteOutboundTravelAuditByIds(Long[] ids)
    {
        return outboundTravelAuditMapper.deleteOutboundTravelAuditByIds(ids);
    }

    /**
     * 删除出境管理信息
     * 
     * @param id 出境管理主键
     * @return 结果
     */
    @Override
    public int deleteOutboundTravelAuditById(Long id)
    {
        return outboundTravelAuditMapper.deleteOutboundTravelAuditById(id);
    }
}
