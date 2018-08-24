package com.jianpu.model;

import java.io.Serializable;
import java.util.List;

public class PageDTO1 implements Serializable{
	
	private Integer total; 
	private List<User> rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<User> getRows() {
		return rows;
	}
	public void setRows(List<User> rows) {
		this.rows = rows;
	}
	
	
}
