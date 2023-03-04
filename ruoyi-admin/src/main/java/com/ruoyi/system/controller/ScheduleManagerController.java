package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.system.domain.ScheduleManager;
import com.ruoyi.system.service.IScheduleManagerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 排班安排Controller
 * 
 * @author lrj
 * @date 2023-03-02
 */
@RestController
@RequestMapping("/system/schedule_manage")
public class ScheduleManagerController extends BaseController
{
    @Autowired
    private IScheduleManagerService scheduleManagerService;

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询排班安排列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScheduleManager scheduleManager)
    {
        startPage();
        List<ScheduleManager> list = scheduleManagerService.selectScheduleManagerList(scheduleManager);
        for (ScheduleManager temp :
                list) {
            temp.setEmployerName(userService.selectUserById(Long.parseLong(temp.getEmployeesId())).getNickName());
            temp.setDepartmentName(sysDeptService.selectDeptById(temp.getDepId()).getDeptName());
        }
        return getDataTable(list);
    }

    /**
     * 导出排班安排列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_manage:export')")
    @Log(title = "排班安排", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScheduleManager scheduleManager)
    {
        List<ScheduleManager> list = scheduleManagerService.selectScheduleManagerList(scheduleManager);
        ExcelUtil<ScheduleManager> util = new ExcelUtil<ScheduleManager>(ScheduleManager.class);
        util.exportExcel(response, list, "排班安排数据");
    }

    /**
     * 获取排班安排详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(scheduleManagerService.selectScheduleManagerById(id));
    }

    /**
     * 新增排班安排
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_manage:add')")
    @Log(title = "排班安排", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScheduleManager scheduleManager)
    {
        return toAjax(scheduleManagerService.insertScheduleManager(scheduleManager));
    }

    /**
     * 修改排班安排
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_manage:edit')")
    @Log(title = "排班安排", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScheduleManager scheduleManager)
    {
        return toAjax(scheduleManagerService.updateScheduleManager(scheduleManager));
    }

    /**
     * 删除排班安排
     */
    @PreAuthorize("@ss.hasPermi('system:schedule_manage:remove')")
    @Log(title = "排班安排", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scheduleManagerService.deleteScheduleManagerByIds(ids));
    }
}
