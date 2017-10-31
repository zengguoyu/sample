package com.kenny.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenny.controller.vo.ModuleWithChildrenVo;
import com.kenny.service.ModuleService;
import com.kenny.service.RoleGroupService;

@RestController
@RequestMapping("web/api/v1/module")
public class ModuleApiRestController {

	@SuppressWarnings("unused")
	private RoleGroupService roleGroupService;
	@SuppressWarnings("unused")
	private ModuleService moduleService;
	@Autowired
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	@Autowired
	public void setRoleGroupService(RoleGroupService roleGroupService) {
		this.roleGroupService = roleGroupService;
	}
	List<ModuleWithChildrenVo> queryUserModule(){
		return null;
//		this.moduleService.queryUserModule(appId, userId,ModuleTypeEnum.MENU_AND_MODULE);
	}	 
}
