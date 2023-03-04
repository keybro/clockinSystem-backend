package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 排班安排对象 schedule_manager
 * 
 * @author lrj
 * @date 2023-03-02
 */
public class ScheduleManager extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 排班编号 */
    private Long id;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTs;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTs;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private String employeesId;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String cts;

    /** 排班日期 */
    @Excel(name = "排班日期")
    private String day;

    /** 部门id */
    @Excel(name = "部门id")
    private Long depId;

    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Excel.Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Excel.Type.EXPORT)
    })
    private SysDept dept;


    private SysUser sysUser;

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }
    private String employerName;

    private String departmentName;

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStartTs(String startTs) 
    {
        this.startTs = startTs;
    }

    public String getStartTs() 
    {
        return startTs;
    }
    public void setEndTs(String endTs) 
    {
        this.endTs = endTs;
    }

    public String getEndTs() 
    {
        return endTs;
    }
    public void setEmployeesId(String employeesId) 
    {
        this.employeesId = employeesId;
    }

    public String getEmployeesId() 
    {
        return employeesId;
    }
    public void setCts(String cts) 
    {
        this.cts = cts;
    }

    public String getCts() 
    {
        return cts;
    }
    public void setDay(String day) 
    {
        this.day = day;
    }

    public String getDay() 
    {
        return day;
    }
    public void setDepId(Long depId) 
    {
        this.depId = depId;
    }

    public Long getDepId() 
    {
        return depId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("startTs", getStartTs())
            .append("endTs", getEndTs())
            .append("employeesId", getEmployeesId())
            .append("cts", getCts())
            .append("day", getDay())
            .append("depId", getDepId())
            .toString();
    }
}
