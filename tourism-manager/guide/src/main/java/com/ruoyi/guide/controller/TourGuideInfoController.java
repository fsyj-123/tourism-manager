package com.ruoyi.guide.controller;

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
import com.ruoyi.guide.domain.TourGuideInfo;
import com.ruoyi.guide.service.ITourGuideInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 登记注册Controller
 *
 * @author wyx
 * @date 2023-07-30
 */
@RestController
@RequestMapping("/guide/info")
public class TourGuideInfoController extends BaseController
{
    @Autowired
    private ITourGuideInfoService tourGuideInfoService;

    /**
     * 查询登记注册列表
     */
    @PreAuthorize("@ss.hasPermi('guide:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TourGuideInfo tourGuideInfo)
    {
        startPage();
        List<TourGuideInfo> list = tourGuideInfoService.selectTourGuideInfoList(tourGuideInfo);
        return getDataTable(list);
    }

    /**
     * 导出登记注册列表
     */
    @PreAuthorize("@ss.hasPermi('guide:info:export')")
    @Log(title = "登记注册", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TourGuideInfo tourGuideInfo)
    {
        List<TourGuideInfo> list = tourGuideInfoService.selectTourGuideInfoList(tourGuideInfo);
        ExcelUtil<TourGuideInfo> util = new ExcelUtil<TourGuideInfo>(TourGuideInfo.class);
        util.exportExcel(response, list, "登记注册数据");
    }

    /**
     * 获取登记注册详细信息
     */
    @PreAuthorize("@ss.hasPermi('guide:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tourGuideInfoService.selectTourGuideInfoById(id));
    }

    /**
     * 新增登记注册
     */
    @PreAuthorize("@ss.hasPermi('guide:info:add')")
    @Log(title = "登记注册", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TourGuideInfo tourGuideInfo)
    {
        return toAjax(tourGuideInfoService.insertTourGuideInfo(tourGuideInfo));
    }

    /**
     * 修改登记注册
     */
    @PreAuthorize("@ss.hasPermi('guide:info:edit')")
    @Log(title = "登记注册", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TourGuideInfo tourGuideInfo)
    {
        return toAjax(tourGuideInfoService.updateTourGuideInfo(tourGuideInfo));
    }

    /**
     * 删除登记注册
     */
    @PreAuthorize("@ss.hasPermi('guide:info:remove')")
    @Log(title = "登记注册", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tourGuideInfoService.deleteTourGuideInfoByIds(ids));
    }


}
