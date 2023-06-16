package dao;

import java.time.LocalDateTime;
import java.util.List;

import Flight_Booking_System.Flight_Booking_System.App;
import UIDesign.ConsoleColor;
import UIDesign.ConsoleFont;
import entity.Admin;
import entity.Booking;
import entity.Customer;
import entity.Flight;
import exception.NoFlightsFound;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class AdminDAOImpl implements IAdminDAO{

	@Override
	public void registerNewAdmin(Admin admin) {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(admin);
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public void addNewFlight(Flight flight) {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(flight);
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
		
	}

	@Override
	public void updateFlightDetails(String flightNumber, LocalDateTime arrival, LocalDateTime departure, double price) throws NoFlightsFound{
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Flight flight = em.find(Flight.class, flightNumber);
			if(flight != null) {
			flight.setArrival(arrival);
			flight.setDeparture(departure);
			flight.setPrice(price);}
			else {
				throw new NoFlightsFound("No active flight found");
			}
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
				
		
	}

	@Override
	public void removeFlight(String flightNumber) throws NoFlightsFound{
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Flight flight = em.find(Flight.class, flightNumber);
			if(flight != null) {
				em.remove(flight);
			}
			else {
				throw new NoFlightsFound("No active flight found");
			}
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
			
		
	}

	@Override
	public void viewFlights() throws NoFlightsFound{
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT F FROM Flight F");
			List<Flight> list = (List<Flight>)query.getResultList();
			if(!list.isEmpty()) {
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(" Flight_number   " +"     Arrival     "+"       Departure   " +"       price   " +"   DepartureCity   " + "   ArrivalCity   " +  "\n");
			
				for(Flight flight : list) {
					System.out.println(flight);
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
			}
			else {
				throw new NoFlightsFound("No active flight found");
			}
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void viewCustomers() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT c FROM Customer c");
			List<Customer> list = (List<Customer>)query.getResultList();
			if(!list.isEmpty()) {
				System.out.println();
				System.out.println(ConsoleColor.ANSI_RED+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ConsoleColor.ANSI_RESET);
				
				System.out.println(ConsoleColor.ANSI_BLACK+ConsoleFont.ANSI_BOLD+"CustomerId  " +"  gender  " +"  Name  " + "  kota  " + "  Age  " + "  Nationality  " +  "\n"+ConsoleColor.ANSI_RESET);
				for(Customer customer : list) {
					System.out.println(customer.toString());
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
			}
			else {
				throw new NoFlightsFound("No active flight found");
			}
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void viewBookings() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT b FROM Booking b");
			List<Booking> list = (List<Booking>)query.getResultList();
			if(!list.isEmpty()) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
				System.out.println("BookingId  " + "  CustomerId  " +"  gender  " +"  Name  " + "  kota  " + "  Age  " + "  Nationality  " +  "    "+" Flight_number   " +"     Arrival     "+"       Departure   " +"       price   " +"   DepartureCity   " + "   ArrivalCity   " +  "\n");
				
				for(Booking booking: list) {
					System.out.println(booking);
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println();
			}
			else {
				throw new NoFlightsFound("No active flight found");
			}
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

}
