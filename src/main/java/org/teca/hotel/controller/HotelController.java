package org.teca.hotel.controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.hotel.dao.HotelDAO;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
public class HotelController {
	
	@Autowired
	private HotelDAO hoteldao;
	@RequestMapping("/getHotel")
	public String getHotel() {
		return "AddHotel";
	}
	
	@RequestMapping("/hoteldetails")
	public void hotelDetails(HotelInformation hotelinformation) {
		hoteldao.addHotelDetails(hotelinformation); 
	}
	
	@RequestMapping("/gethotelbyid")
	public String getHotelId(Integer id,Model model,HttpServletRequest request) {
		HotelInformation info = hoteldao.getHotelById(id);
		model.addAttribute("hotelname",info.getHotelname());
		model.addAttribute("price", info.getPrice());
		HttpSession session=request.getSession();
		UserInformation information= (UserInformation) session.getAttribute("user");
		model.addAttribute("bookinghotel",information);
		return "BookHotel";
	}
}
