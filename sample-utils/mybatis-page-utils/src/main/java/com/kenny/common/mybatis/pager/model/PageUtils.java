package com.kenny.common.mybatis.pager.model;

import java.util.List;

public class PageUtils {

	public static <T> Page<T> makePage(Page<T> page, List<T> records, int total) {
		if (page == null) {
			page = Page.makePageByOffsetRecord(0, 0);
		}
		page.setRecords(records);
		page.setTotal(total);
		return page;
	}

	public static <T> Page<T> makePage(int offset, int limit) {
		if (limit == 0)
			throw new IllegalArgumentException("分页大小不能为0");
		Page<T> page = Page.makePageByOffsetRecord(offset, limit);
		page.setPageSize(limit);
		return page;
	}

}
