package com.ruoyi.outbound.mapper;

import java.util.List;
import com.ruoyi.outbound.domain.OutboundTravelAudit;

/**
 * 出境管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
public interface OutboundTravelAuditMapper 
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
     * 删除出境管理
     * 
     * @param id 出境管理主键
     * @return 结果
     */
    public int deleteOutboundTravelAuditById(Long id);

    /**
     * 批量删除出境管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutboundTravelAuditByIds(Long[] ids);
}
