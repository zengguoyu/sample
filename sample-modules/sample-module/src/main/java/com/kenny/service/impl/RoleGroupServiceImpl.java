package com.kenny.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenny.common.utils.converter.Converters;
import com.kenny.common.utils.converter.IConverter;
import com.kenny.domain.SysRoleGroup;
import com.kenny.mapper.ext.SysRoleGroupExtMapper;
import com.kenny.service.RoleGroupService;
import com.kenny.service.dto.RoleGroupDto;
/**
 * 
 * @author kenny
 *
 */
@Service
public class RoleGroupServiceImpl implements RoleGroupService {

	private SysRoleGroupExtMapper sysRoleGroupExtMapper;

	@Autowired
	public void setSysRoleGroupExtMapper(SysRoleGroupExtMapper sysRoleGroupExtMapper) {
		this.sysRoleGroupExtMapper = sysRoleGroupExtMapper;
	}


	@Override
	public List<RoleGroupDto> queryUserRoleGroup(String appId, Integer userId) {

		List<SysRoleGroup> list = this.sysRoleGroupExtMapper.queryUserRoleGroup(appId, userId, RowBounds.DEFAULT);

		List<RoleGroupDto> result = Converters.convertList(list, converter);
		return result;

	}

	private IConverter<SysRoleGroup,RoleGroupDto > converter = new IConverter< SysRoleGroup,RoleGroupDto>() {

		@Override
		public RoleGroupDto convert(SysRoleGroup e) {
			if(e==null){
				return null;
			}
			
			RoleGroupDto dto=new RoleGroupDto();
			dto.setAppId(e.getAppId());
			dto.setCode(e.getCode());
			dto.setDescription(e.getDescription());
			dto.setUuid(e.getUuid());
			
			return dto;
		}
	};
}
