package com.swj.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.swj.bean.Bookinfo;
import com.swj.service.BookInfoService;

public class LimitAction {
	
	public String getlimit(){
		list=new ArrayList<Bookinfo>();
		System.out.println("½øÈëgetlimit");
		map=new HashMap<String, Object>();
		map.put("title", title);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", 3);
		list=services.getLimit(map);
		return "success";
	}
	
	private BookInfoService services;
	
	public BookInfoService getServices() {
		return services;
	}
	public void setServices(BookInfoService services) {
		this.services = services;
	}
	
	private Integer pageIndex=1;
	private String title;
	private List<Bookinfo> list;
	private Map<String, Object> map;

	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Bookinfo> getList() {
		return list;
	}
	public void setList(List<Bookinfo> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	
}
