package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ScheduleManager;

/**
 * 排班安排Service接口
 * 
 * @author lrj
 * @date 2023-03-02
 */
public interface IScheduleManagerService 
{
    /**
     * 查询排班安排
     * 
     * @param id 排班安排主键
     * @return 排班安排
     */
    public ScheduleManager selectScheduleManagerById(Long id);

    /**
     * 查询排班安排列表
     * 
     * @param scheduleManager 排班安排
     * @return 排班安排集合
     */
    public List<ScheduleManager> selectScheduleManagerList(ScheduleManager scheduleManager);

    /**
     * 新增排班安排
     * 
     * @param scheduleManager 排班安排
     * @return 结果
     */
    public int insertScheduleManager(ScheduleManager scheduleManager);

    /**
     * 修改排班安排
     * 
     * @param scheduleManager 排班安排
     * @return 结果
     */
    public int updateScheduleManager(ScheduleManager scheduleManager);

    /**
     * 批量删除排班安排
     * 
     * @param ids 需要删除的排班安排主键集合
     * @return 结果
     */
    public int deleteScheduleManagerByIds(Long[] ids);

    /**
     * 删除排班安排信息
     * 
     * @param id 排班安排主键
     * @return 结果
     */
    public int deleteScheduleManagerById(Long id);
}
