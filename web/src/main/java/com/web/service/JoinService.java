package com.web.service;


import com.web.domain.Users;
import com.web.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UserPasswordHashClass userPasswordHashClass;

	public String joinUser(String userId , String userPw, String userName) {

		if (userId.equals("") || userPw.equals("") || userName.equals("")) {
			return "join";
		}

		Users users = new Users();
		users.setUserId(userId);
		String hashedPassword = userPasswordHashClass.getSHA256(userPw);
		users.setPassword(hashedPassword);
		users.setUsername(userName);

		usersRepository.save(users);
		return "index";
	}
}