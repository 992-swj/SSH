package com.swj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.swj.bean.Userinfo;
import com.swj.dao.UserInfoDao;

public class UserInfoDaoImpl extends HibernateDaoSupport implements UserInfoDao {

	@Override
	public Userinfo Loginfunction(String username) {
		Session session = this.getSession();
		String hql = " from Userinfo where username=?";
		Query query = session.createQuery(hql);
		List<Userinfo> find = this.getHibernateTemplate().find(hql, username);
		session.close();
		return find.size() == 0 ? null : find.get(0);
	}
}
