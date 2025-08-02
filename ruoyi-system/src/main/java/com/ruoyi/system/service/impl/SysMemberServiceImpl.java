package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysMember;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMemberMapper;
import com.ruoyi.system.service.ISysMemberService;
import com.ruoyi.common.core.text.Convert;

/**
 * 会员Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-05
 */
@Service
public class SysMemberServiceImpl implements ISysMemberService 
{
    @Autowired
    private SysMemberMapper sysMemberMapper;

    /**
     * 查询会员
     * 
     * @param userId 会员ID
     * @return 会员
     */
    @Override
    public SysMember selectSysMemberById(Long userId)
    {
        return sysMemberMapper.selectSysMemberById(userId);
    }

    /**
     * 查询会员列表
     * 
     * @param sysMember 会员
     * @return 会员
     */
    @Override
    public List<SysMember> selectSysMemberList(SysMember sysMember)
    {
        return sysMemberMapper.selectSysMemberList(sysMember);
    }

    /**
     * 新增会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    @Override
    public int insertSysMember(SysMember sysMember)
    {
        sysMember.setCreateTime(DateUtils.getNowDate());
        return sysMemberMapper.insertSysMember(sysMember);
    }

    /**
     * 修改会员
     * 
     * @param sysMember 会员
     * @return 结果
     */
    @Override
    public int updateSysMember(SysMember sysMember)
    {
        sysMember.setUpdateTime(DateUtils.getNowDate());
        return sysMemberMapper.updateSysMember(sysMember);
    }

    /**
     * 删除会员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysMemberByIds(String ids)
    {
        return sysMemberMapper.deleteSysMemberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员信息
     * 
     * @param userId 会员ID
     * @return 结果
     */
    @Override
    public int deleteSysMemberById(Long userId)
    {
        return sysMemberMapper.deleteSysMemberById(userId);
    }
}
