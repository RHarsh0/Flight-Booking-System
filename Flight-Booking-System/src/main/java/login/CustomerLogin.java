package login;

import java.util.Scanner;

import Flight_Booking_System.Flight_Booking_System.App;
import UIDesign.ConsoleColor;
import UIDesign.ConsoleFont;
import UIDesign.Symbols;
import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import uimain.UIMain;


public class CustomerLogin {
	public static void customerLogin() {
		EntityManager em = App.emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Please enter the Username   ");
		System.out.print(ConsoleColor.ANSI_YELLOW);
          		String user = sc.next();
          		System.out.println();
        System.out.print(ConsoleColor.ANSI_CYAN+"    "+"Enter the password          ");
        System.out.print(ConsoleColor.ANSI_YELLOW);
                String pass = sc.next();
        System.out.println(ConsoleColor.ANSI_RESET);
                Query query = em.createQuery("FROM Customer c WHERE c.Username = :user AND c.Password = :pass");
                try {
                query.setParameter("user", user);
                query.setParameter("pass", pass);
                Object obj = query.getSingleResult();
                Customer customer = em.find(Customer.class, ((Customer)obj).getCustomerId());
                UIMain.ifYouAreAlreadyCustomer(customer);
                }catch(NoResultException ex) {
                	System.out.println();
                	System.out.println("                             "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+"Wrong username or/and password please try again with correct credentials"+ConsoleColor.ANSI_RESET);
                	
                }
	}
}
