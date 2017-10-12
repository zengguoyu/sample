package com.kenny.service;

import com.kenny.common.mybatis.pager.model.Page;
import com.kenny.domain.SysUser;

public interface UserService {
	public Page<SysUser> queryUser(Page<SysUser> page);
}
