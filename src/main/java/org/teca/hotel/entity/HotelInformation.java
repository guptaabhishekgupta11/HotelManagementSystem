package org.teca.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HotelInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotelid;
	@Column(name = "Hotel_name", nullable = false)
	private String hotelname;
	@Column(name = "Hotel_contact_number", unique = true, nullable = false)
	private String contactnumber;
	@Column(name = "Room_price", nullable = false)
	private double price;
	@Column(name = "city_name")
	private String city;
	@Column(name = "Hotel_Address")
	private String address;
}
