package uimain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;

import entity.Admin;
import entity.Booking;
import entity.CancelBooking;
import entity.Flight;
import exception.NoFlightsFound;
import service.AdminServiceImpl;
import service.IAdminService;

public class AdminSecondaryUI{
	public static void registerAdmin(Scanner sc) {
		System.out.println("Enter the Employee Id");
		int id = sc.nextInt();
		System.out.println("Enter the Employee name");
		String name = sc.next();
		System.out.println("Enter the position of the employee");
		String post = sc.next();
		System.out.println("Enter the Username");
		String username = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		try {
			IAdminService rna =new AdminServiceImpl();
			Admin admin = new Admin(id,name,post,username,pass);
			rna.registerNewAdmin(admin);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void addFlight(Scanner sc) {
		
		System.out.println("Enter the Flight number");
		String flightNumber = sc.next();
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		System.out.println("Enter the Arrival date and time of the flight in the pattern (yyyy-MM-dd-HH-mm-ss)");
		String input = sc.next();
		LocalDateTime arrival = LocalDateTime.parse(input,inputFormat);
		System.out.println("Enter the Arrival date and time of the flight in the pattern (yyyy-MM-dd-HH-mm-ss");
		LocalDateTime departure = LocalDateTime.parse(sc.next(),inputFormat);
		System.out.println("Enter the price");
		double price = sc.nextDouble();
		System.out.println("Enter the departure city");
		String deptcity = sc.next();
		System.out.println("Enter the arrival city");
		String arrivalcity = sc.next();
		
		try {
			IAdminService rna =new AdminServiceImpl();
			Flight flight = new Flight(flightNumber,arrival,departure,price,deptcity,arrivalcity,new HashSet<Booking>(),new HashSet<CancelBooking>());
			rna.addNewFlight(flight);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public static void updateFlight(Scanner sc) {
		System.out.println("Enter the flight number which you want to update");
		String flightNumber = sc.next();
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		System.out.println("Enter the Arrival date and time of the flight in the pattern (yyyy-MM-dd-HH-mm-ss)");
		String input = sc.next();
		LocalDateTime arrival = LocalDateTime.parse(input,inputFormat);
		System.out.println("Enter the Arrival date and time of the flight in the pattern (yyyy-MM-dd-HH-mm-ss");
		LocalDateTime departure = LocalDateTime.parse(sc.next(),inputFormat);
		System.out.println("Enter the price");
		double price = sc.nextDouble();
		try {
			IAdminService rna =new AdminServiceImpl();
			rna.updateFlightDetails(flightNumber,arrival,departure,price);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}	
	}

	public static void deleteFlight(Scanner sc) {
		System.out.println("Enter the flight number of the flight you want to delete");
		String flightNumber = sc.next();
		try {
			IAdminService rna =new AdminServiceImpl();
			rna.removeFlight(flightNumber);
		}catch(NoFlightsFound ex) {
			System.out.println(ex);
		}
	}

	
	
}
