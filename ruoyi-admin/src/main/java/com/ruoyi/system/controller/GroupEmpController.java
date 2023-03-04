package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.GroupEmp;
import com.ruoyi.system.service.IGroupEmpService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班组人员Controller
 * 
 * @author lrj
 * @date 2023-03-02
 */
@RestController
@RequestMapping("/system/group_emp")
public class GroupEmpController extends BaseController
{
    @Autowired
    private IGroupEmpService groupEmpService;

    /**
     * 查询班组人员列表
     */
    @PreAuthorize("@ss.hasPermi('system:group_emp:list')")
    @GetMapping("/list")
    public TableDataInfo list(GroupEmp groupEmp)
    {
        startPage();
        List<GroupEmp> list = groupEmpService.selectGroupEmpList(groupEmp);
        return getDataTable(list);
    }

    /**
     * 导出班组人员列表
     */
    @PreAuthorize("@ss.hasPermi('system:group_emp:export')")
    @Log(title = "班组人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GroupEmp groupEmp)
    {
        List<GroupEmp> list = groupEmpService.selectGroupEmpList(groupEmp);
        ExcelUtil<GroupEmp> util = new ExcelUtil<GroupEmp>(GroupEmp.class);
        util.exportExcel(response, list, "班组人员数据");
    }

    /**
     * 获取班组人员详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:group_emp:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(groupEmpService.selectGroupEmpById(id));
    }

    /**
     * 新增班组人员
     */
    @PreAuthorize("@ss.hasPermi('system:group_emp:add')")
    @Log(title = "班组人员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GroupEmp groupEmp)
    {
        return toAjax(groupEmpService.insertGroupEmp(groupEmp));
    }

    /**
     * 修改班组人员
     */
    @PreAuthorize("@ss.hasPermi('system:group_emp:edit')")
    @Log(title = "班组人员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GroupEmp groupEmp)
    {
        return toAjax(groupEmpService.updateGroupEmp(groupEmp));
    }

    /**
     * 删除班组人员
     */
    @PreAuthorize("@ss.hasPermi('system:group_emp:remove')")
    @Log(title = "班组人员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(groupEmpService.deleteGroupEmpByIds(ids));
    }
}
