package uimain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entity.Booking;
import entity.CancelBooking;
import entity.Customer;
import entity.Customer.Gender;
import entity.Customer.Kota;
import exception.NoFlightsFound;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import service.CustomerServiceImpl;
import service.ICustomerService;

public class CustomerSecondaryUI {

	
	public static void registerCustomer(Scanner sc) {
		System.out.println("Enter your name");
		String name = sc.next();
		System.out.println("Enter your age");
		int age = sc.nextInt();
		System.out.println("Enter your Gender");
		Gender gender = Gender.valueOf(sc.next().toUpperCase());
		System.out.println("Enter your Nationality");
		String nation = sc.next();
		System.out.println("Enter your category as Student or Disability or if neither of then give none");
		Kota kota = Kota.valueOf(sc.next().toUpperCase());
		System.out.println("Enter your username");
		String user =sc.next();
		System.out.println("Setup your password");
		String pass = sc.next();
		
		try {
			ICustomerService ics = new CustomerServiceImpl();
			
			Customer customer = new Customer(name,age,gender,nation, kota,user,pass,new HashSet<Booking>(),new HashSet<CancelBooking>());
			ics.registerNewCustomer(customer);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	public static void filterByDepartureCity(Scanner sc) {
		
		System.out.println("Enter the name of the departure city");
		String city = sc.next();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			ics.byDepartureCity(city);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void filterByDestination(Scanner sc) {
		System.out.println("Enter the name of the destination city");
		String city = sc.next();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			ics.byDestination(city);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void filterByDates(Scanner sc) {
		System.out.println("Enter the date on which you seek to travel in the format (yyyy-MM-dd)");
		LocalDate date  = LocalDate.parse(sc.next());
		try {
			ICustomerService ics = new CustomerServiceImpl();
			ics.byDates(date);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void filterByPriceRange(Scanner sc) {
		System.out.println("Enter the price range in which you seek to travel");
		System.out.println("Enter the lower limit");
		double lower  = sc.nextDouble();
		System.out.println("Enter the upper limit");
		double higher = sc.nextDouble();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			
			ics.byPrice(lower,higher);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void fiterBySeats(Scanner sc) {
		System.out.println("Enter the number of seats you want to see availability for");
		int seats  = sc.nextInt();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			ics.bySeats(seats);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void bookYourFlight(Customer customer,Scanner sc) {
		System.out.println("Enter the flight number you want to book");
		String flightNumber  = sc.next();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			ics.bookYourNewFlight(customer,flightNumber);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		
	}

	public static void viewYourBooking(Customer customer) {
		try {
			ICustomerService ics = new CustomerServiceImpl();
			ics.viewAllYourBooking(customer);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	public static void cancelYourBooking(Customer customer,Scanner sc) {
		System.out.println("Enter the booking Id to cancel the flight");
		int bookingId  = sc.nextInt();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			ics.cancelAnyYourBooking(customer,bookingId);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	

	
}
