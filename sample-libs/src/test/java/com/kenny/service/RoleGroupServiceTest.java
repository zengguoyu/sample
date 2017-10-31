package com.kenny.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.kenny.service.dto.RoleGroupDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RoleGroupServiceTest {

	private final Logger logger = LoggerFactory.getLogger(RoleGroupServiceTest.class);
	private RoleGroupService roleGroupService;

	@Autowired
	public void setRoleGroupService(RoleGroupService roleGroupService) {
		this.roleGroupService = roleGroupService;
	}

	@Test
	public void testQueryUserRoleGroup() {
		List<RoleGroupDto> list = this.roleGroupService.queryUserRoleGroup("a", 1);
		for (RoleGroupDto roleGroupDto : list) {
			logger.debug("==============> {}", JSONObject.toJSONString(roleGroupDto));
		}
	}

}
