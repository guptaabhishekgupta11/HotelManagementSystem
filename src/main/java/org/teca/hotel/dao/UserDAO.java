package org.teca.hotel.dao;

import org.teca.hotel.entity.UserInformation;

public interface UserDAO {
	void addUserDetails(UserInformation userinfo);
	UserInformation validation(String emailid,String password);
}
