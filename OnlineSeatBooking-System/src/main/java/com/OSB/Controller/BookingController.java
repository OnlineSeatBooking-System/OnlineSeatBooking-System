package com.OSB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.OSB.Model.Booking;
import com.OSB.Service.BookingService;



@RestController
@RequestMapping("/Booking")
public class BookingController {

	@Autowired
	 BookingService service;
	
	@PostMapping("/book")
	@ResponseBody
	public ResponseEntity<String> addBooking(@RequestBody Booking b) {
		Booking bo=service.addBooking(b);
	
		
		return new ResponseEntity<String> ("Seat Booked Successfully", HttpStatus.OK);

	}
}
