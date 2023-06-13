package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class CancelBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CancelationId;
	private int BookingId;
	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "FlightNumber")
	private Flight flight;
	public CancelBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CancelBooking(int bookingId, Customer customer, Flight flight) {
		super();
		BookingId = bookingId;
		this.customer = customer;
		this.flight = flight;
	}
	public int getCancelationId() {
		return CancelationId;
	}
	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	@Override
	public String toString() {
		return "CancelationId=" + CancelationId + "\n"+
	           "BookingId=" + BookingId + "\n"+
			   "customer=" + customer+ "\n"
				+ ", flight=" + flight;
	}
	
	
}
