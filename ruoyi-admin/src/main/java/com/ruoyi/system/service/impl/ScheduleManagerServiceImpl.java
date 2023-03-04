package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScheduleManagerMapper;
import com.ruoyi.system.domain.ScheduleManager;
import com.ruoyi.system.service.IScheduleManagerService;

/**
 * 排班安排Service业务层处理
 * 
 * @author lrj
 * @date 2023-03-02
 */
@Service
public class ScheduleManagerServiceImpl implements IScheduleManagerService 
{
    @Autowired
    private ScheduleManagerMapper scheduleManagerMapper;

    /**
     * 查询排班安排
     * 
     * @param id 排班安排主键
     * @return 排班安排
     */
    @Override
    public ScheduleManager selectScheduleManagerById(Long id)
    {
        return scheduleManagerMapper.selectScheduleManagerById(id);
    }

    /**
     * 查询排班安排列表
     * 
     * @param scheduleManager 排班安排
     * @return 排班安排
     */
    @Override
    public List<ScheduleManager> selectScheduleManagerList(ScheduleManager scheduleManager)
    {
        return scheduleManagerMapper.selectScheduleManagerList(scheduleManager);
    }

    /**
     * 新增排班安排
     * 
     * @param scheduleManager 排班安排
     * @return 结果
     */
    @Override
    public int insertScheduleManager(ScheduleManager scheduleManager)
    {
        return scheduleManagerMapper.insertScheduleManager(scheduleManager);
    }

    /**
     * 修改排班安排
     * 
     * @param scheduleManager 排班安排
     * @return 结果
     */
    @Override
    public int updateScheduleManager(ScheduleManager scheduleManager)
    {
        return scheduleManagerMapper.updateScheduleManager(scheduleManager);
    }

    /**
     * 批量删除排班安排
     * 
     * @param ids 需要删除的排班安排主键
     * @return 结果
     */
    @Override
    public int deleteScheduleManagerByIds(Long[] ids)
    {
        return scheduleManagerMapper.deleteScheduleManagerByIds(ids);
    }

    /**
     * 删除排班安排信息
     * 
     * @param id 排班安排主键
     * @return 结果
     */
    @Override
    public int deleteScheduleManagerById(Long id)
    {
        return scheduleManagerMapper.deleteScheduleManagerById(id);
    }
}
