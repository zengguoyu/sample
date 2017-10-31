package com.kenny.mapper;

import com.kenny.domain.SysUserImage;
import com.kenny.domain.SysUserImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserImageMapper extends com.kenny.common.mybatis.pager.BaseMapper<SysUserImage, Integer, SysUserImageExample> {
    long countByExample(SysUserImageExample example);

    int deleteByExample(SysUserImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserImage record);

    int insertSelective(SysUserImage record);

    List<SysUserImage> selectByExampleWithBLOBs(SysUserImageExample example);

    List<SysUserImage> selectByExample(SysUserImageExample example);

    SysUserImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserImage record, @Param("example") SysUserImageExample example);

    int updateByExampleWithBLOBs(@Param("record") SysUserImage record, @Param("example") SysUserImageExample example);

    int updateByExample(@Param("record") SysUserImage record, @Param("example") SysUserImageExample example);

    int updateByPrimaryKeySelective(SysUserImage record);

    int updateByPrimaryKeyWithBLOBs(SysUserImage record);

    int updateByPrimaryKey(SysUserImage record);
}