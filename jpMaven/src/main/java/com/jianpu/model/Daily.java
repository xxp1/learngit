package com.jianpu.model;

import java.io.Serializable;
import java.util.Date;

public class Daily implements Serializable {
	private int id;
	private String username;
	private Date  date;
	private String detail;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Daily [id=" + id + ", username=" + username + ", date=" + date
				+ ", detail=" + detail + ", type=" + type + "]";
	}
	public Daily(int id, String username, Date date, String detail, String type) {
		super();
		this.id = id;
		this.username = username;
		this.date = date;
		this.detail = detail;
		this.type = type;
	}
	public Daily() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
