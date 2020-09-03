package tn.S.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.S.entities.Produit;

@Service
public interface IProduitService {
	
	public List<Produit> show ();
	public void DeleteProduit(long id);
	public Produit SommeprixProduit();

}
