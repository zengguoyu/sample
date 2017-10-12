package com.kenny.common.mybatis.pager.tag.parser;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.kenny.common.mybatis.pager.dialect.EnumDbDialect;

public class MybatisPagerParser implements BeanDefinitionParser {
	private final static String PAGE_INTERCEPTOR_BEAN_ID = "pageInterceptor";
	private final static String PAGE_INTERCEPTOR_BEAN_CLASS_NAME = "com.kenny.common.mybatis.pager.interceptor.PageInterceptor";
	private final static String PAGE_COMMON_EXECUTOR_BEAN_CLASS_NAME = "com.kenny.common.mybatis.pager.executor.CommonExecutor";

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {

		String pageInterceptorId = element.getAttribute("pageInterceptorId");
		if (!StringUtils.hasText(pageInterceptorId)) {
			if (parserContext.getRegistry().containsBeanDefinition(PAGE_INTERCEPTOR_BEAN_ID)) {
				parserContext.getReaderContext().warning("覆盖已经注册的" + PAGE_INTERCEPTOR_BEAN_CLASS_NAME,
						parserContext.extractSource(element));
			}
			pageInterceptorId = PAGE_INTERCEPTOR_BEAN_ID;
		}

		BeanDefinitionBuilder pageInterceptorBuilder = BeanDefinitionBuilder
				.genericBeanDefinition(PAGE_INTERCEPTOR_BEAN_CLASS_NAME);

		BeanDefinition commonExecutorBeanDefinition = parseCommonExecutor(element);

		pageInterceptorBuilder.addPropertyValue("commonExecutor", commonExecutorBeanDefinition);
		registerComponent(parserContext, pageInterceptorBuilder, pageInterceptorId);

		return null;
	}

	private BeanDefinition parseCommonExecutor(Element element) {
		BeanDefinition dialectBeanDefinition = parseDialect(element);

		BeanDefinition commonExecutorBeanDefinition = new GenericBeanDefinition();
		commonExecutorBeanDefinition.setBeanClassName(PAGE_COMMON_EXECUTOR_BEAN_CLASS_NAME);
		commonExecutorBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(dialectBeanDefinition);
		return commonExecutorBeanDefinition;
	}

	/**
	 * 解析dialect
	 * 
	 * @param element
	 * @return
	 */
	private BeanDefinition parseDialect(Element element) {
		String dialect = element.getAttribute("dialect");
		EnumDbDialect dbDialect = EnumDbDialect.resolveName(dialect);

		if (dbDialect == null) {
			dbDialect = EnumDbDialect.DIALECT_MYSQL;
		}
		BeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName(dbDialect.getClassName());
		return beanDefinition;
	}

	private static void registerComponent(ParserContext parserContext, BeanDefinitionBuilder builder, String beanName) {

		builder.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		parserContext.getRegistry().registerBeanDefinition(beanName, builder.getBeanDefinition());
		BeanDefinitionHolder holder = new BeanDefinitionHolder(builder.getBeanDefinition(), beanName);
		parserContext.registerComponent(new BeanComponentDefinition(holder));
	}

}
