package Flight_Booking_System.Flight_Booking_System;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static EntityManagerFactory emf = null;
    
    static {
    	emf = Persistence.createEntityManagerFactory("Project");
    }
    
}
