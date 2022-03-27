package com.OSB.Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Booking")
public class Booking implements Serializable {
      private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	    
	   
		private int bookingId;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name = "locationId")
	
	   private Seat seat;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId")

	   private User user;
	
	
		 public Booking(int bookingId, String bookingStatus) { 
			 super();
		  this.bookingId = bookingId;
		  this.bookingStatus = bookingStatus;
		  }
		 
		private Date bookingDate;
		private String bookingStatus;
		public int getBookingId() {
			return bookingId;
		}
		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}
		public Seat getSeat() {
			return seat;
		}
		public void setSeat(Seat seat) {
			this.seat = seat;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Date getBookingDate() {
			return bookingDate;
		}
		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}
		public String getBookingStatus() {
			return bookingStatus;
		}
		public void setBookingStatus(String bookingStatus) {
			this.bookingStatus = bookingStatus;
		}
		@Override
		public String toString() {
			return "Booking [bookingId=" + bookingId + ", seat=" + seat + ", user=" + user + ", bookingDate="
					+ bookingDate + ", bookingStatus=" + bookingStatus + "]";
		}
		public Booking() {
			super();
			
		}
		
		
		
		
	
	}
