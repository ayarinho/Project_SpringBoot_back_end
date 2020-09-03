package tn.S.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "T_Produit")
@ApiModel(value = "Produit")
public class Produit implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@ApiModelProperty(value = "Id")
	private Long id;
	@ApiModelProperty(value = "NomP")
	private String nom;
	@ApiModelProperty(value = "Prix")
	private double prix;

	@ManyToOne
	@JoinColumn(name = "ID_cat")
	private Categorie categorie;

	public Produit() {
		super();
		
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Produit(Long id, String nom, double prix, Categorie categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Produit(String nom, double prix, Categorie categorie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Produit(String nom, double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}

	

}
