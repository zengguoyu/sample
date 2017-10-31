package com.kenny.service.dto;

import java.io.Serializable;
/**
 * 
 * @author kenny
 *
 */
public class RoleGroupDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(50) 必填<br>
	 * 
	 */
	private String uuid;

	/**
	 * VARCHAR(50) 必填<br>
	 * 
	 */
	private String code;

	/**
	 * VARCHAR(200)<br>
	 * 
	 */
	private String description;

	/**
	 * VARCHAR(50) 必填<br>
	 * 
	 */
	private String appId;

	/**
	 * VARCHAR(50) 必填<br>
	 * 获得
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * VARCHAR(50) 必填<br>
	 * 设置
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	/**
	 * VARCHAR(50) 必填<br>
	 * 获得
	 */
	public String getCode() {
		return code;
	}

	/**
	 * VARCHAR(50) 必填<br>
	 * 设置
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * VARCHAR(50) 必填<br>
	 * 获得
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * VARCHAR(50) 必填<br>
	 * 设置
	 */
	public void setAppId(String appId) {
		this.appId = appId == null ? null : appId.trim();
	}

}
