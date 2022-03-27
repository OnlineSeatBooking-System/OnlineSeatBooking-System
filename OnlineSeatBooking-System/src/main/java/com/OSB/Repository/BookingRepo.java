package com.OSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSB.Model.Booking;



@Repository

public interface BookingRepo extends JpaRepository<Booking, Integer> {


	
}
