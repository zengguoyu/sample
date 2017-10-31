package com.kenny.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 
 * @author kenny
 *
 */
public interface UserLoginService extends UserDetailsService {

	UserDetails loadUserByUsername(String username,String appId) throws UsernameNotFoundException;
}
