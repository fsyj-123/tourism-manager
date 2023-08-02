package com.ruoyi.visa.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.visa.domain.Visa;
import com.ruoyi.visa.service.IVisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 签证管理Controller
 * 
 * @author ruoyi
 * @date 2023-08-02
 */
@RestController
@RequestMapping("/visa/manager")
public class VisaController extends BaseController
{
    @Autowired
    private IVisaService visaService;

    /**
     * 查询签证管理列表
     */
    @PreAuthorize("@ss.hasPermi('visa:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(Visa visa)
    {
        startPage();
        List<Visa> list = visaService.selectVisaList(visa);
        return getDataTable(list);
    }

    /**
     * 导出签证管理列表
     */
    @PreAuthorize("@ss.hasPermi('visa:manager:export')")
    @Log(title = "签证管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Visa visa)
    {
        List<Visa> list = visaService.selectVisaList(visa);
        ExcelUtil<Visa> util = new ExcelUtil<Visa>(Visa.class);
        util.exportExcel(response, list, "签证管理数据");
    }

    /**
     * 获取签证管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('visa:manager:query')")
    @GetMapping(value = "/{visaId}")
    public AjaxResult getInfo(@PathVariable("visaId") Long visaId)
    {
        return success(visaService.selectVisaByVisaId(visaId));
    }

    /**
     * 新增签证管理
     */
    @PreAuthorize("@ss.hasPermi('visa:manager:add')")
    @Log(title = "签证管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Visa visa)
    {
        return toAjax(visaService.insertVisa(visa));
    }

    /**
     * 修改签证管理
     */
    @PreAuthorize("@ss.hasPermi('visa:manager:edit')")
    @Log(title = "签证管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Visa visa)
    {
        return toAjax(visaService.updateVisa(visa));
    }

    /**
     * 删除签证管理
     */
    @PreAuthorize("@ss.hasPermi('visa:manager:remove')")
    @Log(title = "签证管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{visaIds}")
    public AjaxResult remove(@PathVariable Long[] visaIds)
    {
        return toAjax(visaService.deleteVisaByVisaIds(visaIds));
    }
}
