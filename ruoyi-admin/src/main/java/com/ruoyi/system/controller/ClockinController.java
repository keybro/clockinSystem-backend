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
import com.ruoyi.system.domain.Clockin;
import com.ruoyi.system.service.IClockinService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 打卡信息Controller
 * 
 * @author lrj
 * @date 2023-03-02
 */
@RestController
@RequestMapping("/system/clockin")
public class ClockinController extends BaseController
{
    @Autowired
    private IClockinService clockinService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询打卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:clockin:list')")
    @GetMapping("/list")
    public TableDataInfo list(Clockin clockin)
    {
        startPage();
        List<Clockin> list = clockinService.selectClockinList(clockin);
        for (Clockin temp :
                list) {
            temp.setNickName(userService.selectUserById(temp.getEmployeesId()).getNickName());
            Long userId = temp.getEmployeesId();
            Long depId = userService.selectUserById(userId).getDeptId();
            temp.setDeptId(depId);
            temp.setDepartmentName(deptService.selectDeptById(depId).getDeptName());
        }
        return getDataTable(list);
    }

    /**
     * 导出打卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:clockin:export')")
    @Log(title = "打卡信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Clockin clockin)
    {
        List<Clockin> list = clockinService.selectClockinList(clockin);
        ExcelUtil<Clockin> util = new ExcelUtil<Clockin>(Clockin.class);
        util.exportExcel(response, list, "打卡信息数据");
    }

    /**
     * 获取打卡信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:clockin:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(clockinService.selectClockinById(id));
    }

    /**
     * 新增打卡信息
     */
    @PreAuthorize("@ss.hasPermi('system:clockin:add')")
    @Log(title = "打卡信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Clockin clockin)
    {
        return toAjax(clockinService.insertClockin(clockin));
    }

    /**
     * 修改打卡信息
     */
    @PreAuthorize("@ss.hasPermi('system:clockin:edit')")
    @Log(title = "打卡信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Clockin clockin)
    {
        return toAjax(clockinService.updateClockin(clockin));
    }

    /**
     * 删除打卡信息
     */
    @PreAuthorize("@ss.hasPermi('system:clockin:remove')")
    @Log(title = "打卡信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(clockinService.deleteClockinByIds(ids));
    }
}
