package org.teca.hotel.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookingController 
{
  @RequestMapping("/data")
  public void getdata(BookingInformation information, Model model ){
	if(information.getBookingdata().isAfter(LocalDate.now())|| information.getBokingdata().isEqual(LocalDate.now())) {
		System.out.println("Valid data");
	}else {
		model.addAttribute("msg","Invalid data");
	}
  }
  
}
