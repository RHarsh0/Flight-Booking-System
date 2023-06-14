package login;

import java.util.Scanner;

import Flight_Booking_System.Flight_Booking_System.App;
import entity.Admin;
import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import uimain.UIMain;

public class AdminLogin {

	public static void adminLogin() {
		EntityManager em = App.emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Username");
          		String user = sc.next();
        System.out.println("Enter the password");
                String pass = sc.next();
        
                Query query = em.createQuery("FROM Admin a WHERE a.Username = :user AND a.Password = :pass");
                
                query.setParameter("user", user);
                query.setParameter("pass", pass);
                
                Object obj = query.getSingleResult();
                
	}
}
