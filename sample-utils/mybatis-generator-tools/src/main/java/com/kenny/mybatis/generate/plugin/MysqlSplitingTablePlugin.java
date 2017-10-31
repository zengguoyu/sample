package com.kenny.mybatis.generate.plugin;

import java.util.Iterator;
import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysqlSplitingTablePlugin extends AbstractPluginAdapterEnhance {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	private String tableName = "tableName";

	public MysqlSplitingTablePlugin() {
		log.debug("initialized");
	}

	/**
	 * 在Exmaple类中添加tableName字段
	 */
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

		Field tableName = new Field("tableName", PrimitiveTypeWrapper.getStringInstance());
		// 默认设置为当前的table名字
		tableName.setInitializationString("\"" + introspectedTable.getTableConfiguration().getTableName() + "\"");
		tableName.setVisibility(JavaVisibility.PRIVATE);
		addField(topLevelClass, introspectedTable, tableName);

		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

	/**
	 * 在object类中添加tableName字段
	 */
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

		Field tableName = new Field("tableName", PrimitiveTypeWrapper.getStringInstance());
		// 默认设置为当前的table名字
		tableName.setInitializationString("\"" + introspectedTable.getTableConfiguration().getTableName() + "\"");
		tableName.setVisibility(JavaVisibility.PRIVATE);
		addField(topLevelClass, introspectedTable, tableName);

		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}

	/**
	 * 这三个函数在分表中需要用其他函数替换，以为分表需要传入table名字，但是count函数需要处理
	 */
	@Override
	public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

		Iterator<Attribute> attrs = element.getAttributes().iterator();
		while (attrs.hasNext()) {
			Attribute attribute = attrs.next();
			if ("parameterType".equals(attribute.getName())) {
				attrs.remove();
			}
		}

		resetDeleteXmlElementTableName(element);
		return true;
	};

	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		method.getParameters().add(new Parameter(new FullyQualifiedJavaType("String"), "tableName"));

		for (Parameter p : method.getParameters()) {
			p.addAnnotation("@Param(\"" + p.getName() + "\")");
		}

		return super.clientDeleteByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable);
	}

	@Override
	public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

		Iterator<Attribute> attrs = element.getAttributes().iterator();
		while (attrs.hasNext()) {
			Attribute attribute = attrs.next();
			if ("parameterType".equals(attribute.getName())) {
				attrs.remove();
			}
		}
		resetSelectXmlElementTableName(element);
		return true;
	};

	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		method.getParameters().add(new Parameter(new FullyQualifiedJavaType("String"), "tableName"));

		for (Parameter p : method.getParameters()) {
			p.addAnnotation("@Param(\"" + p.getName() + "\")");
		}
		return super.clientSelectByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable);
	}

	@Override
	public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		resetCountByExample(element);
		return super.sqlMapCountByExampleElementGenerated(element, introspectedTable);
	}

	/**
	 * 在xml的SelectByExample的SQL语句添加limit
	 */
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {

		resetSelectXmlElementTableName(element);
		return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
	}

	@Override
	public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {

		resetUpdateXmlElementTableName(element);
		return super.sqlMapUpdateByExampleWithBLOBsElementGenerated(element, introspectedTable);
	};

	@Override
	public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {

		resetUpdateXmlElementTableName(element);
		return super.sqlMapUpdateByExampleWithBLOBsElementGenerated(element, introspectedTable);
	}

	@Override
	public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {

		resetUpdateXmlElementTableNameNotMapType(element);
		return super.sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable);
	};

	@Override
	public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		resetUpdateXmlElementTableNameNotMapType(element);
		return super.sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable);
	};

	@Override
	public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

		resetInsertXmlElementTableName(element);
		return super.sqlMapInsertElementGenerated(element, introspectedTable);
	}

	@Override
	public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		resetInsertXmlElementTableName(element);
		return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);

	};

	@Override
	public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		resetDeleteXmlElementTableName(element);
		return super.sqlMapDeleteByExampleElementGenerated(element, introspectedTable);
	}

	private void resetSelectXmlElementTableName(XmlElement element) {
		List<Element> elements = element.getElements();

		for (int index = 0; index < elements.size(); index++) {
			Element el = elements.get(index);
			String string = el.getFormattedContent(0);
			if (string.startsWith("from")) {
				TextElement subSentence = new TextElement("from ${" + tableName + "}");
				elements.set(index, subSentence);
				break;
			}

		}

	}

	private void resetInsertXmlElementTableName(XmlElement element) {
		List<Element> elements = element.getElements();
		for (int index = 0; index < elements.size(); index++) {
			Element el = elements.get(index);
			String content = el.getFormattedContent(0);
			if (content.trim().startsWith("insert into")) {
				String[] data = content.split(" ");
				data[2] = "${" + tableName + "}";
				TextElement subSentence = new TextElement(MysqlSplitingTablePlugin.join(" ", data));
				elements.set(index, subSentence);
				break;
			}
		}
	}

	private void resetDeleteXmlElementTableName(XmlElement element) {

		List<Element> elements = element.getElements();
		String content = elements.get(0).getFormattedContent(0);
		String[] data = content.split(" ");
		data[2] = "${" + tableName + "}";
		TextElement subSentence = new TextElement(MysqlSplitingTablePlugin.join(" ", data));
		elements.set(0, subSentence);
	}

	private void resetUpdateXmlElementTableName(XmlElement element) {
		List<Element> elements = element.getElements();
		TextElement subSentence = new TextElement("update ${record." + tableName + "}");
		elements.set(0, subSentence);
	}

	private void resetUpdateXmlElementTableNameNotMapType(XmlElement element) {
		List<Element> elements = element.getElements();
		TextElement subSentence = new TextElement("update ${" + tableName + "}");
		elements.set(0, subSentence);
	}

	private void resetCountByExample(XmlElement element) {
		List<Element> elements = element.getElements();
		String content = elements.get(0).getFormattedContent(0);
		String[] data = content.split(" ");
		data[3] = "${" + tableName + "}";
		TextElement subSentence = new TextElement(MysqlSplitingTablePlugin.join(" ", data));
		elements.set(0, subSentence);
	}

	public static String join(String join, String[] strAry) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strAry.length; i++) {
			if (i == (strAry.length - 1)) {
				sb.append(strAry[i]);
			} else {
				sb.append(strAry[i]).append(join);
			}
		}
		return new String(sb);
	}
}