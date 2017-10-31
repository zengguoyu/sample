package com.kenny.service;

import java.util.List;

import com.kenny.service.dto.RoleGroupDto;

/**
 * 角色組服務
 * @author kenny
 *
 */
public interface RoleGroupService {

	/**
	 * 查詢用戶擁有的角色組
	 * @param appId
	 * @param userId
	 * @return
	 */
	public List<RoleGroupDto> queryUserRoleGroup(String appId,Integer userId);
	
}
