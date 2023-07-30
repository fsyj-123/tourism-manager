package com.ruoyi.warming.controller;

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
import com.ruoyi.warming.domain.TourismWarming;
import com.ruoyi.warming.service.ITourismWarmingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 告警信息管理Controller
 * 
 * @author llp
 * @date 2023-07-30
 */
@RestController
@RequestMapping("/warming/manager")
public class TourismWarmingController extends BaseController
{
    @Autowired
    private ITourismWarmingService tourismWarmingService;

    /**
     * 查询告警信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('warming:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(TourismWarming tourismWarming)
    {
        startPage();
        List<TourismWarming> list = tourismWarmingService.selectTourismWarmingList(tourismWarming);
        return getDataTable(list);
    }

    /**
     * 导出告警信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('warming:manager:export')")
    @Log(title = "告警信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TourismWarming tourismWarming)
    {
        List<TourismWarming> list = tourismWarmingService.selectTourismWarmingList(tourismWarming);
        ExcelUtil<TourismWarming> util = new ExcelUtil<TourismWarming>(TourismWarming.class);
        util.exportExcel(response, list, "告警信息管理数据");
    }

    /**
     * 获取告警信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('warming:manager:query')")
    @GetMapping(value = "/{warmId}")
    public AjaxResult getInfo(@PathVariable("warmId") Long warmId)
    {
        return success(tourismWarmingService.selectTourismWarmingByWarmId(warmId));
    }

    /**
     * 新增告警信息管理
     */
    @PreAuthorize("@ss.hasPermi('warming:manager:add')")
    @Log(title = "告警信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TourismWarming tourismWarming)
    {
        return toAjax(tourismWarmingService.insertTourismWarming(tourismWarming));
    }

    /**
     * 修改告警信息管理
     */
    @PreAuthorize("@ss.hasPermi('warming:manager:edit')")
    @Log(title = "告警信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TourismWarming tourismWarming)
    {
        return toAjax(tourismWarmingService.updateTourismWarming(tourismWarming));
    }

    /**
     * 删除告警信息管理
     */
    @PreAuthorize("@ss.hasPermi('warming:manager:remove')")
    @Log(title = "告警信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warmIds}")
    public AjaxResult remove(@PathVariable Long[] warmIds)
    {
        return toAjax(tourismWarmingService.deleteTourismWarmingByWarmIds(warmIds));
    }
}
