package com.kenny.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenny.domain.SysParam;
import com.kenny.domain.SysParamExample;
import com.kenny.mapper.SysParamMapper;
import com.kenny.service.SysParamService;
import com.kenny.service.enums.SystemInitStatusEnum;

@Service
public class SysParamServiceImpl implements SysParamService {

	private SysParamMapper sysParamMapper;

	@Autowired
	public void setSysParamMapper(SysParamMapper sysParamMapper) {
		this.sysParamMapper = sysParamMapper;
	}

	@Override
	public SystemInitStatusEnum getStystemStatus() {
		SysParamExample example = new SysParamExample();
		example.createCriteria().andParamNameEqualTo(PARAM_NAME_SYSTEM_INIT_STATUS);
		List<SysParam> list = this.sysParamMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			return SystemInitStatusEnum.INITIALIZERED_NOT_YET;
		}

		String value = list.get(0).getParamValue();
		if (StringUtils.isNumeric(value)) {
			Integer status = Integer.valueOf(value);
			SystemInitStatusEnum statusEnum = SystemInitStatusEnum.valueOf(status);
			return statusEnum == null ? SystemInitStatusEnum.INITIALIZERED_NOT_YET : statusEnum;
		}

		return SystemInitStatusEnum.INITIALIZERED_NOT_YET;
	}

	@Override
	public void updateSystemStatus(SystemInitStatusEnum stauts) {
		SysParamExample example = new SysParamExample();
		example.createCriteria().andParamNameEqualTo(PARAM_NAME_SYSTEM_INIT_STATUS);
		List<SysParam> list = this.sysParamMapper.selectByExample(example);

		SysParam sysParam = null;

		if (list == null || list.isEmpty()) {
			synchronized (this) {
				list = this.sysParamMapper.selectByExample(example);
				if (list == null || list.isEmpty()) {
					sysParam = new SysParam();
					sysParam.setParamName(PARAM_NAME_SYSTEM_INIT_STATUS);
					sysParam.setParamValue(String.valueOf(SystemInitStatusEnum.INITIALIZERED_ALREADY.getCode()));
					this.sysParamMapper.insert(sysParam);
					return;
				} else {
					sysParam = list.get(0);
				}
			}
		} else {
			sysParam = list.get(0);
		}

		if (!StringUtils.isNumeric(sysParam.getParamValue())
				|| Integer.valueOf(sysParam.getParamValue()) != stauts.getCode()) {
			sysParam.setParamValue(String.valueOf(stauts.getCode()));
			this.sysParamMapper.updateByPrimaryKeySelective(sysParam);
		}

	}

}
