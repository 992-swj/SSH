package com.swj.service.impl;

import com.swj.bean.Userinfo;
import com.swj.dao.UserInfoDao;
import com.swj.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDao infoDao;
	
	@Override
	public Userinfo Loginfunction(String username) {
		Userinfo userinfo = infoDao.Loginfunction(username);
		return userinfo;
	}

	public UserInfoDao getInfoDao() {
		return infoDao;
	}

	public void setInfoDao(UserInfoDao infoDao) {
		this.infoDao = infoDao;
	}
	
	
	

}
