package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Clockin;

/**
 * 打卡信息Mapper接口
 * 
 * @author lrj
 * @date 2023-03-02
 */
public interface ClockinMapper 
{
    /**
     * 查询打卡信息
     * 
     * @param id 打卡信息主键
     * @return 打卡信息
     */
    public Clockin selectClockinById(Long id);

    /**
     * 查询打卡信息列表
     * 
     * @param clockin 打卡信息
     * @return 打卡信息集合
     */
    public List<Clockin> selectClockinList(Clockin clockin);

    /**
     * 新增打卡信息
     * 
     * @param clockin 打卡信息
     * @return 结果
     */
    public int insertClockin(Clockin clockin);

    /**
     * 修改打卡信息
     * 
     * @param clockin 打卡信息
     * @return 结果
     */
    public int updateClockin(Clockin clockin);

    /**
     * 删除打卡信息
     * 
     * @param id 打卡信息主键
     * @return 结果
     */
    public int deleteClockinById(Long id);

    /**
     * 批量删除打卡信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClockinByIds(Long[] ids);
}
