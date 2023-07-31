package com.ruoyi.travel_agency.controller;

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
import com.ruoyi.travel_agency.domain.TravelAgencyInfo;
import com.ruoyi.travel_agency.service.ITravelAgencyInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 旅行社基础信息Controller
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@RestController
@RequestMapping("/travel_agency/manager")
public class TravelAgencyInfoController extends BaseController
{
    @Autowired
    private ITravelAgencyInfoService travelAgencyInfoService;

    /**
     * 查询旅行社基础信息列表
     */
    @PreAuthorize("@ss.hasPermi('travel_agency:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(TravelAgencyInfo travelAgencyInfo)
    {
        startPage();
        List<TravelAgencyInfo> list = travelAgencyInfoService.selectTravelAgencyInfoList(travelAgencyInfo);
        return getDataTable(list);
    }

    /**
     * 导出旅行社基础信息列表
     */
    @PreAuthorize("@ss.hasPermi('travel_agency:manager:export')")
    @Log(title = "旅行社基础信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TravelAgencyInfo travelAgencyInfo)
    {
        List<TravelAgencyInfo> list = travelAgencyInfoService.selectTravelAgencyInfoList(travelAgencyInfo);
        ExcelUtil<TravelAgencyInfo> util = new ExcelUtil<TravelAgencyInfo>(TravelAgencyInfo.class);
        util.exportExcel(response, list, "旅行社基础信息数据");
    }

    /**
     * 获取旅行社基础信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('travel_agency:manager:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(travelAgencyInfoService.selectTravelAgencyInfoById(id));
    }

    /**
     * 新增旅行社基础信息
     */
    @PreAuthorize("@ss.hasPermi('travel_agency:manager:add')")
    @Log(title = "旅行社基础信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TravelAgencyInfo travelAgencyInfo)
    {
        return toAjax(travelAgencyInfoService.insertTravelAgencyInfo(travelAgencyInfo));
    }

    /**
     * 修改旅行社基础信息
     */
    @PreAuthorize("@ss.hasPermi('travel_agency:manager:edit')")
    @Log(title = "旅行社基础信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TravelAgencyInfo travelAgencyInfo)
    {
        return toAjax(travelAgencyInfoService.updateTravelAgencyInfo(travelAgencyInfo));
    }

    /**
     * 删除旅行社基础信息
     */
    @PreAuthorize("@ss.hasPermi('travel_agency:manager:remove')")
    @Log(title = "旅行社基础信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(travelAgencyInfoService.deleteTravelAgencyInfoByIds(ids));
    }
}
