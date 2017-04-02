package org.v3.wpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.v3.wpm.dao.DAOImpl;
import org.v3.wpm.model.User;

@Controller
public class WPMController {

	@Autowired
	private DAOImpl doaImpl;

	@RequestMapping(method = RequestMethod.GET, value = "/create", params = { "userName", "password", "role" })
	@ResponseBody
	public String create(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("role") String role) {
		try {
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setRole(role);
			doaImpl.create(user);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return "User Successfully created. Welcome to WPM !!!";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAll")
	@ResponseBody
	public List<User> getAll() {
		List<User> users = null;
		try {
			users = doaImpl.getAll();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return users;
	}

}
