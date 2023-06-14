package service;

import java.time.LocalDate;

import dao.CustomerDAOImpl;
import dao.ICustomerDAO;
import entity.Customer;
import exception.NoFlightsFound;

public class CustomerServiceImpl implements ICustomerService{

	@Override
	public void registerNewCustomer(Customer customer) {
		
		ICustomerDAO obj = new CustomerDAOImpl();
		obj.registerNewCity(customer);
		
	}

	@Override
	public void byDepartureCity(String city) throws NoFlightsFound{
		
		ICustomerDAO obj = new CustomerDAOImpl();
		obj.byDepartureCity(city);
		
	}

	@Override
	public void byDestination(String city) throws NoFlightsFound{
		ICustomerDAO obj = new CustomerDAOImpl();
		obj.byDestination(city);
		
	}

	@Override
	public void byDates(LocalDate date)throws NoFlightsFound {
		ICustomerDAO obj = new CustomerDAOImpl();
		obj.byDates(date);
		
	}

	@Override
	public void byPrice(double lower,double higher)throws NoFlightsFound {
		ICustomerDAO obj = new CustomerDAOImpl();
		obj.byPrice(lower,higher);
		
	}

	@Override
	public void bySeats(int seats)throws NoFlightsFound {
		ICustomerDAO obj = new CustomerDAOImpl();
		obj.bySeats(seats);
		
	}

	@Override
	public void bookYourNewFlight(Customer customer,String number) {
		ICustomerDAO obj = new CustomerDAOImpl();
		obj.bookYourNewFlight(customer,number);

		
	}

	@Override
	public void viewAllYourBooking(Customer customer) {
		ICustomerDAO obj = new CustomerDAOImpl();
		obj.viewAllYourBooking(customer);
		
	}

	@Override
	public void cancelAnyYourBooking(Customer customer,int bookingId) {
		ICustomerDAO obj = new CustomerDAOImpl();
		obj.cancelAnyYourBooking(customer,bookingId);
		
	}


	
}
