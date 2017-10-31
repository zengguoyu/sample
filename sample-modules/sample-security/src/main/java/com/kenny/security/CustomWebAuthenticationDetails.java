package com.kenny.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    /**
     * 
     */
    private static final long serialVersionUID = 6975601077710753878L;
    private final String appId;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        appId = request.getParameter("appId");
    }

    public String getAppId() {
        return appId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("; appId: ").append(this.getAppId());
        return sb.toString();
    }
}