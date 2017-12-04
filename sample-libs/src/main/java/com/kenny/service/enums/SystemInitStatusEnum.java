package com.kenny.service.enums;

public enum SystemInitStatusEnum {
	INITIALIZERED_NOT_YET(0, "还未初始化"), INITIALIZERED_ALREADY(1, "已经初始化");
	private int code;
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private SystemInitStatusEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static SystemInitStatusEnum valueOf(int code) {
		SystemInitStatusEnum[] values = SystemInitStatusEnum.values();
		for (SystemInitStatusEnum systemInitStatusEnum : values) {
			if (systemInitStatusEnum.getCode() == code)
				return systemInitStatusEnum;
		}

		return null;

	}
}
