package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班组人员对象 group_emp
 * 
 * @author lrj
 * @date 2023-03-02
 */
public class GroupEmp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 排班组id */
    @Excel(name = "排班组id")
    private Long gid;

    /** 员工id */
    @Excel(name = "员工id")
    private Long eid;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String cts;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGid(Long gid) 
    {
        this.gid = gid;
    }

    public Long getGid() 
    {
        return gid;
    }
    public void setEid(Long eid) 
    {
        this.eid = eid;
    }

    public Long getEid() 
    {
        return eid;
    }
    public void setCts(String cts) 
    {
        this.cts = cts;
    }

    public String getCts() 
    {
        return cts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gid", getGid())
            .append("eid", getEid())
            .append("cts", getCts())
            .toString();
    }
}
