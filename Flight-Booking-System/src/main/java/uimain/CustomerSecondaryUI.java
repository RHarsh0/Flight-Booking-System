package uimain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import UIDesign.ConsoleColor;
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
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter your name         ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String name = sc.next();
		System.out.println(ConsoleColor.ANSI_CYAN+"    "+"Enter your age          ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		int age = sc.nextInt();
		System.out.println(ConsoleColor.ANSI_CYAN+"    "+"Enter your Gender       ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		Gender gender = Gender.valueOf(sc.next().toUpperCase());
		System.out.println(ConsoleColor.ANSI_CYAN+"    "+"Enter your Nationality  ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String nation = sc.next();
		System.out.println(ConsoleColor.ANSI_CYAN+"    "+"Enter your category as Student or Disability or if neither of then give none ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		Kota kota = Kota.valueOf(sc.next().toUpperCase());
		System.out.println(ConsoleColor.ANSI_CYAN+"    "+"Enter your username     ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String user =sc.next();
		System.out.println(ConsoleColor.ANSI_CYAN+"    "+"Setup your password     ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String pass = sc.next();
		
		try {
			ICustomerService ics = new CustomerServiceImpl();
			
			Customer customer = new Customer(name,age,gender,nation, kota,user,pass,new HashSet<Booking>(),new HashSet<CancelBooking>());
			System.out.println(ConsoleColor.ANSI_GREEN);
			ics.registerNewCustomer(customer);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	public static void filterByDepartureCity(Scanner sc) {
		
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the name of the departure city  ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String city = sc.next();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			ics.byDepartureCity(city);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void filterByDestination(Scanner sc) {
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the name of the destination city  ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String city = sc.next();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			ics.byDestination(city);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void filterByDates(Scanner sc) {
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the date on which you seek to travel in the format (yyyy-MM-dd) ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		LocalDate date  = LocalDate.parse(sc.next());
		try {
			ICustomerService ics = new CustomerServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			ics.byDates(date);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void filterByPriceRange(Scanner sc) {
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the price range in which you seek to travel  ->");
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the lower limit  ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		double lower  = sc.nextDouble();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the upper limit  ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		double higher = sc.nextDouble();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			ics.byPrice(lower,higher);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void fiterBySeats(Scanner sc) {
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the number of seats you want to see availability for");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		int seats  = sc.nextInt();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			ics.bySeats(seats);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
		
	}

	public static void bookYourFlight(Customer customer,Scanner sc) {
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the flight number you want to book");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String flightNumber  = sc.next();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			ics.bookYourNewFlight(customer,flightNumber);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		
	}

	public static void viewYourBooking(Customer customer) {
		try {
			ICustomerService ics = new CustomerServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			ics.viewAllYourBooking(customer);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	public static void cancelYourBooking(Customer customer,Scanner sc) {
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the booking Id to cancel the flight");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		int bookingId  = sc.nextInt();
		try {
			ICustomerService ics = new CustomerServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			ics.cancelAnyYourBooking(customer,bookingId);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	

	
}
