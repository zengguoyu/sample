package com.kenny.mybatis.generate.plugin;
 
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.internal.DefaultCommentGenerator;
/**
 * 
 * @author kenny
 *
 */
public class DBCommentGenerator extends DefaultCommentGenerator {

 
	
	
	@Override
	protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
		 
		super.addJavadocTag(javaElement, markAsDoNotDelete);
	}
	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

		
		
		innerClass.addJavaDocLine("/**");
		innerClass.addJavaDocLine("* @author " + System.getProperty("user.name"));
		innerClass.addJavaDocLine("* @date " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		innerClass.addJavaDocLine("* @description 本文件自动生成，请勿修改");
		innerClass.addJavaDocLine("*/");
		super.addClassComment(innerClass, introspectedTable);
	}
		
	@Override
	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

		topLevelClass.addJavaDocLine("/**");
		topLevelClass.addJavaDocLine("* @author " + System.getProperty("user.name"));
		topLevelClass.addJavaDocLine("* @date " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		topLevelClass.addJavaDocLine("* @description 本文件自动生成，请勿修改");
		topLevelClass.addJavaDocLine("*/");

		super.addModelClassComment(topLevelClass, introspectedTable);
	}
	 
	
	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		
		
		innerClass.addJavaDocLine("/**");
		innerClass.addJavaDocLine("* @author " + System.getProperty("user.name"));
		innerClass.addJavaDocLine("* @date " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		innerClass.addJavaDocLine("* @description 本文件自动生成，请勿修改");
		innerClass.addJavaDocLine("*/");

		super.addClassComment(innerClass, introspectedTable, markAsDoNotDelete);
	}
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		field.addJavaDocLine("/**");
		field.addJavaDocLine(" * " + getColumnDbTypeInfo(introspectedColumn) + "<br>");
		field.addJavaDocLine(" * " + (introspectedColumn.getRemarks() != null ? introspectedColumn.getRemarks() : ""));
		field.addJavaDocLine(" */");
	}

	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" * " + getColumnDbTypeInfo(introspectedColumn) + "<br>");
		if (introspectedColumn.getRemarks() != null) {
			method.addJavaDocLine(" * 获得 " + introspectedColumn.getRemarks());
		}
		method.addJavaDocLine(" */");
	}

	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" * " + getColumnDbTypeInfo(introspectedColumn) + "<br>");
		if (introspectedColumn.getRemarks() != null) {
			method.addJavaDocLine(" * 设置 " + introspectedColumn.getRemarks());
		}
		method.addJavaDocLine(" */");
	}

	private String getColumnDbTypeInfo(IntrospectedColumn introspectedColumn) {
		StringBuilder sb = new StringBuilder();
		sb.append(introspectedColumn.getJdbcTypeName());
		if (introspectedColumn.getLength() > 0) {
			sb.append("(");
			sb.append(introspectedColumn.getLength());
			if (introspectedColumn.getScale() > 0) {
				sb.append(",").append(introspectedColumn.getScale());
			}
			sb.append(")");
		}
		if (introspectedColumn.getDefaultValue() != null) {
			sb.append(" 默认值[" + introspectedColumn.getDefaultValue() + "]");
		}
		if (!introspectedColumn.isNullable()) {
			sb.append(" 必填");
		}
		return sb.toString();
	}
}
