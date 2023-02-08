package com.pks.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.memo.common.EncryptUtils;
import com.pks.memo.user.dao.UserDAO;

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
		
		// 암호화
		String encryptPassword = EncryptUtils.md5(password); // 암호화시키고 싶은 문자열은 넣어준다
		
		
		
		
		
		return userDAO.insertUser(loginId, encryptPassword, name, email);
	}
	
	
}
