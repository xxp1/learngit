package com.jianpu.model;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
	private int id;
	private String name;
	private String icon;
	private String href;
	private int p_id;
	
	private List<Menu> list;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	public Menu(int id, String name, String icon, String href, int p_id,
			List<Menu> list) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.href = href;
		this.p_id = p_id;
		this.list = list;
	}
	public List<Menu> getList() {
		return list;
	}
	public void setList(List<Menu> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", icon=" + icon
				+ ", href=" + href + ", p_id=" + p_id + ", list=" + list + "]";
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
