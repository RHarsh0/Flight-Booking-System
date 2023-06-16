package uimain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Flight_Booking_System.Flight_Booking_System.App;
import UIDesign.ConsoleBGColor;
import UIDesign.ConsoleColor;
import UIDesign.ConsoleFont;
import UIDesign.Symbols;
import entity.Admin;
import entity.Booking;
import entity.CancelBooking;
import entity.Customer;
import entity.Flight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.OneToMany;
import login.AdminLogin;
import login.CustomerLogin;
import service.AdminServiceImpl;
import service.IAdminService;

public class UIMain {
	
	
	public static void ifYouAreAlreadyCustomer(Customer customer) {
		System.out.println(ConsoleColor.ANSI_BLUE+
				"*********************************************************CUSTOMER*********************************************************************");
						System.out.println();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
	        System.out.println(ConsoleColor.ANSI_CYAN+"    Welcome back Sir. Choose what you want to use our services for..");
	        System.out.println();
	        System.out.println("    1.Filter by Departure City");
	        System.out.println();
	        System.out.println("    2.Filter by Destination");
	        System.out.println();
	        System.out.println("    3.Filter by dates");
	        System.out.println();
	        System.out.println("    4.Filter by price");
	        System.out.println();
	        System.out.println("    5.Filter by seats");
	        System.out.println();
	        System.out.println("    6.Select to book your flight");
	        System.out.println();
	        System.out.println("    7.View Your Bookings");
	        System.out.println();
	        System.out.println("    8.Cancel your Booking");
	        System.out.println();
	        System.out.println("    0.Logout"+"    "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_YELLOW);
	        System.out.println();
	        System.out.print("        Choose  ->"+"    "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_YELLOW);
	        choice = sc.nextInt();
	        switch(choice) {
	        case 1:CustomerSecondaryUI.filterByDepartureCity(sc);
	        	   break;
	        case 2:CustomerSecondaryUI.filterByDestination(sc);
	        	   break;
	        case 3:CustomerSecondaryUI.filterByDates(sc);
	        	   break;
	        case 4:CustomerSecondaryUI.filterByPriceRange(sc);
	        	   break;
	        case 5:CustomerSecondaryUI.fiterBySeats(sc);
	        	   break;
	        case 6:CustomerSecondaryUI.bookYourFlight(customer,sc);
	        	   break;
	        case 7:CustomerSecondaryUI.viewYourBooking(customer);
	        	   break;
	        case 8:CustomerSecondaryUI.cancelYourBooking(customer,sc);
	        	   break;
	        case 0:System.out.println("Thanks for your services. And go Back");
	               youAreCustomer();
	               break;
	        default:System.out.println("That was wrong input please make a correct choice");
	               break;
	        }
		}while(choice!=0);
	}
	private static void youAreCustomer() {
		System.out.println(ConsoleColor.ANSI_BLUE+
				"*********************************************************LOGIN*********************************************************************");
						System.out.println();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println(ConsoleColor.ANSI_CYAN+"  Welcome Sir would you login please");
			System.out.println();
	        System.out.println("      Thanks for choosing us");
	        System.out.println();
	        System.out.println("      1.Are you new User. Happy to have you please register");
	        System.out.println();
	        System.out.println("      2.Are you a previous user Then please login");
	        System.out.println();
	        System.out.println("      0.Back");
	        System.out.println();
	        System.out.print("        Choose  ->"+"    "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_YELLOW);
	        choice = sc.nextInt();
	        System.out.println();
	        switch(choice) {
	        case 1:CustomerSecondaryUI.registerCustomer(sc);
	        	   break;
	        case 2:CustomerLogin.customerLogin();
	        	   break;
	        case 0:System.out.println(ConsoleColor.ANSI_CYAN+"Thanks for your services.");
	               main(null);
	               break;
	        default:System.out.println("                               "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+"That was wrong input please make a correct choice"+ConsoleColor.ANSI_RESET);
	               break;
	        }
		}while(choice!=0);
		
	}
	private static void adminLogin() {
		System.out.println(ConsoleColor.ANSI_BLUE+
"*********************************************************LOGIN*********************************************************************");
		System.out.println();
		System.out.println(ConsoleColor.ANSI_CYAN+"  Welcome Sir would you login please"+ConsoleColor.ANSI_RESET);
		if(AdminLogin.adminLogin()) {
			youAreAdmin();
		}
	}
	private static void youAreAdmin() {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
            System.out.println(ConsoleColor.ANSI_BLUE+
"*********************************************************ADMIN*********************************************************************");
	        System.out.println();
            System.out.println(ConsoleColor.ANSI_CYAN+"  Thanks for maintainence. What do you want to change...");
	        System.out.println();
            System.out.println("    1.Do you want to register a new admin");
            System.out.println();
	        System.out.println("    2.Add a new Flight");
	        System.out.println();
	        System.out.println("    3.Change a flight details");
	        System.out.println();
	        System.out.println("    4.Remove a flight");
	        System.out.println();
	        System.out.println("    5.Genereate a report for all the flights currently active");
	        System.out.println();
	        System.out.println("    6.Genereate a report for all the customers currently active");
	        System.out.println();
	        System.out.println("    7.Genereate a report for all the booking currently active");
	        System.out.println();
	        System.out.println("    8.Genereate a report for all the canceled bookings currently active");
	        System.out.println();
	        System.out.println("    0.Logout"+ConsoleColor.ANSI_RESET);
	        System.out.println();
	        System.out.print("        Choose  ->"+"    "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_YELLOW);
	        choice = sc.nextInt();
	        switch(choice) {
	        case 1:AdminSecondaryUI.registerAdmin(sc);
	        	   break;
	        case 2:AdminSecondaryUI.addFlight(sc);
	        	   break;
	        case 3:AdminSecondaryUI.updateFlight(sc);
	        	   break;
	        case 4:AdminSecondaryUI.deleteFlight(sc);
	        	   break;
	        case 5:AdminSecondaryUI.generateReportForFlights();
	        	   break;
	        case 6:AdminSecondaryUI.generateReportForCustomers();
     	           break;
	        case 7:AdminSecondaryUI.generateReportForBookings();
     	           break;
	        case 8://AdminSecondaryUI.generateReportForFlights(sc);
     	           break;
	        case 0:System.out.println(ConsoleColor.ANSI_CYAN+"Thanks for your services."+ConsoleColor.ANSI_RESET);
	               main(null);
	               break;
	        default:System.out.println("                               "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+"That was wrong input please make a correct choice"+ConsoleColor.ANSI_RESET);
	                System.out.println();
	                break;
	        }
		}while(choice!=0);
		
	}






