package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 排班组对象 schedule_group
 * 
 * @author lrj
 * @date 2023-03-02
 */
public class ScheduleGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班组编号 */
    private Long id;

    /** 班组名称 */
    @Excel(name = "班组名称")
    private String gdesc;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private Long depId;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String cts;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTs;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTs;

    /** 部门名称--仅视图用 */
    private String depName;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGdesc(String gdesc) 
    {
        this.gdesc = gdesc;
    }

    public String getGdesc() 
    {
        return gdesc;
    }
    public void setDepId(Long depId) 
    {
        this.depId = depId;
    }

    public Long getDepId() 
    {
        return depId;
    }
    public void setCts(String cts) 
    {
        this.cts = cts;
    }

    public String getCts() 
    {
        return cts;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gdesc", getGdesc())
            .append("depId", getDepId())
            .append("cts", getCts())
            .append("startTs", getStartTs())
            .append("endTs", getEndTs())
            .toString();
    }
}
