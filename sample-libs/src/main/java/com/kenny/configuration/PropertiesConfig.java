package com.kenny.configuration;

import org.springframework.beans.factory.annotation.Value;

public class PropertiesConfig {

	private boolean manangeSecurity;
	
	private String indexPageViewName;
	

	@Value("${page.index.view.name:index}")
	public void setIndexPageViewName(String indexPageName) {
		this.indexPageViewName = indexPageName;
	}
	
	
	@Value("${manage.security:true}")
	public void setManangeSecurity(boolean manangeSecurity) {
		this.manangeSecurity = manangeSecurity;
	}
	
	
	public boolean isManangeSecurity() {
		return manangeSecurity;
	}
	public String getIindexPageViewName() {
		return indexPageViewName;
	}
}
