package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import Flight_Booking_System.Flight_Booking_System.App;
import entity.Booking;
import entity.CancelBooking;
import entity.Customer;
import entity.Flight;
import exception.NoFlightsFound;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CustomerDAOImpl implements ICustomerDAO{
	
	@Override
	public void registerNewCity(Customer customer) {
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void byDepartureCity(String city) throws NoFlightsFound{
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT f FROM Flight f WHERE f.DepartureCity=:city");
			query.setParameter("city", city);
			List<Flight> list = (List<Flight>)query.getResultList();
			if(!list.isEmpty()) {
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(" Flight_number   " +"     Arrival     "+"       Departure   " +"       price   " +"   DepartureCity   " + "   ArrivalCity   " +  "\n");
			for(Flight flight : list) {
				System.out.println(flight.toString());
			}}else {
				throw new NoFlightsFound("No flights are scheduled to take off from " + city + " for now please check later");
			}
			et.commit();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void byDestination(String city)throws NoFlightsFound {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT f FROM Flight f WHERE f.ArrivalCity=:city");
			query.setParameter("city", city);
			List<Flight> list = (List<Flight>)query.getResultList();
			if(!list.isEmpty()) {System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" Flight_number   " +"     Arrival     "+"       Departure   " +"       price   " +"   DepartureCity   " + "   ArrivalCity   " +  "\n");
			for(Flight flight : list) {
				System.out.println(flight.toString());
			}}else {
				throw new NoFlightsFound("No flights are scheduled to go to " + city + " for now... Please check later");
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void byDates(LocalDate date)throws NoFlightsFound {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT f FROM Flight f WHERE DATE(f.Departure)=:date");
			query.setParameter("date", date);
			List<Flight> list = (List<Flight>)query.getResultList();
			if(!list.isEmpty()) {
				System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" Flight_number   " +"     Arrival     "+"       Departure   " +"       price   " +"   DepartureCity   " + "   ArrivalCity   " +  "\n");
		
			for(Flight flight : list) {
				System.out.println(flight.toString());
			}}else {
				throw new NoFlightsFound("No flights are scheduled to take of on " + date + " for now... Please check later");
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
		
	}

	@Override
	public void byPrice(double lower,double higher)throws NoFlightsFound {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT f FROM Flight f WHERE f.price BETWEEN :lower AND :higher");
			query.setParameter("lower",lower );
			query.setParameter("higher", higher);
			List<Flight> list = (List<Flight>)query.getResultList();
			if(!list.isEmpty()) {
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(" Flight_number   " +"     Arrival     "+"       Departure   " +"       price   " +"   DepartureCity   " + "   ArrivalCity   " +  "\n");
			for(Flight flight : list) {
				System.out.println(flight.toString());
			}}else {
				throw new NoFlightsFound("No flights are scheduled within the price range of " + lower+" and "+ higher +" for now... Please check later");
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void bySeats(int seats)throws NoFlightsFound {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT f FROM Flight f");
			List<Flight> list = query.getResultList();
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" Flight_number   "  +  "\n");
			list.stream().filter(i->i.getBooking().size()<=100-seats).forEach(i->System.out.println(i.getFlightNumber()));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void bookYourNewFlight(Customer customer,String number) {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Flight flight = em.find(Flight.class, number);
			Booking booking = new Booking(customer,flight);
			flight.getBooking().add(booking);
			customer.getBooking().add(booking);
			em.persist(booking);
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void viewAllYourBooking(Customer customer) {
		System.out.println();
		Set<Booking> list = customer.getBooking();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println("BookingId  " + "  CustomerId  " +"  gender  " +"  Name  " + "  kota  " + "  Age  " + "  Nationality  " +  "    "+" Flight_number   " +"     Arrival     "+"       Departure   " +"       price   " +"   DepartureCity   " + "   ArrivalCity   " +  "\n");
		for(Booking booking : list) {
			System.out.println(booking.toString());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		
	}

	@Override
	public void cancelAnyYourBooking(Customer customer,int bookingId) {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = App.emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Booking booking = em.find(Booking.class, bookingId);
			Flight flight = em.find(Flight.class, booking.getFlight().getFlightNumber());
			em.remove(booking);
			flight.getBooking().remove(booking);
			customer.getBooking().remove(booking);
			CancelBooking canceled = new CancelBooking(bookingId,customer,flight);
			em.persist(canceled);
			et.commit();
		}catch(Exception ex) {
			et.rollback();
			ex.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	

}
