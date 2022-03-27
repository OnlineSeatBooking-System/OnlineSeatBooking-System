package com.OSB.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.OSB.Model.Seat;
import com.OSB.Repository.SeatRepo;
@Service
@Component
public class SeatService {
     @Autowired
     SeatRepo repo;
     public Seat addSeat(Seat s)
     {
         return repo.save(s);
     }
          public Optional<Seat> findByLocationId(int locationId)
          {
          return repo.findByLocationId(locationId);
          }
        public void updateSeatAvailabilityByLocationId(Seat s)
        {
               repo.save(s);
        }
    public Optional<Seat> findBylocationId(int locationId)
    { 
        return repo.findBylocationId(locationId);
    }
}