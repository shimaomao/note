package com.pangciyuan.note.common.model;

import com.github.pagehelper.PageInfo;

public class PageParameter {
	// 当前页数
	private Integer pageNum;
	// 每页行数
	private Integer pageSize;
	// 总条数
	private long total;
	// 总页数
	private Integer pages;

	public Integer getPageNum() {
		return pageNum;
	}

	public PageParameter() {
		super();
	}

	public PageParameter(PageInfo<?> pageInfo) {
		this.setPageNum(pageInfo.getPageNum()).setPages(pageInfo.getPages()).setPageSize(pageInfo.getPageSize())
				.setTotal(pageInfo.getTotal());
	}

	public PageParameter setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
		return this;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public PageParameter setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public long getTotal() {
		return total;
	}

	public PageParameter setTotal(long total) {
		this.total = total;
		return this;
	}

	public Integer getPages() {
		return pages;
	}

	public PageParameter setPages(Integer pages) {
		this.pages = pages;
		return this;
	}

}
