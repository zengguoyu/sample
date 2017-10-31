package com.kenny.mapper;

import com.kenny.domain.SysOrganizationInner;
import com.kenny.domain.SysOrganizationInnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOrganizationInnerMapper extends com.kenny.common.mybatis.pager.BaseMapper<SysOrganizationInner, String, SysOrganizationInnerExample> {
    long countByExample(SysOrganizationInnerExample example);

    int deleteByExample(SysOrganizationInnerExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(SysOrganizationInner record);

    int insertSelective(SysOrganizationInner record);

    List<SysOrganizationInner> selectByExample(SysOrganizationInnerExample example);

    SysOrganizationInner selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") SysOrganizationInner record, @Param("example") SysOrganizationInnerExample example);

    int updateByExample(@Param("record") SysOrganizationInner record, @Param("example") SysOrganizationInnerExample example);

    int updateByPrimaryKeySelective(SysOrganizationInner record);

    int updateByPrimaryKey(SysOrganizationInner record);
}