package com.kenny.mapper;

import com.kenny.domain.SysRoleGroup;
import com.kenny.domain.SysRoleGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleGroupMapper extends com.kenny.common.mybatis.pager.BaseMapper<SysRoleGroup, String, SysRoleGroupExample> {
    long countByExample(SysRoleGroupExample example);

    int deleteByExample(SysRoleGroupExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(SysRoleGroup record);

    int insertSelective(SysRoleGroup record);

    List<SysRoleGroup> selectByExample(SysRoleGroupExample example);

    SysRoleGroup selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") SysRoleGroup record, @Param("example") SysRoleGroupExample example);

    int updateByExample(@Param("record") SysRoleGroup record, @Param("example") SysRoleGroupExample example);

    int updateByPrimaryKeySelective(SysRoleGroup record);

    int updateByPrimaryKey(SysRoleGroup record);
}