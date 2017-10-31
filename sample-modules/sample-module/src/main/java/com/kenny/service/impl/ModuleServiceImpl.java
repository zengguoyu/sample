package com.kenny.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenny.common.mybatis.pager.model.Page;
import com.kenny.common.mybatis.pager.model.PageBoundsRecord;
import com.kenny.common.mybatis.pager.page.DbExecutor;
import com.kenny.common.mybatis.pager.page.PageQueryTemplate;
import com.kenny.common.utils.converter.Converters;
import com.kenny.common.utils.converter.IConverter;
import com.kenny.domain.SysModule;
import com.kenny.domain.SysModuleExample;
import com.kenny.domain.SysRoleGroupModule;
import com.kenny.domain.SysRoleGroupModuleExample;
import com.kenny.mapper.SysModuleMapper;
import com.kenny.mapper.SysRoleGroupModuleMapper;
import com.kenny.service.ModuleService;
import com.kenny.service.RoleGroupService;
import com.kenny.service.dto.ModuleDto;
import com.kenny.service.dto.RoleGroupDto;

/**
 * 
 * @author kenny
 *
 */
@Service
public class ModuleServiceImpl implements ModuleService {

	private SysModuleMapper sysModuleMapper;
	private RoleGroupService roleGroupService;

	private SysRoleGroupModuleMapper sysRoleGroupModuleMapper;

	@Autowired
	public void setSysRoleGroupModuleMapper(SysRoleGroupModuleMapper sysRoleGroupModuleMapper) {
		this.sysRoleGroupModuleMapper = sysRoleGroupModuleMapper;
	}

	@Autowired
	public void setRoleGroupService(RoleGroupService roleGroupService) {
		this.roleGroupService = roleGroupService;
	}

	@Autowired
	public void setSysModuleMapper(SysModuleMapper sysModuleMapper) {
		this.sysModuleMapper = sysModuleMapper;
	}

	@Override
	public List<ModuleDto> queryModule(final String appId, final ModuleTypeEnum type, Page<ModuleDto> page) {
		return PageQueryTemplate.selectByPage(page, new DbExecutor<ModuleDto>() {

			@Override
			public List<ModuleDto> doQuery(PageBoundsRecord<ModuleDto> pagingBounds) {
				SysModuleExample example = new SysModuleExample();
				example.createCriteria().andAppIdEqualTo(appId).andModuleTypeIn(type.getTypeValues());
				example.setOrderByClause(" sort");
				List<SysModule> list = sysModuleMapper.selectByExample(example, pagingBounds);
				List<ModuleDto> listResult = new ArrayList<>();
				for (SysModule sysModule : list) {
					ModuleDto dto = converter.convert(sysModule);
					if (dto != null) {
						listResult.add(dto);
					}
				}

				return listResult;
			}
		}).getRecords();
	}

	@Override
	public List<ModuleDto> queryUserModule(String appId, Integer userId, ModuleTypeEnum type) {

		// 查询用户拥有的角色
		List<RoleGroupDto> roleGroupDtoList = roleGroupService.queryUserRoleGroup(appId, userId);

		// 是否是管理员角色

		boolean isAdmin = false;
		for (RoleGroupDto roleGroupDto : roleGroupDtoList) {
			if ("ROLE_ADMIN".equals(roleGroupDto.getCode())) {
				isAdmin = true;
				break;
			}
		}

		SysModuleExample example = new SysModuleExample();
		SysModuleExample.Criteria criteria = example.createCriteria();
		if (!isAdmin) {

			// 如果不是管理员，需要根据用户拥有的角色，去查询用户角色拥有的权限模块ID
			List<String> roleGroupUuidList = Converters.convertList(roleGroupDtoList,
					new IConverter<RoleGroupDto, String>() {

						@Override
						public String convert(RoleGroupDto t) {
							return t.getUuid();
						}
					});
			SysRoleGroupModuleExample roleGroupModuleExample = new SysRoleGroupModuleExample();
			roleGroupModuleExample.createCriteria()//
					.andRoleGroupUuidIn(roleGroupUuidList).andExpiredTimeGreaterThan(new Date());

			List<SysRoleGroupModule> roleGroupModuleList = this.sysRoleGroupModuleMapper
					.selectByExample(roleGroupModuleExample);

			List<String> moduleUuidList = Converters.convertList(roleGroupModuleList,
					new IConverter<SysRoleGroupModule, String>() {

						@Override
						public String convert(SysRoleGroupModule t) {
							return t.getModuleUuid();
						}
					});

			if (moduleUuidList.size() < 1) {
				return new ArrayList<>();
			}
			criteria.andUuidIn(moduleUuidList);
		}
		// 如果是管理员，只需要根据appId查询
		criteria.andAppIdEqualTo(appId);

		List<SysModule> list = this.sysModuleMapper.selectByExample(example);

		return Converters.convertList(list, converter);

	}

	private IConverter<SysModule, ModuleDto> converter = new IConverter<SysModule, ModuleDto>() {

		@Override
		public ModuleDto convert(SysModule module) {
			if (module == null) {
				return null;
			}
			ModuleDto dto = new ModuleDto();
			dto.setAppId(module.getAppId());
			dto.setIcon(module.getIcon());
			dto.setModuleType(module.getModuleType());
			dto.setName(module.getName());
			dto.setParentUuid(module.getParentUuid());
			dto.setPerms(module.getPerms());
			dto.setSort(module.getSort());
			dto.setUrl(module.getUrl());
			dto.setUuid(module.getUuid());
			return dto;
		}

	};
}
