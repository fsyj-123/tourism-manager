package com.ruoyi.outbound_travel_audit.service;

import java.util.List;
import com.ruoyi.outbound_travel_audit.domain.OutboundTravelAudit;

/**
 * 出境管理Service接口
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
public interface IOutboundTravelAuditService 
{
    /**
     * 查询出境管理
     * 
     * @param id 出境管理主键
     * @return 出境管理
     */
    public OutboundTravelAudit selectOutboundTravelAuditById(Long id);

    /**
     * 查询出境管理列表
     * 
     * @param outboundTravelAudit 出境管理
     * @return 出境管理集合
     */
    public List<OutboundTravelAudit> selectOutboundTravelAuditList(OutboundTravelAudit outboundTravelAudit);

    /**
     * 新增出境管理
     * 
     * @param outboundTravelAudit 出境管理
     * @return 结果
     */
    public int insertOutboundTravelAudit(OutboundTravelAudit outboundTravelAudit);

    /**
     * 修改出境管理
     * 
     * @param outboundTravelAudit 出境管理
     * @return 结果
     */
    public int updateOutboundTravelAudit(OutboundTravelAudit outboundTravelAudit);

    /**
     * 批量删除出境管理
     * 
     * @param ids 需要删除的出境管理主键集合
     * @return 结果
     */
    public int deleteOutboundTravelAuditByIds(Long[] ids);

    /**
     * 删除出境管理信息
     * 
     * @param id 出境管理主键
     * @return 结果
     */
    public int deleteOutboundTravelAuditById(Long id);
}
