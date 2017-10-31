package com.kenny.controller.vo;

import java.io.Serializable;
import java.util.List;


public class ModuleWithChildrenVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String uuid;

	private String name;

	private Byte moduleType;

	private String url;

	private Short sort;

	private String parentUuid;

	private String icon;

	private List<ModuleWithChildrenVo> children;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getModuleType() {
		return moduleType;
	}

	public void setModuleType(Byte moduleType) {
		this.moduleType = moduleType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Short getSort() {
		return sort;
	}

	public void setSort(Short sort) {
		this.sort = sort;
	}

	public String getParentUuid() {
		return parentUuid;
	}

	public void setParentUuid(String parentUuid) {
		this.parentUuid = parentUuid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<ModuleWithChildrenVo> getChildren() {
		return children;
	}

	public void setChildren(List<ModuleWithChildrenVo> children) {
		this.children = children;
	}
	
	

	
}
