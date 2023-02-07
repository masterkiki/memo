package com.pks.memo.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.memo.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	

	public int addUser(
			String loginId
			, String password
			, String name
			, String email
			) {
		return userDAO.insertUser(loginId, password, name, email);
	}
	
}
