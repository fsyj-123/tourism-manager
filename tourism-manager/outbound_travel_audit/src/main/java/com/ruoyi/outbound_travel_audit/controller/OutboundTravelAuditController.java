package com.ruoyi.outbound_travel_audit.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.outbound_travel_audit.domain.OutboundTravelAudit;
import com.ruoyi.outbound_travel_audit.service.IOutboundTravelAuditService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出境管理Controller
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
@RestController
@RequestMapping("/outbound_travel_audit/audit")
public class OutboundTravelAuditController extends BaseController
{
    @Autowired
    private IOutboundTravelAuditService outboundTravelAuditService;

    /**
     * 查询出境管理列表
     */
    @PreAuthorize("@ss.hasPermi('outbound_travel_audit:audit:list')")
    @GetMapping("/list")
    public TableDataInfo list(OutboundTravelAudit outboundTravelAudit)
    {
        startPage();
        List<OutboundTravelAudit> list = outboundTravelAuditService.selectOutboundTravelAuditList(outboundTravelAudit);
        return getDataTable(list);
    }

    /**
     * 导出出境管理列表
     */
    @PreAuthorize("@ss.hasPermi('outbound_travel_audit:audit:export')")
    @Log(title = "出境管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OutboundTravelAudit outboundTravelAudit)
    {
        List<OutboundTravelAudit> list = outboundTravelAuditService.selectOutboundTravelAuditList(outboundTravelAudit);
        ExcelUtil<OutboundTravelAudit> util = new ExcelUtil<OutboundTravelAudit>(OutboundTravelAudit.class);
        util.exportExcel(response, list, "出境管理数据");
    }

    /**
     * 获取出境管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('outbound_travel_audit:audit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(outboundTravelAuditService.selectOutboundTravelAuditById(id));
    }

    /**
     * 新增出境管理
     */
    @PreAuthorize("@ss.hasPermi('outbound_travel_audit:audit:add')")
    @Log(title = "出境管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OutboundTravelAudit outboundTravelAudit)
    {
        return toAjax(outboundTravelAuditService.insertOutboundTravelAudit(outboundTravelAudit));
    }

    /**
     * 修改出境管理
     */
    @PreAuthorize("@ss.hasPermi('outbound_travel_audit:audit:edit')")
    @Log(title = "出境管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OutboundTravelAudit outboundTravelAudit)
    {
        return toAjax(outboundTravelAuditService.updateOutboundTravelAudit(outboundTravelAudit));
    }

    /**
     * 删除出境管理
     */
    @PreAuthorize("@ss.hasPermi('outbound_travel_audit:audit:remove')")
    @Log(title = "出境管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(outboundTravelAuditService.deleteOutboundTravelAuditByIds(ids));
    }
}
