package com.OSB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.OSB.Model.Seat;
import com.OSB.Repository.SeatRepo;
import com.OSB.Service.SeatService;

@SpringBootTest
public class SeatTest {
    @MockBean
    private SeatRepo repository;
    @Autowired
    private SeatService service;
    @Test
    public void saveSeat() {
        Seat seatAvailability = new Seat(3, "chennai", 90);
        when(repository.save(seatAvailability)).thenReturn(seatAvailability);
        assertEquals(seatAvailability, service.addSeat(seatAvailability));
    }
    @Test
    public void findBylocationId() {
    int locationId = 2;
    Optional<Seat> seat = Optional.of(new Seat(2, "electroinc city", 135));
    when(repository.findBylocationId(locationId)).thenReturn(seat);
    assertEquals(seat, service.findBylocationId(locationId));
    }
}
