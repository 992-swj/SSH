package com.swj.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.swj.bean.Userinfo;
import com.swj.service.UserInfoService;

public class LoginAction {

	private UserInfoService service;

	public String login() {
		Userinfo userinfo = service.Loginfunction(username);
		if (userinfo != null && password.equals(userinfo.getUserpwd())) {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("userinfo", userinfo);
			return "success";
		} else {
			message = "”√ªß√˚°¢√‹¬Î¥ÌŒÛ";
			return "error";
		}
	}

	private String message;
	private String username;
	private String password;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserInfoService getService() {
		return service;
	}

	public void setService(UserInfoService service) {
		this.service = service;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
