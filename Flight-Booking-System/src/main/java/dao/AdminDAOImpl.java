package dao;

import java.time.LocalDateTime;

import Flight_Booking_System.Flight_Booking_System.App;
import entity.Admin;
import entity.Flight;
import exception.NoFlightsFound;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import service.AdminServiceImpl;
import service.IAdminService;

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
	public void generateFlightDetails() {
		// TODO Auto-generated method stub
		
	}

}
