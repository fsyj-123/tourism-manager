package com.ruoyi.complaint.controller;

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
import com.ruoyi.complaint.domain.ComplaintRecords;
import com.ruoyi.complaint.service.IComplaintRecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游客投诉管理Controller
 * 
 * @author fs
 * @date 2023-08-01
 */
@RestController
@RequestMapping("/complaint/manager")
public class ComplaintRecordsController extends BaseController
{
    @Autowired
    private IComplaintRecordsService complaintRecordsService;

    /**
     * 查询游客投诉管理列表
     */
    @PreAuthorize("@ss.hasPermi('complaint:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(ComplaintRecords complaintRecords)
    {
        startPage();
        List<ComplaintRecords> list = complaintRecordsService.selectComplaintRecordsList(complaintRecords);
        return getDataTable(list);
    }

    /**
     * 导出游客投诉管理列表
     */
    @PreAuthorize("@ss.hasPermi('complaint:manager:export')")
    @Log(title = "游客投诉管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ComplaintRecords complaintRecords)
    {
        List<ComplaintRecords> list = complaintRecordsService.selectComplaintRecordsList(complaintRecords);
        ExcelUtil<ComplaintRecords> util = new ExcelUtil<ComplaintRecords>(ComplaintRecords.class);
        util.exportExcel(response, list, "游客投诉管理数据");
    }

    /**
     * 获取游客投诉管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('complaint:manager:query')")
    @GetMapping(value = "/{complaintId}")
    public AjaxResult getInfo(@PathVariable("complaintId") Long complaintId)
    {
        return success(complaintRecordsService.selectComplaintRecordsByComplaintId(complaintId));
    }

    /**
     * 新增游客投诉管理
     */
    @PreAuthorize("@ss.hasPermi('complaint:manager:add')")
    @Log(title = "游客投诉管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ComplaintRecords complaintRecords)
    {
        return toAjax(complaintRecordsService.insertComplaintRecords(complaintRecords));
    }

    /**
     * 修改游客投诉管理
     */
    @PreAuthorize("@ss.hasPermi('complaint:manager:edit')")
    @Log(title = "游客投诉管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ComplaintRecords complaintRecords)
    {
        return toAjax(complaintRecordsService.updateComplaintRecords(complaintRecords));
    }

    /**
     * 删除游客投诉管理
     */
    @PreAuthorize("@ss.hasPermi('complaint:manager:remove')")
    @Log(title = "游客投诉管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{complaintIds}")
    public AjaxResult remove(@PathVariable Long[] complaintIds)
    {
        return toAjax(complaintRecordsService.deleteComplaintRecordsByComplaintIds(complaintIds));
    }
}
