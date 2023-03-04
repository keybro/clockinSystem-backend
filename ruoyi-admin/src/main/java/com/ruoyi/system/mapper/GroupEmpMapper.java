package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GroupEmp;

/**
 * 班组人员Mapper接口
 * 
 * @author lrj
 * @date 2023-03-02
 */
public interface GroupEmpMapper 
{
    /**
     * 查询班组人员
     * 
     * @param id 班组人员主键
     * @return 班组人员
     */
    public GroupEmp selectGroupEmpById(Long id);

    /**
     * 查询班组人员列表
     * 
     * @param groupEmp 班组人员
     * @return 班组人员集合
     */
    public List<GroupEmp> selectGroupEmpList(GroupEmp groupEmp);

    /**
     * 新增班组人员
     * 
     * @param groupEmp 班组人员
     * @return 结果
     */
    public int insertGroupEmp(GroupEmp groupEmp);

    /**
     * 修改班组人员
     * 
     * @param groupEmp 班组人员
     * @return 结果
     */
    public int updateGroupEmp(GroupEmp groupEmp);

    /**
     * 删除班组人员
     * 
     * @param id 班组人员主键
     * @return 结果
     */
    public int deleteGroupEmpById(Long id);

    /**
     * 批量删除班组人员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGroupEmpByIds(Long[] ids);
}
