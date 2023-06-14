package login;

import java.util.Scanner;

import Flight_Booking_System.Flight_Booking_System.App;
import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import uimain.UIMain;


public class CustomerLogin {
	public static void customerLogin() {
		EntityManager em = App.emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Username");
          		String user = sc.next();
        System.out.println("Enter the password");
                String pass = sc.next();
        
                Query query = em.createQuery("FROM Customer c WHERE c.Username = :user AND c.Password = :pass");
                
                query.setParameter("user", user);
                query.setParameter("pass", pass);
                Object obj = query.getSingleResult();
                Customer customer = em.find(Customer.class, ((Customer)obj).getCustomerId());
                UIMain.ifYouAreAlreadyCustomer(customer);
                
	}
}
