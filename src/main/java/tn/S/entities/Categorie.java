package tn.S.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "T_Categorie")
@ApiModel(value = "Categorie")
public class Categorie implements Serializable {

	
	private static final long serialVersionUID = 1L; // ?????
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@ApiModelProperty(value = "idC")
	private Long id;
	@ApiModelProperty(value = "nomC")
	private String nom;
	@ApiModelProperty(value = "Designation")
	private String designation;

	@OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
	private List<Produit> produits;

	public Categorie() {
		super();
		
	}

	public Categorie(String nom, String designation) {
		super();
		this.nom = nom;
		this.designation = designation;
	}

	public Categorie(Long id, String nom, String designation, List<Produit> produits) {
		super();
		this.id = id;
		this.nom = nom;
		this.designation = designation;
		this.produits = produits;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

}
