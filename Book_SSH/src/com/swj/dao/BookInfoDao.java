package com.swj.dao;

import java.util.List;
import java.util.Map;

import com.swj.bean.Bookinfo;

public interface BookInfoDao {
	//��ҳ
	List<Bookinfo> getLimit(Map<String, Object> map);
	//��ѯ�ܼ�¼��
	int getBookInfoCount(Map<String, Object> map);
	//���
	void add(Bookinfo bookinfo);
	
}
