package org.teca.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.hotel.dao.HotelDAO;
import org.teca.hotel.dao.UserDAO;
import org.teca.hotel.entity.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userdao;
	@Autowired
	private HotelDAO hoteldao;
	@RequestMapping("/userregistration")
	public String userRegistrationPage() {	
		return "AddUsers";
	}
	
	@RequestMapping("/userlogin")
	public String userLogin() {
		return "Login";
	}
	
	@RequestMapping("/loginvalidation")
	public String userValidation(String email, String password,Model model,HttpServletRequest request) {
		UserInformation valid = userdao.validation(email, password);
		HttpSession session = request.getSession();
		session.setAttribute("user", valid);
		if (valid != null) {
			List<HotelInformation> list = hoteldao.getAllHotelDetails();
			model.addAttribute("HotelDetails", list);
			return "HotelList";
		}
		else {
			return "Login";
		}
	}
	
	@RequestMapping("/userdetails")
	public String userDetails(UserInformation userInformation) {
		userdao.addUserDetails(userInformation);
		System.out.println(userInformation);	
		return "Login";
	}
	
	@RequestMapping("/searchByCity")
	public String getCity(String city,Model model) {
		List<HotelInformation> info = hoteldao.getHotelsByCity(city);
		if (info.isEmpty()) {
			return "HotelList";
		}
		else {
			model.addAttribute("HotelDetails", info);
			return "HotelList";
		}
	}
}
	