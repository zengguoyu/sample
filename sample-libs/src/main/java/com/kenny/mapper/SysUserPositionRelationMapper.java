package com.kenny.mapper;

import com.kenny.domain.SysUserPositionRelation;
import com.kenny.domain.SysUserPositionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserPositionRelationMapper extends com.kenny.common.mybatis.pager.BaseMapper<SysUserPositionRelation, Integer, SysUserPositionRelationExample> {
    long countByExample(SysUserPositionRelationExample example);

    int deleteByExample(SysUserPositionRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserPositionRelation record);

    int insertSelective(SysUserPositionRelation record);

    List<SysUserPositionRelation> selectByExample(SysUserPositionRelationExample example);

    SysUserPositionRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserPositionRelation record, @Param("example") SysUserPositionRelationExample example);

    int updateByExample(@Param("record") SysUserPositionRelation record, @Param("example") SysUserPositionRelationExample example);

    int updateByPrimaryKeySelective(SysUserPositionRelation record);

    int updateByPrimaryKey(SysUserPositionRelation record);
}