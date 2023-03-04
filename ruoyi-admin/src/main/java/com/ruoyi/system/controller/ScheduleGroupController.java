package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.service.ISysDeptService;
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
import com.ruoyi.system.domain.ScheduleGroup;
import com.ruoyi.system.service.IScheduleGroupService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 排班组Controller
 * 
 * @author lrj
 * @date 2023-03-02
 */
@RestController
@RequestMapping("/system/schedule_group")
public class ScheduleGroupController extends BaseController
{
    @Autowired
    private IScheduleGroupService scheduleGroupService;

    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 查询排班组列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_group:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScheduleGroup scheduleGroup)
    {
        startPage();
        List<ScheduleGroup> list = scheduleGroupService.selectScheduleGroupList(scheduleGroup);
        for (ScheduleGroup temp :
                list) {
            temp.setDepName(sysDeptService.selectDeptById(temp.getDepId()).getDeptName());
        }
        return getDataTable(list);
    }

    /**
     * 导出排班组列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_group:export')")
    @Log(title = "排班组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScheduleGroup scheduleGroup)
    {
        List<ScheduleGroup> list = scheduleGroupService.selectScheduleGroupList(scheduleGroup);
        ExcelUtil<ScheduleGroup> util = new ExcelUtil<ScheduleGroup>(ScheduleGroup.class);
        util.exportExcel(response, list, "排班组数据");
    }

    /**
     * 获取排班组详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(scheduleGroupService.selectScheduleGroupById(id));
    }

    /**
     * 新增排班组
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_group:add')")
    @Log(title = "排班组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScheduleGroup scheduleGroup)
    {
        return toAjax(scheduleGroupService.insertScheduleGroup(scheduleGroup));
    }

    /**
     * 修改排班组
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_group:edit')")
    @Log(title = "排班组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScheduleGroup scheduleGroup)
    {
        return toAjax(scheduleGroupService.updateScheduleGroup(scheduleGroup));
    }

    /**
     * 删除排班组
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_group:remove')")
    @Log(title = "排班组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scheduleGroupService.deleteScheduleGroupByIds(ids));
    }
}
