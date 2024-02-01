package org.teca.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.teca.hotel.entity.HotelInformation;
import java.util.List;


public interface HotelRepository extends JpaRepository<HotelInformation, Integer>{
	 @Query("select hotel from HotelInformation hotel where hotel.city like %?1% or hotel.hotelname like %?1%")
	 List<HotelInformation> findByCity(String city);
}
