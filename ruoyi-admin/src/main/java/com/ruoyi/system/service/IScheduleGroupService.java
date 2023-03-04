package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ScheduleGroup;

/**
 * 排班组Service接口
 * 
 * @author lrj
 * @date 2023-03-02
 */
public interface IScheduleGroupService 
{
    /**
     * 查询排班组
     * 
     * @param id 排班组主键
     * @return 排班组
     */
    public ScheduleGroup selectScheduleGroupById(Long id);

    /**
     * 查询排班组列表
     * 
     * @param scheduleGroup 排班组
     * @return 排班组集合
     */
    public List<ScheduleGroup> selectScheduleGroupList(ScheduleGroup scheduleGroup);

    /**
     * 新增排班组
     * 
     * @param scheduleGroup 排班组
     * @return 结果
     */
    public int insertScheduleGroup(ScheduleGroup scheduleGroup);

    /**
     * 修改排班组
     * 
     * @param scheduleGroup 排班组
     * @return 结果
     */
    public int updateScheduleGroup(ScheduleGroup scheduleGroup);

    /**
     * 批量删除排班组
     * 
     * @param ids 需要删除的排班组主键集合
     * @return 结果
     */
    public int deleteScheduleGroupByIds(Long[] ids);

    /**
     * 删除排班组信息
     * 
     * @param id 排班组主键
     * @return 结果
     */
    public int deleteScheduleGroupById(Long id);
}
