package org.teca.hotel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@Column(name = "user-fistname")
	private String firstname;
	@Column(name = "user_lastname")
	private String lastname;
	@Column(name = "user_email_Id", unique = true,nullable = false)
	private String emailid;
	@Column(name = "user_password",nullable = false, length = 4)
	private String password;
	@Column(name = "Date_of_Birth")
	private LocalDate dateofbirth;
	@Column(name = "user_mobile_number", unique = true,nullable = false,length = 10)
	private String mobilenumber;
	private String gender;
}
