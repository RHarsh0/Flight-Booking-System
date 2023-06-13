package entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Flight {

	@Id
	private String FlightNumber;
	private LocalDateTime Arrival;
	private LocalDateTime Departure;
	private double price;
	@OneToMany(mappedBy = "flight")
	private Set<Booking> booking;
	@OneToMany(mappedBy = "flight")
	private Set<CancelBooking> cancel;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Flight_number=" + FlightNumber + "\n"+
	           "Arrival=" + Arrival + "\n"+
			   "Departure=" + Departure+ "\n" +
			   "price=" + price ;
	}

	public Flight(String flightNumber, LocalDateTime arrival, LocalDateTime departure, double price,
			Set<Booking> booking, Set<CancelBooking> cancel) {
		super();
		FlightNumber = flightNumber;
		Arrival = arrival;
		Departure = departure;
		this.price = price;
		this.booking = booking;
		this.cancel = cancel;
	}

	public String getFlightNumber() {
		return FlightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		FlightNumber = flightNumber;
	}

	public LocalDateTime getArrival() {
		return Arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		Arrival = arrival;
	}

	public LocalDateTime getDeparture() {
		return Departure;
	}

	public void setDeparture(LocalDateTime departure) {
		Departure = departure;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	public Set<CancelBooking> getCancel() {
		return cancel;
	}

	public void setCancel(Set<CancelBooking> cancel) {
		this.cancel = cancel;
	}
	
	
}
