package com.swj.service;

import java.util.List;
import java.util.Map;

import com.swj.bean.Bookinfo;

public interface BookInfoService {
	// 分页
	List<Bookinfo> getLimit(Map<String, Object> map);

	// 查询总记录数
	int getBookInfoCount(Map<String, Object> map);

	// 添加
	void add(Bookinfo bookinfo);
}
