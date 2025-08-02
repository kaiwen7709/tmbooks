package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysMember;

/**
 * 会员Mapper接口
 * 
 * @author ruoyi
 * @date 2025-08-05
 */
public interface SysMemberMapper 
{
    /**
     * 查询会员
     * 
     * @param userId 会员ID
     * @return 会员
     */
    public SysMember selectSysMemberById(Long userId);

    /**
     * 查询会员列表
     * 
     * @param sysMember 会员
     * @return 会员集合
     */
    public List<SysMember> selectSysMemberList(SysMember sysMember);

    /**
     * 新增会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    public int insertSysMember(SysMember sysMember);

    /**
     * 修改会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    public int updateSysMember(SysMember sysMember);

    /**
     * 删除会员
     * 
     * @param userId 会员ID
     * @return 结果
     */
    public int deleteSysMemberById(Long userId);

    /**
     * 批量删除会员
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysMemberByIds(String[] userIds);
}
