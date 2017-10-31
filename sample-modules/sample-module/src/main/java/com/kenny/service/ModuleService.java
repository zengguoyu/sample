package com.kenny.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.kenny.common.mybatis.pager.model.Page;
import com.kenny.service.dto.ModuleDto;

/**
 * 模块接口
 * 
 * @author ZengGuoyu
 *
 */
public interface ModuleService {

	public static enum ModuleTypeEnum {
		
		
		/**
		 * 菜单
		 */
		MENU("", Arrays.asList(Byte.valueOf("1")))
		,
		/**
		 * 模块
		 */
		MODULE("", Arrays.asList(Byte.valueOf("2"))),
		/**
		 * 按钮
		 */
		URI("", Arrays.asList(Byte.valueOf("3"))),
		/**
		 * 菜单和模块
		 */
		MENU_AND_MODULE("", Arrays.asList(Byte.valueOf("1"),Byte.valueOf("2"))),
		/***
		 * 菜单、模块和按钮
		 */
		
		MENU_AND_MODULE_AND_URI("",Arrays.asList(Byte.valueOf("1"),Byte.valueOf("2"),Byte.valueOf("3")))
		;
		
		
		
		private List<Byte> typeValues;
		private String name;

		private ModuleTypeEnum(String name, List<Byte> typeValues) {
			this.name = name;
			Collections.sort(typeValues);
			this.typeValues = Collections.unmodifiableList(typeValues);
		}

		public String getName() {
			return name;
		}

		public List<Byte> getTypeValues() {
			return typeValues;
		}
	}

	/**
	 * 查询某个应用下的模块菜单
	 * @param appId
	 * @param type
	 * @return
	 */
	List<ModuleDto> queryModule(String appId, ModuleTypeEnum type,Page<ModuleDto> page);

	List<ModuleDto> queryUserModule(String appId, Integer userId, ModuleTypeEnum type);

}
