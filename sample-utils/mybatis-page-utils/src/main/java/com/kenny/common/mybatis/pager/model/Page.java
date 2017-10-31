/**
 * 
 */
package com.kenny.common.mybatis.pager.model;

import java.util.List;

/**
 * @author SenVon
 *
 */
public class Page<T> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int DEFAULT_COUNT = 20;

	private int startIndex = 0;
	private int pageNo = 1;
	private int pageTotal = 1;

	/**
	 * 获取当前页
	 * 
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getPageTotal() {
		return pageTotal;
	}

	/**
	 * 默认的分页大小 20
	 */
	private int pageSize = DEFAULT_COUNT;

	/**
	 * 当前查询的记录数
	 */
	private int total = 0;

	private List<T> records;

	/**
	 * 构建分页对象
	 * 
	 * @param pageNumber
	 *            当前页码
	 * @param pageSize
	 *            分页大小,必须大于等于1
	 * @return
	 * @throws IllegalArgumentException
	 *             当pageSize<1时
	 */
	public static <T> Page<T> makePageByPageNumber(int pageNumber, int pageSize) throws IllegalArgumentException {
		Page<T> page = new Page<>();

		if (pageSize >= 1) {
			page.setPageSize(pageSize);
		} else {
			throw new IllegalArgumentException("请设置有效的分页大小！");
		}

		if (pageNumber < 1) {
			page.startIndex = 0;
		} else {
			page.startIndex = (pageNumber - 1) * page.pageSize;
		}

		return page;

	}

	/**
	 * 构建分页对象
	 * 
	 * @param offset
	 *            分页偏移量
	 * @param pageSize
	 *            分页大小，当pageSize<=0时，取pageSize=20;
	 * @return
	 */
	public static <T> Page<T> makePageByOffsetRecord(int offset, int pageSize) {
		Page<T> page = new Page<>();
		if (pageSize >= 1) {
			page.setPageSize(pageSize);
		}
		if (offset >= 0) {
			page.startIndex = offset;
		}
		return page;
	}

	private Page() {
	}

	/**
	 * 设置分页大小
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
	}

	/**
	 * 设置总记录数
	 * 
	 * @param total
	 */
	public void setTotal(int total) {
		this.total = total;

		// 记录总数后，计算当前页及总页数
		if (this.total <= 0) {
			this.pageNo = 1;
			this.pageTotal = 1;
		} else {
			// 向上取整
			this.pageTotal = (int) Math.ceil(total * 1.0f / getPageSize());
			this.pageNo = Math.min(getStartIndex() / getPageSize() + 1, this.pageTotal);
		}

	}

	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public int getTotal() {
		return this.total;
	}

	/**
	 * 分页大小
	 * 
	 * @return
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * 分页偏移量
	 * 
	 * @return
	 */
	public int getStartIndex() {
		return startIndex;
	}

	/**
	 * 数据记录
	 * 
	 * @param obj
	 */
	public void setRecords(List<T> obj) {
		this.records = obj;
	}

	/**
	 * 数据记录
	 * 
	 * @return
	 */
	public List<T> getRecords() {
		return records;
	}

	public int getNextPage() {
		return Math.min(this.pageNo + 1, this.pageTotal);
	}

	public int getPrePage() {
		return Math.max(this.pageNo - 1, 1);
	}

	@Override
	public String toString() {
		return "Page [startIndex=" + startIndex + ", pageSize=" + pageSize + ", total=" + total + ", records=" + records
				+ "]";
	}

}
