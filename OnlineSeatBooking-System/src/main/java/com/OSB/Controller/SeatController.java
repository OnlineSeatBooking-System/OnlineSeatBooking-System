package com.OSB.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OSB.Exception.ResourceNotFoundException;
import com.OSB.Model.Seat;
import com.OSB.Service.SeatService;
@RestController
@RequestMapping("/Seat")
public class SeatController {
    @Autowired
    SeatService service;
    @PostMapping("/add")
    public ResponseEntity<String> addSeat(@RequestBody Seat s) {
        Seat se = service.addSeat(s);
        return new ResponseEntity<String>("Record inserted successfully", HttpStatus.OK);
    }
    @PutMapping("/updateSeatAvailabilityById")
    public ResponseEntity<String> updateSeatAvailabilityByLocationId(@Validated @RequestBody Seat s)
    {
        String status = null;
        Optional<Seat> obj = service.findByLocationId(s.getLocationId());
        if (obj.isPresent())
        {
            service.updateSeatAvailabilityByLocationId(s);
            status = "Successfully Updated";
        }
        else {
            throw new ResourceNotFoundException("Id is not Available");
        }
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
    @GetMapping("/SearchSeat/{locationId}")
    public ResponseEntity<String> findBylocationId(@PathVariable int locationId) {
        String status = null;
        Optional<Seat> s = service.findBylocationId(locationId);
        if (s.isPresent()) {
            service.findBylocationId(locationId);
            status = s.get() + " ";
        } else {
            throw new ResourceNotFoundException("LocationId Not Found");
        }
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
}
