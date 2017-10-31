package com.kenny.mapper;

import com.kenny.domain.SysUserPosition;
import com.kenny.domain.SysUserPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserPositionMapper extends com.kenny.common.mybatis.pager.BaseMapper<SysUserPosition, String, SysUserPositionExample> {
    long countByExample(SysUserPositionExample example);

    int deleteByExample(SysUserPositionExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(SysUserPosition record);

    int insertSelective(SysUserPosition record);

    List<SysUserPosition> selectByExample(SysUserPositionExample example);

    SysUserPosition selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") SysUserPosition record, @Param("example") SysUserPositionExample example);

    int updateByExample(@Param("record") SysUserPosition record, @Param("example") SysUserPositionExample example);

    int updateByPrimaryKeySelective(SysUserPosition record);

    int updateByPrimaryKey(SysUserPosition record);
}