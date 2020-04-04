package com.swj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.swj.bean.Bookinfo;
import com.swj.dao.BookInfoDao;

public class BookInfoDaoImpl extends HibernateDaoSupport implements BookInfoDao {

	@Override
	public List<Bookinfo> getLimit(Map<String, Object> map) {
		Session session = this.getSession();
		// ��ǰҳ
		int pageIndex = Integer.parseInt(map.get("pageIndex").toString());
		// ҳ��С
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		// ��ȡ����
		Object title = map.get("title");
		
		Map<String, Object> info = new HashMap<String, Object>();
		// ��ҳ
		String hql = " from Bookinfo where 1=1 ";
		if (title != null && title.toString().length() > 0) {
			hql += " and title like :title";
			info.put("title", "%" + title.toString() + "%");
		}
		Query query = session.createQuery(hql);
		query.setProperties(info);
		query.setMaxResults(pageSize);
		query.setFirstResult((pageIndex - 1) * pageSize);
		List<Bookinfo> list = query.list();

		for (Bookinfo bookinfo : list) {
			System.out.println(bookinfo.getTitle());
		}

		// ������ҳ��
		int bookInfoCount =getBookInfoCount(map);
		int SumIndex = (bookInfoCount + pageSize - 1) / pageSize;
		// ��һҳ
		int prev = 0;
		if (pageIndex <= 1) {
			prev = 1;
		} else {
			prev = pageIndex - 1;
		}
		// ��һҳ
		int next = 0;
		if (pageIndex >= SumIndex) {
			next = SumIndex;
		} else {
			next = pageIndex + 1;
		}
		
		map.put("pageIndex", pageIndex);
		map.put("BookName", title);
		map.put("prev", prev);
		map.put("next", next);
		map.put("SumIndex", SumIndex);
		map.put("bookInfoCount", bookInfoCount);
		session.close();
		return list;
	}

	@Override
	public int getBookInfoCount(Map<String, Object> map) {
		Session session = this.getSession();
		String hql = "select count(*) from Bookinfo where 1=1";
		Object title = map.get("title");
		Map<String, Object> info = new HashMap<String, Object>();
		if (title != null && title.toString().length() > 0) {
			hql += " and title like :title";
			info.put("title", "%" + title.toString() + "%");
		}
		Query query = session.createQuery(hql);
		query.setProperties(info);
		Long longs = (Long) query.setProperties(map).uniqueResult();
		session.close();
		return Integer.parseInt(longs.toString());
	}

	@Override
	public void add(Bookinfo bookinfo) {
		System.out.println("========������ӣ����Ե�");
		Object o=this.getHibernateTemplate().save(bookinfo);
		System.out.println("��֪����ʲô��"+o);
	}
}
