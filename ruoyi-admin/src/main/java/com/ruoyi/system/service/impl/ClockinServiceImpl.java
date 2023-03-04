package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClockinMapper;
import com.ruoyi.system.domain.Clockin;
import com.ruoyi.system.service.IClockinService;

/**
 * 打卡信息Service业务层处理
 * 
 * @author lrj
 * @date 2023-03-02
 */
@Service
public class ClockinServiceImpl implements IClockinService 
{
    @Autowired
    private ClockinMapper clockinMapper;

    /**
     * 查询打卡信息
     * 
     * @param id 打卡信息主键
     * @return 打卡信息
     */
    @Override
    public Clockin selectClockinById(Long id)
    {
        return clockinMapper.selectClockinById(id);
    }

    /**
     * 查询打卡信息列表
     * 
     * @param clockin 打卡信息
     * @return 打卡信息
     */
    @Override
    public List<Clockin> selectClockinList(Clockin clockin)
    {
        return clockinMapper.selectClockinList(clockin);
    }

    /**
     * 新增打卡信息
     * 
     * @param clockin 打卡信息
     * @return 结果
     */
    @Override
    public int insertClockin(Clockin clockin)
    {
        return clockinMapper.insertClockin(clockin);
    }

    /**
     * 修改打卡信息
     * 
     * @param clockin 打卡信息
     * @return 结果
     */
    @Override
    public int updateClockin(Clockin clockin)
    {
        return clockinMapper.updateClockin(clockin);
    }

    /**
     * 批量删除打卡信息
     * 
     * @param ids 需要删除的打卡信息主键
     * @return 结果
     */
    @Override
    public int deleteClockinByIds(Long[] ids)
    {
        return clockinMapper.deleteClockinByIds(ids);
    }

    /**
     * 删除打卡信息信息
     * 
     * @param id 打卡信息主键
     * @return 结果
     */
    @Override
    public int deleteClockinById(Long id)
    {
        return clockinMapper.deleteClockinById(id);
    }
}
