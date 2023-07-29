package com.ruoyi.scenic.controller;

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
import com.ruoyi.scenic.domain.ScenicAreaInfo;
import com.ruoyi.scenic.service.IScenicAreaInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景区管理Controller
 * 
 * @author ruoyi
 * @date 2023-07-29
 */
@RestController
@RequestMapping("/scenic/manager")
public class ScenicAreaInfoController extends BaseController
{
    @Autowired
    private IScenicAreaInfoService scenicAreaInfoService;

    /**
     * 查询景区管理列表
     */
    @PreAuthorize("@ss.hasPermi('scenic:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScenicAreaInfo scenicAreaInfo)
    {
        startPage();
        List<ScenicAreaInfo> list = scenicAreaInfoService.selectScenicAreaInfoList(scenicAreaInfo);
        return getDataTable(list);
    }

    /**
     * 导出景区管理列表
     */
    @PreAuthorize("@ss.hasPermi('scenic:manager:export')")
    @Log(title = "景区管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScenicAreaInfo scenicAreaInfo)
    {
        List<ScenicAreaInfo> list = scenicAreaInfoService.selectScenicAreaInfoList(scenicAreaInfo);
        ExcelUtil<ScenicAreaInfo> util = new ExcelUtil<ScenicAreaInfo>(ScenicAreaInfo.class);
        util.exportExcel(response, list, "景区管理数据");
    }

    /**
     * 获取景区管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('scenic:manager:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(scenicAreaInfoService.selectScenicAreaInfoById(id));
    }

    /**
     * 新增景区管理
     */
    @PreAuthorize("@ss.hasPermi('scenic:manager:add')")
    @Log(title = "景区管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScenicAreaInfo scenicAreaInfo)
    {
        return toAjax(scenicAreaInfoService.insertScenicAreaInfo(scenicAreaInfo));
    }

    /**
     * 修改景区管理
     */
    @PreAuthorize("@ss.hasPermi('scenic:manager:edit')")
    @Log(title = "景区管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScenicAreaInfo scenicAreaInfo)
    {
        return toAjax(scenicAreaInfoService.updateScenicAreaInfo(scenicAreaInfo));
    }

    /**
     * 删除景区管理
     */
    @PreAuthorize("@ss.hasPermi('scenic:manager:remove')")
    @Log(title = "景区管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scenicAreaInfoService.deleteScenicAreaInfoByIds(ids));
    }
}
