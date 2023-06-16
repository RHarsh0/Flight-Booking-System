package login;

import java.util.Scanner;

import Flight_Booking_System.Flight_Booking_System.App;
import UIDesign.ConsoleColor;
import UIDesign.ConsoleFont;
import UIDesign.Symbols;
import entity.Admin;
import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import uimain.UIMain;

public class AdminLogin {

	public static boolean adminLogin() {
		EntityManager em = App.emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print(ConsoleColor.ANSI_CYAN+"      Please enter the Username :  "+ConsoleColor.ANSI_RESET);
        System.out.print(ConsoleColor.ANSI_YELLOW);
          		String user = sc.next();
          		System.out.println();
        System.out.print(ConsoleColor.ANSI_CYAN+"      Enter the password :         "+ConsoleColor.ANSI_RESET);
        System.out.print(ConsoleColor.ANSI_YELLOW);
                String pass = sc.next();
        
                Query query = em.createQuery("FROM Admin a WHERE a.Username = :user AND a.Password = :pass");
                try {
                query.setParameter("user", user);
                query.setParameter("pass", pass);
                Object obj=null;
                obj = query.getSingleResult();
                System.out.println();
                return true;
                }catch(NoResultException ex) {
                	System.out.println();
                	System.out.println("                             "+ConsoleFont.ANSI_ITALIC+ ConsoleColor.ANSI_RED+Symbols.CROSS_MARK+"Wrong username or/and password please try again with correct credentials"+ConsoleColor.ANSI_RESET);
                	return false;
                }
                
	}
}
