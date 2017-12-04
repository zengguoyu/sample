package com.kenny.service;

import com.kenny.service.enums.SystemInitStatusEnum;

public interface SysParamService {

	
	public static final String PARAM_NAME_SYSTEM_INIT_STATUS="system_init_status";
	public SystemInitStatusEnum getStystemStatus();
	
	public void updateSystemStatus(SystemInitStatusEnum stauts);
	
	
}