public static void main(String[] args) {
	System.out.println(ConsoleColor.ANSI_BLUE+
"============================================================================================================================="+"\n"+
"============================================================================================================================="+"\n"+
"============================================================================================================================"+"\n"+
"=============================================================================================================================="
);
	System.out.println(ConsoleColor.ANSI_BLUE+
"===================================================Flight Booking System====================================================="+ConsoleColor.ANSI_RESET);
	Scanner sc = new Scanner(System.in);
	int choice;
	do {
		System.out.println();
		
		System.out.println(ConsoleColor.ANSI_CYAN+"  Welcome to Fly Trip Travel. You are...");
		System.out.println();
		System.out.println("    1. Admin");
		System.out.println();
		System.out.println("    2. Customer");
		System.out.println();
		System.out.println("    0. Exit");
		System.out.println();
		System.out.print("        Choose  ->"+"    "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_YELLOW);
		choice = sc.nextInt();
		
		System.out.println();
		switch(choice) {
		case 1: adminLogin();
		        break;
		case 2: youAreCustomer();
		        break;
		case 0: choice = 0;
		        System.out.println(ConsoleColor.ANSI_CYAN+"Thank you for visiting us. See you later"+ConsoleColor.ANSI_RESET);
		        break;
		default:System.out.println("                                               "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+"  "+"Oops wrong input try again"+ConsoleColor.ANSI_RESET);
		        break;
		}
		
	}while(choice!=0);
	System.out.println(ConsoleColor.ANSI_BLUE+
"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*End*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ConsoleColor.ANSI_RESET);
}



}
