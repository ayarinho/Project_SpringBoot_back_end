package tn.S.entities;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "T_client")
@ApiModel(value = "Client")
public class Clients implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	
	@ApiModelProperty(value = "Id")
	private Long id;
	@ApiModelProperty(value = "client_name")
	private String clientname;
	

	@OneToMany(mappedBy = "clients", fetch = FetchType.EAGER)
	private List<Employes> employes;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public List<Employes> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employes> employes) {
		this.employes = employes;
	}

	

	public Clients(String clientname) {
		super();
		this.clientname = clientname;
	}

	public Clients() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
	
}
