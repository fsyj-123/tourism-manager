package com.ruoyi.person.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.loadtime.Aj;
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
import com.ruoyi.person.domain.PersonInfo;
import com.ruoyi.person.service.IPersonInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员管理Controller
 *
 * @author ycf
 * @date 2023-07-30
 */
@RestController
@RequestMapping("/person/manager")
public class PersonInfoController extends BaseController
{
    @Autowired
    private IPersonInfoService personInfoService;

    /**
     * 查询人员管理列表
     */
    @PreAuthorize("@ss.hasPermi('person:manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonInfo personInfo)
    {
        startPage();
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        return getDataTable(list);
    }

    /**
     * 导出人员管理列表
     */
    @PreAuthorize("@ss.hasPermi('person:manager:export')")
    @Log(title = "人员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonInfo personInfo)
    {
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        ExcelUtil<PersonInfo> util = new ExcelUtil<PersonInfo>(PersonInfo.class);
        util.exportExcel(response, list, "人员管理数据");
    }

    /**
     * 获取人员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('person:manager:query')")
    @GetMapping(value = "/{personId}")
    public AjaxResult getInfo(@PathVariable("personId") Long personId)
    {
        return success(personInfoService.selectPersonInfoByPersonId(personId));
    }

    /**
     * 新增人员管理
     */
    @PreAuthorize("@ss.hasPermi('person:manager:add')")
    @Log(title = "人员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonInfo personInfo)
    {
        return toAjax(personInfoService.insertPersonInfo(personInfo));
    }

    /**
     * 修改人员管理
     */
    @PreAuthorize("@ss.hasPermi('person:manager:edit')")
    @Log(title = "人员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonInfo personInfo)
    {
        return toAjax(personInfoService.updatePersonInfo(personInfo));
    }

    /**
     * 删除人员管理
     */
    @PreAuthorize("@ss.hasPermi('person:manager:remove')")
    @Log(title = "人员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{personIds}")
    public AjaxResult remove(@PathVariable Long[] personIds)
    {
        return toAjax(personInfoService.deletePersonInfoByPersonIds(personIds));
    }

    @GetMapping("/institution/{institutionType}")
    public AjaxResult getInstitutions(@PathVariable Integer institutionType) {
        return AjaxResult.success(personInfoService.getInstitutions(institutionType));
    }
}
