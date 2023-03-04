package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 打卡信息对象 clockin
 * 
 * @author lrj
 * @date 2023-03-02
 */
public class Clockin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 打卡编号 */
    private Long id;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private Long employeesId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String cts;

    /** 打卡日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "打卡日期", width = 30, dateFormat = "yyyy-MM-dd")
    private String day;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String dkstartTs;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String dkendTs;

    /** 是否迟到 */
    @Excel(name = "是否迟到")
    private Long isLate;

    /** 是否早退 */
    @Excel(name = "是否早退")
    private Long leaveEarly;

    private String nickName;

    private String departmentName;

    private Long deptId;

    private SysDept sysDept;

    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEmployeesId(Long employeesId) 
    {
        this.employeesId = employeesId;
    }

    public Long getEmployeesId() 
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
    public void setDkstartTs(String dkstartTs)
    {
        this.dkstartTs = dkstartTs;
    }

    public String getDkstartTs()
    {
        return dkstartTs;
    }
    public void setDkendTs(String dkendTs)
    {
        this.dkendTs = dkendTs;
    }

    public String getDkendTs()
    {
        return dkendTs;
    }
    public void setIsLate(Long isLate) 
    {
        this.isLate = isLate;
    }

    public Long getIsLate() 
    {
        return isLate;
    }
    public void setLeaveEarly(Long leaveEarly) 
    {
        this.leaveEarly = leaveEarly;
    }

    public Long getLeaveEarly() 
    {
        return leaveEarly;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employeesId", getEmployeesId())
            .append("cts", getCts())
            .append("day", getDay())
            .append("dkstartTs", getDkstartTs())
            .append("dkendTs", getDkendTs())
            .append("isLate", getIsLate())
            .append("leaveEarly", getLeaveEarly())
            .toString();
    }
}
