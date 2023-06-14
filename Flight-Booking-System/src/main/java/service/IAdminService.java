package service;

import java.time.LocalDateTime;

import entity.Admin;
import entity.Flight;
import exception.NoFlightsFound;

public interface IAdminService {

	 public void registerNewAdmin(Admin admin);
	 public void addNewFlight(Flight flight);
	 public void updateFlightDetails(String flightNumber, LocalDateTime arrival, LocalDateTime departure, double price) throws NoFlightsFound;
	 public void removeFlight(String flightNumber)throws NoFlightsFound;
	 public void generateFlightDetails();
}
