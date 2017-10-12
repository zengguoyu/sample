package com.kenny.mybatis.generate.plugin;

import java.io.Serializable;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * mybatis插件生成dao
 */
public class MybatisPaginationPlugin extends PluginAdapter {

	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		String superClazz = getProperties().getProperty("extends");
		// 接口加父接口
		if (superClazz != null && superClazz.trim().length() > 0) {
			FullyQualifiedJavaType superType = new FullyQualifiedJavaType(superClazz);

			superType.addTypeArgument(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
			List<IntrospectedColumn> columns = introspectedTable.getPrimaryKeyColumns();
			if (columns != null && columns.size() > 0) {
				superType.addTypeArgument(columns.get(0).getFullyQualifiedJavaType());
			} else {
				superType.addTypeArgument(new FullyQualifiedJavaType(Serializable.class.getName()));

			}
			superType.addTypeArgument(new FullyQualifiedJavaType(introspectedTable.getExampleType()));
			interfaze.addSuperInterface(superType);
			// interfaze.addImportedType(superType);
		}
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}

	public boolean validate(List<String> warnings) {
		return true;
	}

}
