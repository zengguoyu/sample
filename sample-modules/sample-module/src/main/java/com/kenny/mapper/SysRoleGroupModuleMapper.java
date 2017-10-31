package com.kenny.mapper;

import com.kenny.domain.SysRoleGroupModule;
import com.kenny.domain.SysRoleGroupModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleGroupModuleMapper extends com.kenny.common.mybatis.pager.BaseMapper<SysRoleGroupModule, Integer, SysRoleGroupModuleExample> {
    long countByExample(SysRoleGroupModuleExample example);

    int deleteByExample(SysRoleGroupModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleGroupModule record);

    int insertSelective(SysRoleGroupModule record);

    List<SysRoleGroupModule> selectByExample(SysRoleGroupModuleExample example);

    SysRoleGroupModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleGroupModule record, @Param("example") SysRoleGroupModuleExample example);

    int updateByExample(@Param("record") SysRoleGroupModule record, @Param("example") SysRoleGroupModuleExample example);

    int updateByPrimaryKeySelective(SysRoleGroupModule record);

    int updateByPrimaryKey(SysRoleGroupModule record);
}