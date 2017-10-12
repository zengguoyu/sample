package com.kenny.common.mybatis.pager.tag.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.kenny.common.mybatis.pager.tag.parser.MybatisPagerParser;

public class MybatisPagerNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("annotation-driven", new MybatisPagerParser());  
	}
	 
}
