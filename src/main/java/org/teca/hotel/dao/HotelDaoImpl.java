package org.teca.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.repository.HotelRepository;

@Component
public class HotelDaoImpl implements HotelDAO{
	@Autowired
	private HotelRepository hotelrepository;
	@Override
	public void addHotelDetails(HotelInformation hotelinfo) {
		HotelInformation hotel = hotelrepository.save(hotelinfo);
		System.out.println(hotel);
	}
	@Override
	public List<HotelInformation> getAllHotelDetails() {
		List<HotelInformation> hotelInfo = hotelrepository.findAll();
		return hotelInfo;
	}
	@Override
	public List<HotelInformation> getHotelsByCity(String city) {
		return hotelrepository.findByCity(city);
	}
	@Override
	public HotelInformation getHotelById(int hotelid) {
		HotelInformation information = hotelrepository.findById(hotelid).orElse(new HotelInformation());
		return information;
	}
}

