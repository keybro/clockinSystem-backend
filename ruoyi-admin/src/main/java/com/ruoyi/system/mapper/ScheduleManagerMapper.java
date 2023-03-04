package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ScheduleManager;

/**
 * 排班安排Mapper接口
 * 
 * @author lrj
 * @date 2023-03-02
 */
public interface ScheduleManagerMapper 
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
     * 删除排班安排
     * 
     * @param id 排班安排主键
     * @return 结果
     */
    public int deleteScheduleManagerById(Long id);

    /**
     * 批量删除排班安排
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScheduleManagerByIds(Long[] ids);
}
