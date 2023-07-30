package com.ruoyi.itinerary.controller;

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
import com.ruoyi.itinerary.domain.TravelItinerary;
import com.ruoyi.itinerary.service.ITravelItineraryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 行程单Controller
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@RestController
@RequestMapping("/itinerary/manager")
public class TravelItineraryController extends BaseController
{
    @Autowired
    private ITravelItineraryService travelItineraryService;

    /**
     * 查询行程单列表
     */
    @PreAuthorize("@ss.hasPermi('itinerary:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(TravelItinerary travelItinerary)
    {
        startPage();
        List<TravelItinerary> list = travelItineraryService.selectTravelItineraryList(travelItinerary);
        return getDataTable(list);
    }

    /**
     * 导出行程单列表
     */
    @PreAuthorize("@ss.hasPermi('itinerary:manager:export')")
    @Log(title = "行程单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TravelItinerary travelItinerary)
    {
        List<TravelItinerary> list = travelItineraryService.selectTravelItineraryList(travelItinerary);
        ExcelUtil<TravelItinerary> util = new ExcelUtil<TravelItinerary>(TravelItinerary.class);
        util.exportExcel(response, list, "行程单数据");
    }

    /**
     * 获取行程单详细信息
     */
    @PreAuthorize("@ss.hasPermi('itinerary:manager:query')")
    @GetMapping(value = "/{itineraryId}")
    public AjaxResult getInfo(@PathVariable("itineraryId") Long itineraryId)
    {
        return success(travelItineraryService.selectTravelItineraryByItineraryId(itineraryId));
    }

    /**
     * 新增行程单
     */
    @PreAuthorize("@ss.hasPermi('itinerary:manager:add')")
    @Log(title = "行程单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TravelItinerary travelItinerary)
    {
        return toAjax(travelItineraryService.insertTravelItinerary(travelItinerary));
    }

    /**
     * 修改行程单
     */
    @PreAuthorize("@ss.hasPermi('itinerary:manager:edit')")
    @Log(title = "行程单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TravelItinerary travelItinerary)
    {
        return toAjax(travelItineraryService.updateTravelItinerary(travelItinerary));
    }

    /**
     * 删除行程单
     */
    @PreAuthorize("@ss.hasPermi('itinerary:manager:remove')")
    @Log(title = "行程单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{itineraryIds}")
    public AjaxResult remove(@PathVariable Long[] itineraryIds)
    {
        return toAjax(travelItineraryService.deleteTravelItineraryByItineraryIds(itineraryIds));
    }
}
