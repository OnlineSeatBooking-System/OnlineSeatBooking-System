package com.OSB.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Seat")
public class Seat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationId;
    @NotNull(message = "Location Name must not be Empty")
    private String locationName;
    @NotNull(message = "Seats must not be Empty")
    private int seatAvailable;
    
@OneToOne(cascade = CascadeType.ALL , mappedBy = "seat")
	
	private Booking booking;
    
    public Seat() {
        super();
    }
    public Seat(int locationId, String locationName,int seatAvailable) {
        super();
        this.locationId = locationId;
        this.locationName = locationName;
        this.seatAvailable = seatAvailable;
    }
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public int getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	@Override
	public String toString() {
		return "Seat [locationId=" + locationId + ", locationName=" + locationName + ", seatAvailable=" + seatAvailable
				+ ", booking=" + booking + "]";
	}
	
    
}
