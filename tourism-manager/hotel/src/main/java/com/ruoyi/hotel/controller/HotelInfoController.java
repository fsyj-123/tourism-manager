package com.ruoyi.hotel.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.hotel.domain.HotelInfo;
import com.ruoyi.hotel.service.IHotelInfoService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 饭店管理Controller
 *
 * @author fsyj
 * @date 2023-07-29
 */
@RestController
@RequestMapping("/hotel/manage")
public class HotelInfoController extends BaseController
{
    @Autowired
    private IHotelInfoService hotelInfoService;

    /**
     * 查询饭店管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelInfo hotelInfo)
    {
        startPage();
        List<HotelInfo> list = hotelInfoService.selectHotelInfoList(hotelInfo);
        return getDataTable(list);
    }

    /**
     * 导出饭店管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:manage:export')")
    @Log(title = "饭店管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HotelInfo hotelInfo)
    {
        List<HotelInfo> list = hotelInfoService.selectHotelInfoList(hotelInfo);
        ExcelUtil<HotelInfo> util = new ExcelUtil<HotelInfo>(HotelInfo.class);
        util.exportExcel(response, list, "饭店管理数据");
    }

    /**
     * 获取饭店管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hotelInfoService.selectHotelInfoById(id));
    }

    /**
     * 新增饭店管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:manage:add')")
    @Log(title = "饭店管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelInfo hotelInfo)
    {
        return toAjax(hotelInfoService.insertHotelInfo(hotelInfo));
    }

    /**
     * 修改饭店管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:manage:edit')")
    @Log(title = "饭店管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelInfo hotelInfo)
    {
        return toAjax(hotelInfoService.updateHotelInfo(hotelInfo));
    }

    /**
     * 删除饭店管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:manage:remove')")
    @Log(title = "饭店管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hotelInfoService.deleteHotelInfoByIds(ids));
    }
}
