package com.OSB.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OSB.Model.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer>{
	
    Optional<Seat> findByLocationId(int locationId);
    public Optional<Seat> findBylocationId(int locationId);
    
}
