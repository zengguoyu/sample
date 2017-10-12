package com.kenny.common.mybatis.pager.page;

import java.util.List;

import com.kenny.common.mybatis.pager.model.PageBoundsRecord;

public interface DbExecutor<T> {

	public List<T> doQuery(PageBoundsRecord<T> pagingBounds);
}
