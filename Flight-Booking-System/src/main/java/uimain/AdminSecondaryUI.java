package uimain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;

import UIDesign.ConsoleColor;
import UIDesign.ConsoleFont;
import UIDesign.Symbols;
import entity.Admin;
import entity.Booking;
import entity.CancelBooking;
import entity.Flight;
import exception.NoFlightsFound;
import service.AdminServiceImpl;
import service.IAdminService;

public class AdminSecondaryUI{
	public static void registerAdmin(Scanner sc) {
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the Employee Id              ->");
		System.out.print(ConsoleColor.ANSI_YELLOW+"    ");
		int id = sc.nextInt();
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the Employee name            ->");
		System.out.print(ConsoleColor.ANSI_YELLOW+"    ");
		String name = sc.next();
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the position of the employee ->");
		System.out.print(ConsoleColor.ANSI_YELLOW+"    ");
		String post = sc.next();
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the Username                 ->");
		System.out.print(ConsoleColor.ANSI_YELLOW+"    ");
		String username = sc.next();
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the password                 ->");
		System.out.print(ConsoleColor.ANSI_YELLOW+"    ");
		String pass = sc.next();
		System.out.println(ConsoleColor.ANSI_RESET);
		try {
			IAdminService rna =new AdminServiceImpl();
			Admin admin = new Admin(id,name,post,username,pass);
			rna.registerNewAdmin(admin);
			System.out.println(ConsoleColor.ANSI_RESET);
			System.out.println("The Admin is registered sucessfully");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void addFlight(Scanner sc) {
		
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the Flight number             ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String flightNumber = sc.next();
		System.out.println();
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the Arrival date and time of the flight in the pattern (yyyy-MM-dd-HH-mm-ss)  ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String input = sc.next();
		System.out.println();
		LocalDateTime arrival = LocalDateTime.parse(input,inputFormat);
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the Arrival date and time of the flight in the pattern (yyyy-MM-dd-HH-mm-ss   ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		LocalDateTime departure = LocalDateTime.parse(sc.next(),inputFormat);
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the price                  ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		double price = sc.nextDouble();
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the departure city         ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String deptcity = sc.next();
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the arrival city           ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String arrivalcity = sc.next();
		System.out.println();
		try {
			IAdminService rna =new AdminServiceImpl();
			Flight flight = new Flight(flightNumber,arrival,departure,price,deptcity,arrivalcity,new HashSet<Booking>(),new HashSet<CancelBooking>());
			System.out.println(ConsoleColor.ANSI_GREEN);
			rna.addNewFlight(flight);
			System.out.println(ConsoleColor.ANSI_RESET);
			System.out.println(ConsoleColor.ANSI_CYAN+"    "+"The flight is added successfully");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public static void updateFlight(Scanner sc) {
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the flight number which you want to update    ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String flightNumber = sc.next();
		System.out.println();
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the Arrival date and time of the flight in the pattern (yyyy-MM-dd-HH-mm-ss) ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String input = sc.next();
		System.out.println();
		LocalDateTime arrival = LocalDateTime.parse(input,inputFormat);
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the Arrival date and time of the flight in the pattern (yyyy-MM-dd-HH-mm-ss  ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		LocalDateTime departure = LocalDateTime.parse(sc.next(),inputFormat);
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the price     ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		double price = sc.nextDouble();
		System.out.println();
		try {
			IAdminService rna =new AdminServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			rna.updateFlightDetails(flightNumber,arrival,departure,price);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(NoFlightsFound ex) {
			System.out.println("                               "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+ex+ConsoleColor.ANSI_RESET);
		}	
	}

	public static void deleteFlight(Scanner sc) {
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the flight number of the flight you want to delete   ->");
		System.out.print(ConsoleColor.ANSI_YELLOW);
		String flightNumber = sc.next();
		System.out.println();
		try {
			IAdminService rna =new AdminServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			rna.removeFlight(flightNumber);
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(NoFlightsFound ex) {
			System.out.println("                               "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+ex+ConsoleColor.ANSI_RESET);
		}
	}

	public static void generateReportForFlights() {
		System.out.println(ConsoleColor.ANSI_CYAN+"    "+"Here is the list of the flights that are currently active  ->");
		try {
			IAdminService rna =new AdminServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			rna.viewFlights();
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(Exception ex) {
			System.out.println("                               "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+ex+ConsoleColor.ANSI_RESET);
		}
	}

	public static void generateReportForCustomers() {
		System.out.println(ConsoleColor.ANSI_CYAN+"    "+"Here is the list of the Customer who are currently active  ->");
		try {
			IAdminService rna =new AdminServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			rna.viewCustomers();
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(Exception ex) {
			System.out.println("                               "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+ex+ConsoleColor.ANSI_RESET);
		}
		
	}

	public static void generateReportForBookings() {
		System.out.println(ConsoleColor.ANSI_CYAN+"    "+"Here is the list of the Bookings that are currently active ->");
		try {
			IAdminService rna =new AdminServiceImpl();
			System.out.println(ConsoleColor.ANSI_GREEN);
			rna.viewBookings();
			System.out.println(ConsoleColor.ANSI_RESET);
		}catch(Exception ex) {
			System.out.println("                               "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+ex+ConsoleColor.ANSI_RESET);
		}
		
		
	}
	
}
