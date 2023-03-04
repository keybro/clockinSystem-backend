package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GroupEmpMapper;
import com.ruoyi.system.domain.GroupEmp;
import com.ruoyi.system.service.IGroupEmpService;

/**
 * 班组人员Service业务层处理
 * 
 * @author lrj
 * @date 2023-03-02
 */
@Service
public class GroupEmpServiceImpl implements IGroupEmpService 
{
    @Autowired
    private GroupEmpMapper groupEmpMapper;

    /**
     * 查询班组人员
     * 
     * @param id 班组人员主键
     * @return 班组人员
     */
    @Override
    public GroupEmp selectGroupEmpById(Long id)
    {
        return groupEmpMapper.selectGroupEmpById(id);
    }

    /**
     * 查询班组人员列表
     * 
     * @param groupEmp 班组人员
     * @return 班组人员
     */
    @Override
    public List<GroupEmp> selectGroupEmpList(GroupEmp groupEmp)
    {
        return groupEmpMapper.selectGroupEmpList(groupEmp);
    }

    /**
     * 新增班组人员
     * 
     * @param groupEmp 班组人员
     * @return 结果
     */
    @Override
    public int insertGroupEmp(GroupEmp groupEmp)
    {
        return groupEmpMapper.insertGroupEmp(groupEmp);
    }

    /**
     * 修改班组人员
     * 
     * @param groupEmp 班组人员
     * @return 结果
     */
    @Override
    public int updateGroupEmp(GroupEmp groupEmp)
    {
        return groupEmpMapper.updateGroupEmp(groupEmp);
    }

    /**
     * 批量删除班组人员
     * 
     * @param ids 需要删除的班组人员主键
     * @return 结果
     */
    @Override
    public int deleteGroupEmpByIds(Long[] ids)
    {
        return groupEmpMapper.deleteGroupEmpByIds(ids);
    }

    /**
     * 删除班组人员信息
     * 
     * @param id 班组人员主键
     * @return 结果
     */
    @Override
    public int deleteGroupEmpById(Long id)
    {
        return groupEmpMapper.deleteGroupEmpById(id);
    }
}
