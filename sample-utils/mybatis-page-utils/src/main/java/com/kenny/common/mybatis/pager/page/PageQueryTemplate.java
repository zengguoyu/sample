package com.kenny.common.mybatis.pager.page;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.kenny.common.mybatis.pager.model.Page;
import com.kenny.common.mybatis.pager.model.PageBoundsRecord;
import com.kenny.common.mybatis.pager.model.PageUtils;

/**
 * Mybatis 分页查询模板
 * 
 * <pre>
 * 1.spring配置文件中引入schemas
 * <code>
 * xmlns:pager="http://eep.sippr.com/schema/mybatis/pager"
 * xsi:schemaLocation="
 * &nbsp;&nbsp;&nbsp;&nbsp;http://eep.sippr.com/schema/mybatis/pager
 * &nbsp;&nbsp;&nbsp;&nbsp;http://eep.sippr.com/schema/mybatis/pager/pager.xsd">
 * </code>
 * </pre>
 * 
 * <pre>
 * 2.在spring配置文件配置分页
	&lt;pager:annotation-driven dialect="DIALECT_MYSQL"
	 pageInterceptorId="pageInterceptor"/&gt;
 * </pre>
 * 
 * <pre>
 * 3.向mybatis注册分页插件
 * 
 *&lt;bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean"&gt;
 *&nbsp;&nbsp;&nbsp;&nbsp;&lt;property name="configuration" ref="configuration" /&gt;
 *&nbsp;&nbsp;&nbsp;&nbsp;&lt;property name="dataSource" ref="dataSource" /&gt;
 *&nbsp;&nbsp;&nbsp;&nbsp;&lt;property name="mapperLocations" value="classpath*:/mybatis/ ** /* Mapper.xml"/&gt;
 *<strong>
 *&nbsp;&nbsp;&nbsp;&nbsp;&lt;property name="plugins"&gt;
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;list&gt;
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;ref bean="pageInterceptor" /&gt;
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/list&gt;
 *&nbsp;&nbsp;&nbsp;&nbsp;&lt;/property&gt;
 *</strong>
 *&lt;/bean&gt;
 * </pre>
 * 
 * 
 * 4.使用分页
 * 
 * <pre>
 * return PageQueryTemplate.selectByPage(page, new DbExecutor<T>() {
 * 	&#64;Override
 * 	public List<T> doQuery(PageBoundsRecord<T> pagingBounds) {
 * 
 * 		return XXXServiceImpl.this.xxxMapper.selectByExample(example,<strong> pagingBounds</strong>);
 * 	}
 * });
 * </pre>
 * 
 * 
 * @author ZengGuoyu
 * 
 */
public class PageQueryTemplate {

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            分页参数，如果page==<code>null</code>表示不执行分页，查出全部数据
	 *            {@link Page#makePageByOffsetRecord(int offset, int limit)},
	 *            {@link Page#makePageByPageNumber(int pageNumber, int pageSize)}
	 * @param executor
	 *            数据库查询器，执行常规的数据库查询,。
	 * 
	 * @return
	 */
	public static <T> Page<T> selectByPage(Page<T> page, DbExecutor<T> executor) {
		if (page == null) {
			page = Page.makePageByOffsetRecord(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);
		}
		PageBoundsRecord<T> pagingBounds = new PageBoundsRecord<T>(page.getStartIndex(), page.getPageSize());
		List<T> list = executor.doQuery(pagingBounds);
		PageUtils.makePage(page, list, pagingBounds.getTotal());
		return page;
	}
}
