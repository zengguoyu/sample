package com.kenny.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import com.kenny.service.SysParamService;
import com.kenny.service.enums.SystemInitStatusEnum;

public class SystemInitFilter extends GenericFilterBean {

	private SysParamService sysParamService;
	private SystemInitStatusEnum statusEnum = null;

	@Autowired
	public void setSysParamService(SysParamService sysParamService) {
		this.sysParamService = sysParamService;
	}

	@Override
	protected void initFilterBean() throws ServletException {

		statusEnum = this.sysParamService.getStystemStatus();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (statusEnum != SystemInitStatusEnum.INITIALIZERED_ALREADY) {
			HttpServletRequest req = (HttpServletRequest) request;

			Boolean status = (Boolean) req.getSession().getAttribute("initing");
			if (status == null || !status.booleanValue()) {
				req.getSession().setAttribute("initing", true);
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect(req.getContextPath() + "/system/init");
				return;
			}
		}
		
		
		chain.doFilter(request, response);

	}

}
