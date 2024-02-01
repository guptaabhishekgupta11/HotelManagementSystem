package org.teca.hotel.dao;

import java.util.List;

import org.teca.hotel.entity.HotelInformation;

public interface HotelDAO {
	void addHotelDetails(HotelInformation hotelinfo);
	List<HotelInformation> getAllHotelDetails();
	List<HotelInformation> getHotelsByCity(String city);
	HotelInformation getHotelById(int hotelid);
}
