package com.kenny.common.mybatis.pager.model;

import org.apache.ibatis.session.RowBounds;

public class PageBounds extends RowBounds {

	/**
	 * 总记录数
	 */
	private int total;

	public PageBounds() {
		super();
	}

	public PageBounds(int offset, int limit) {
		super(offset, limit);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PagingBounds [offset=" + getOffset() + ", limit=" + getLimit() + ", total=" + total + "]";
	}

}
