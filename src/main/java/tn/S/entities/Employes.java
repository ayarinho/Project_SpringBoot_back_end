package tn.S.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "T_Employe")
@ApiModel(value = "Employe")
public class Employes implements Serializable{
	
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	
	@ApiModelProperty(value = "Id")
	private Long id;
	public Employes(Long id, String username, String country, String city, double salary, String email,
			String firstname, String lastname, String address, int codepostal, String description, String password,
			Clients clients) {
		super();
		this.id = id;
		this.username = username;
		this.country = country;
		this.city = city;
		this.salary = salary;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.codepostal = codepostal;
		this.description = description;
		this.password = password;
		this.clients = clients;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	@ApiModelProperty(value = "username")
	private String username;
	@ApiModelProperty(value = "country")
	private String country;
	@ApiModelProperty(value = "city")
	private String city;
	@ApiModelProperty(value = "salary")
	private double salary;
	@ApiModelProperty(value = "Email")
	private String email;
	@ApiModelProperty(value = "firstname")
	private String firstname;
	@ApiModelProperty(value = "lastname")
	private String lastname;
	@ApiModelProperty(value = "address")
	private String address;
	@ApiModelProperty(value = "codepostal")
	private int codepostal;
	@ApiModelProperty(value = "description")
	private String description;
	@ApiModelProperty(value = "password")
	private String password;
	@ApiModelProperty(value = "image")
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Employes(Long id, String username, String country, String city, double salary, String email,
			String firstname, String lastname, String address, int codepostal, String description, String password,
			String image, Clients clients) {
		super();
		this.id = id;
		this.username = username;
		this.country = country;
		this.city = city;
		this.salary = salary;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.codepostal = codepostal;
		this.description = description;
		this.password = password;
		this.image = image;
		this.clients = clients;
	}


	@ManyToOne
	@JoinColumn(name = "ID_client")
	private  Clients clients;
	
	
	
	
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Employes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
