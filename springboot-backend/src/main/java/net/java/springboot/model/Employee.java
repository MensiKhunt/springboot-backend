package net.java.springboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employees")
public class Employee {
	
	private static final int Subject = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stu_id")
	private long id;
	
	@Column(name="emp_name")
	private String name;
	
	@Column(name="emp_address")
	private String address;
	
	@Column(name="emp_gender")
	private String gender;
	
	@Column(name="emp_car")
	private String cars;
	
	@Column(name="emp_doj")
	private String doj;
	
	@Column(name="emp_country")
	private String country;
	
	@Column(name="emp_hobby")
	private String hobbies;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="sub_id",referencedColumnName="stu_id")
	private List<Subject> subject;
	
	public List<Subject> getSubject(){
		return subject;
	}
	
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
	public Employee() {
		
	}
	
	
	
	public Employee(long id, String name, String address, String gender, String cars, String doj, String country,
			String hobbies, Subject subject) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.cars = cars;
		this.doj = doj;
		this.country = country;
		this.hobbies = hobbies;
		this.subject = (List<Subject>) subject;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCars() {
		return cars;
	}
	public void setCars(String cars) {
		this.cars = cars;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", cars="
				+ cars + ", doj=" + doj + ", country=" + country + ", hobbies=" + hobbies + ", subject=" + subject
				+ "]";
	}
	
	
}
