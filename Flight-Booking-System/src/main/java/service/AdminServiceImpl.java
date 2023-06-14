package service;

import java.time.LocalDateTime;

import dao.AdminDAOImpl;
import dao.IAdminDAO;
import entity.Admin;
import entity.Flight;
import exception.NoFlightsFound;

public class AdminServiceImpl implements IAdminService{

	@Override
	public void registerNewAdmin(Admin admin) {
		
		IAdminDAO adminAdd = new AdminDAOImpl();
		adminAdd.registerNewAdmin(admin);
	}

	@Override
	public void addNewFlight(Flight flight) {
		IAdminDAO adminAddFlight = new AdminDAOImpl();
		adminAddFlight.addNewFlight(flight);
		
	}

	@Override
	public void updateFlightDetails(String flightNumber, LocalDateTime arrival, LocalDateTime departure, double price) throws NoFlightsFound {
		IAdminDAO adminUpdateFlight = new AdminDAOImpl();
		adminUpdateFlight.updateFlightDetails(flightNumber, arrival, departure, price);
		
		
	}

	@Override
	public void removeFlight(String flightNumber) throws NoFlightsFound{
		IAdminDAO adminRemoveFlight = new AdminDAOImpl();
		adminRemoveFlight.removeFlight(flightNumber);
		
	}

	@Override
	public void generateFlightDetails() {
		// TODO Auto-generated method stub
		
	}

	
}
