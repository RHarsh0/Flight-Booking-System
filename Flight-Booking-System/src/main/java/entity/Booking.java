package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int BookingId;
	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "FlightNumber")
	private Flight flight;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(Customer customer, Flight flight) {
		super();
		this.customer = customer;
		this.flight = flight;
	}
	public int getBookingId() {
		return BookingId;
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
		return "BookingId=" + BookingId + "\n"+
	           "customer ->" + "\n"+ customer.toString() + "\n"+
				"flight ->" +  "\n"+ flight.toString() +"\n";
	           
	}
	
	
	
}
