package com.swj.action;

import com.swj.bean.Bookinfo;
import com.swj.service.BookInfoService;

public class BookAddAction {
	private BookInfoService services;
	
	public String add(){
		services.add(bookinfo);
		System.out.println("����Ϊ"+bookinfo.toString());
		System.out.println("��֪���Ƿ���ӳɹ�����鿴���ݿ�!!!");
		return "success";
	}
	
	
	private Bookinfo bookinfo;


	public BookInfoService getServices() {
		return services;
	}


	public void setServices(BookInfoService services) {
		this.services = services;
	}


	public Bookinfo getBookinfo() {
		return bookinfo;
	}


	public void setBookinfo(Bookinfo bookinfo) {
		this.bookinfo = bookinfo;
	}
	
}
