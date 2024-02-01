package org.teca.hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.UserInformation;
import org.teca.hotel.repository.UserRepository;
@Component
public class UserDaoImpl implements UserDAO{
	@Autowired
	private UserRepository userrepository;
	@Override
	public void addUserDetails(UserInformation userinfo) {
		UserInformation info = userrepository.save(userinfo);
		System.out.println(info);
	}
	@Override
	public UserInformation validation(String emailid,String password) {
		UserInformation info =  userrepository.findByEmailidAndPassword(emailid, password);
		return info;
	}
}
