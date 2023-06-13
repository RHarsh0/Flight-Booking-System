package Flight_Booking_System.Flight_Booking_System;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    static EntityManagerFactory emf = null;
    
    static {
    	emf = Persistence.createEntityManagerFactory("Project");
    }
    public static void main(String[] args) {
		
	}
}
