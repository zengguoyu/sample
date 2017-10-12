package com.kenny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kenny.common.mybatis.pager.model.Page;
import com.kenny.domain.SysUser;
import com.kenny.service.UserService;

@Controller
public class UserController {
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/")
	public String queryUser(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber, //
			@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Model model) {

		Page<SysUser> page=Page.makePageByPageNumber(pageNumber, pageSize);
		userService.queryUser(page);
		model.addAttribute("page", page);
		return "index";

	}
}
