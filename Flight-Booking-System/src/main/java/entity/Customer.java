package entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT")
	private int CustomerId;
	private String Name;
	private int Age;
	enum Gender{FEMALE,MALE}
	enum Kota{STUDENT,DISABILITY}
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "VARCHAR(255)")
	private Gender gender;
	private String Nationality;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "VARCHAR(255)")
	private Kota kota;
	@OneToMany(mappedBy = "customer")
	private Set<Booking> booking;
	@OneToMany(mappedBy = "customer")
	private Set<CancelBooking> cancel;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String name, int age, Gender gender, String nationality, Kota kota,
			Set<Booking> booking, Set<CancelBooking> cancel) {
		super();
		Name = name;
		Age = age;
		this.gender = gender;
		Nationality = nationality;
		this.kota = kota;
		this.booking = booking;
		this.cancel = cancel;
	}

	

	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getAge() {
		return Age;
	}


	public int getCustomerId() {
		return CustomerId;
	}
	
	
	public void setAge(int age) {
		Age = age;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getNationality() {
		return Nationality;
	}


	public void setNationality(String nationality) {
		Nationality = nationality;
	}


	public Kota getKota() {
		return kota;
	}


	public void setKota(Kota kota) {
		this.kota = kota;
	}


	public Set<Booking> getBooking() {
		return booking;
	}


	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}


	public Set<CancelBooking> getCancel() {
		return cancel;
	}


	public void setCancel(Set<CancelBooking> cancel) {
		this.cancel = cancel;
	}


	@Override
	public String toString() {
		
		return "CustomerId=" + CustomerId +"\n"+ 
		        "gender=" + gender+"\n"+
               "Name=" + Name + "\n"+
               ", kota=" + kota+ "\n"+
		       "Age=" + Age + "\n"+
               "Nationality=" + Nationality;
	}
	



}
