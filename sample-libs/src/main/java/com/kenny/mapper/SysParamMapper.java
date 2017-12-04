package com.kenny.mapper;

import com.kenny.domain.SysParam;
import com.kenny.domain.SysParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysParamMapper extends com.kenny.common.mybatis.pager.BaseMapper<SysParam, Integer, SysParamExample> {
    long countByExample(SysParamExample example);

    int deleteByExample(SysParamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysParam record);

    int insertSelective(SysParam record);

    List<SysParam> selectByExample(SysParamExample example);

    SysParam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysParam record, @Param("example") SysParamExample example);

    int updateByExample(@Param("record") SysParam record, @Param("example") SysParamExample example);

    int updateByPrimaryKeySelective(SysParam record);

    int updateByPrimaryKey(SysParam record);
}