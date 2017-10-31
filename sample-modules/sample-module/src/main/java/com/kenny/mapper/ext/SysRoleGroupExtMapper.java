package com.kenny.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.kenny.domain.SysRoleGroup;
/**
 * 
 * @author kenny
 *
 */
public interface SysRoleGroupExtMapper {

	/**
	 * 查詢用户所在的角色组
	 * 
	 * @param appId
	 * @param userId
	 * @param moduleTypes
	 * @param rowBounds
	 * @return
	 */
	List<SysRoleGroup> queryUserRoleGroup(//
			@Param("appId") String appId, //
			@Param("userId") Integer userId, //
			RowBounds rowBounds);

}
