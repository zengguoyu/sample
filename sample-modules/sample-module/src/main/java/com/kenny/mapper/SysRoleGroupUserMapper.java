package com.kenny.mapper;

import com.kenny.domain.SysRoleGroupUser;
import com.kenny.domain.SysRoleGroupUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleGroupUserMapper extends com.kenny.common.mybatis.pager.BaseMapper<SysRoleGroupUser, Integer, SysRoleGroupUserExample> {
    long countByExample(SysRoleGroupUserExample example);

    int deleteByExample(SysRoleGroupUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleGroupUser record);

    int insertSelective(SysRoleGroupUser record);

    List<SysRoleGroupUser> selectByExample(SysRoleGroupUserExample example);

    SysRoleGroupUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleGroupUser record, @Param("example") SysRoleGroupUserExample example);

    int updateByExample(@Param("record") SysRoleGroupUser record, @Param("example") SysRoleGroupUserExample example);

    int updateByPrimaryKeySelective(SysRoleGroupUser record);

    int updateByPrimaryKey(SysRoleGroupUser record);
}