package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScheduleGroupMapper;
import com.ruoyi.system.domain.ScheduleGroup;
import com.ruoyi.system.service.IScheduleGroupService;

/**
 * 排班组Service业务层处理
 * 
 * @author lrj
 * @date 2023-03-02
 */
@Service
public class ScheduleGroupServiceImpl implements IScheduleGroupService 
{
    @Autowired
    private ScheduleGroupMapper scheduleGroupMapper;

    /**
     * 查询排班组
     * 
     * @param id 排班组主键
     * @return 排班组
     */
    @Override
    public ScheduleGroup selectScheduleGroupById(Long id)
    {
        return scheduleGroupMapper.selectScheduleGroupById(id);
    }

    /**
     * 查询排班组列表
     * 
     * @param scheduleGroup 排班组
     * @return 排班组
     */
    @Override
    public List<ScheduleGroup> selectScheduleGroupList(ScheduleGroup scheduleGroup)
    {
        return scheduleGroupMapper.selectScheduleGroupList(scheduleGroup);
    }

    /**
     * 新增排班组
     * 
     * @param scheduleGroup 排班组
     * @return 结果
     */
    @Override
    public int insertScheduleGroup(ScheduleGroup scheduleGroup)
    {
        return scheduleGroupMapper.insertScheduleGroup(scheduleGroup);
    }

    /**
     * 修改排班组
     * 
     * @param scheduleGroup 排班组
     * @return 结果
     */
    @Override
    public int updateScheduleGroup(ScheduleGroup scheduleGroup)
    {
        return scheduleGroupMapper.updateScheduleGroup(scheduleGroup);
    }

    /**
     * 批量删除排班组
     * 
     * @param ids 需要删除的排班组主键
     * @return 结果
     */
    @Override
    public int deleteScheduleGroupByIds(Long[] ids)
    {
        return scheduleGroupMapper.deleteScheduleGroupByIds(ids);
    }

    /**
     * 删除排班组信息
     * 
     * @param id 排班组主键
     * @return 结果
     */
    @Override
    public int deleteScheduleGroupById(Long id)
    {
        return scheduleGroupMapper.deleteScheduleGroupById(id);
    }
}
