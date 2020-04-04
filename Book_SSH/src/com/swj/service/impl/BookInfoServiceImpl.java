package com.swj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swj.bean.Bookinfo;
import com.swj.dao.BookInfoDao;
import com.swj.service.BookInfoService;

public class BookInfoServiceImpl implements BookInfoService {
	private BookInfoDao bookdao;

	@Override
	public List<Bookinfo> getLimit(Map<String, Object> map) {
		List<Bookinfo> limit = bookdao.getLimit(map);
		return limit;
	}

	@Override
	public void add(Bookinfo bookinfo) {
		System.out.println("Ìí¼Ó·½·¨");
		this.bookdao.add(bookinfo);
	}

	@Override
	public int getBookInfoCount(Map<String, Object> map) {
		return bookdao.getBookInfoCount(map);
	}

	public BookInfoDao getBookdao() {
		return bookdao;
	}

	public void setBookdao(BookInfoDao bookdao) {
		this.bookdao = bookdao;
	}

}
