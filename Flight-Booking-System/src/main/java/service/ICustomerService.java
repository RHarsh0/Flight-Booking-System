package service;

import java.time.LocalDate;
import java.util.Scanner;

import entity.Customer;
import exception.NoFlightsFound;

public interface ICustomerService {

	public void registerNewCustomer(Customer customer);
	public void byDepartureCity(String city) throws NoFlightsFound;
	public void byDestination(String city)throws NoFlightsFound;
	public void byDates(LocalDate date)throws NoFlightsFound;
	public void byPrice(double lower,double higher)throws NoFlightsFound;
	public void bySeats(int seats)throws NoFlightsFound;
	public void bookYourNewFlight(Customer customer,String number);
	public void viewAllYourBooking(Customer customer);
	public void cancelAnyYourBooking(Customer customer,int bookingId);
}
