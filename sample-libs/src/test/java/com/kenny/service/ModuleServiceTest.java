package com.kenny.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.kenny.common.mybatis.pager.model.Page;
import com.kenny.service.ModuleService.ModuleTypeEnum;
import com.kenny.service.dto.ModuleDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ModuleServiceTest {
	private final Logger logger = LoggerFactory.getLogger(ModuleServiceTest.class);
	@Autowired
	private ModuleService moduleService;

	@Test
	public void testQueryAllModule() {
		List<ModuleDto> list = moduleService.queryModule("a", ModuleTypeEnum.MENU_AND_MODULE_AND_URI, null);
		for (ModuleDto moduleDto : list) {
			logger.debug("===========>  {}",JSONObject.toJSONString( moduleDto));
		}
		
		assertTrue(list.size()>=0);
		
		Page<ModuleDto> page = Page.makePageByPageNumber(1, 3);
		list = moduleService.queryModule("a", ModuleTypeEnum.MENU_AND_MODULE_AND_URI, page);
		for (ModuleDto moduleDto : list) {
			logger.debug("==========>  {}", JSONObject.toJSONString(moduleDto));
		}
		assertTrue(list.size()>=0 && list.size()<=3);
	}

	
	@Test
	public void testQueryUserModule() {
		List<ModuleDto> list = moduleService.queryUserModule("a",1,ModuleTypeEnum.MENU_AND_MODULE);
		for (ModuleDto moduleDto : list) {
			logger.debug("===========>  {}",JSONObject.toJSONString( moduleDto));
		}
		
		assertTrue(list.size()>=0);
		
	}
	
}
