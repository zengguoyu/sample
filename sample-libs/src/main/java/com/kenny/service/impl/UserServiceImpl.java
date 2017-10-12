package com.kenny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenny.common.mybatis.pager.model.Page;
import com.kenny.common.mybatis.pager.model.PageBoundsRecord;
import com.kenny.common.mybatis.pager.page.DbExecutor;
import com.kenny.common.mybatis.pager.page.PageQueryTemplate;
import com.kenny.domain.SysUser;
import com.kenny.domain.SysUserExample;
import com.kenny.mapper.SysUserMapper;
import com.kenny.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private SysUserMapper sysUsermapper;

	@Autowired
	public void setSysUsermapper(SysUserMapper sysUsermapper) {
		this.sysUsermapper = sysUsermapper;
	}

	@Override
	public Page<SysUser> queryUser(Page<SysUser> page) {

		return PageQueryTemplate.selectByPage(page, new DbExecutor<SysUser>() {

			@Override
			public List<SysUser> doQuery(PageBoundsRecord<SysUser> pagingBounds) {
				return sysUsermapper.selectByExample(new SysUserExample(), pagingBounds);
			}
		});
	}

}
