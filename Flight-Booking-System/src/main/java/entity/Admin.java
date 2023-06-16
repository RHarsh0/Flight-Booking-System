package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AdminId;
	
	private int EmployeeId;
	private String Name;
	private String Position;
	@Column(unique=true)
	private String Username;
	private String Password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin( int EmployeeId,String name, String position, String username, String password) {
		super();
		this.EmployeeId = EmployeeId;
		Name = name;
		Position = position;
		Username = username;
		Password = password;
	}
	public int getAdminId() {
		return AdminId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "   AdminId   " + "   EmployeeId   " +"   Name   " +"   Position   " +
	           "  "+AdminId+"   " + "   "+EmployeeId +"   "+"   " +Name +"   "+ "   "+Position+"   "+"\n";
	}
	
	
}
