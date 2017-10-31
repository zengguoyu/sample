package com.kenny.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kenny.domain.SysUser;
import com.kenny.domain.SysUserExample;
import com.kenny.mapper.SysUserMapper;
import com.kenny.service.RoleGroupService;
import com.kenny.service.UserLoginService;
import com.kenny.service.dto.RoleGroupDto;

//import com.kenny.utils.ThreadLocalData;
/**
 * 
 * @author kenny
 *
 */
@Service(value = "userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

	private SysUserMapper sysUsermapper;

	private RoleGroupService sysGroupService;

	@Autowired
	public void setSysGroupService(RoleGroupService sysGroupService) {
		this.sysGroupService = sysGroupService;
	}

	@Autowired
	public void setSysUsermapper(SysUserMapper sysUsermapper) {
		this.sysUsermapper = sysUsermapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return loadUserByUsername(username, "");
	}

	@Override
	public UserDetails loadUserByUsername(String username, String appId) throws UsernameNotFoundException {

		SysUserExample example = new SysUserExample();
		example.createCriteria().andLoginNameEqualTo(username);
		List<SysUser> sysUserList = sysUsermapper.selectByExample(example);

		if (sysUserList.size() == 0) {
			throw new UsernameNotFoundException(String.format("用户名[%s]不存在！", username));

		} else if (sysUserList.size() > 1) {
			throw new UsernameNotFoundException(String.format("用户名[%s]不唯一，请于管理员联系！", username));
		}

		final SysUser sysUser = sysUserList.get(0);

		List<RoleGroupDto> listRole = this.sysGroupService.queryUserRoleGroup(appId, sysUser.getId());

		final Collection<GrantedAuthority> authorities = new ArrayList<>(listRole.size());
		for (RoleGroupDto roleGroupDto : listRole) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleGroupDto.getCode());
			authorities.add(authority);
		}

		UserDetails details = new UserDetails() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {

				return sysUser.getIsValid() == null || sysUser.getIsValid() == 1;
			}

			@Override
			public boolean isCredentialsNonExpired() {

				return sysUser.getAccountExpiredTime() == null || sysUser.getAccountExpiredTime().after(new Date());
			}

			@Override
			public boolean isAccountNonLocked() {
				return sysUser.getIsLock() == null || sysUser.getIsLock() == 1;
			}

			@Override
			public boolean isAccountNonExpired() {
				return sysUser.getAccountExpiredTime() == null || sysUser.getAccountExpiredTime().after(new Date());
			}

			@Override
			public String getUsername() {
				return sysUser.getLoginName();
			}

			@Override
			public String getPassword() {
				return sysUser.getLoginPassword();
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return authorities;
			}
		};

		return details;
	}

}
