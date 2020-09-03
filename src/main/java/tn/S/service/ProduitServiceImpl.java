package tn.S.service;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.S.entities.Produit;
import tn.S.repository.ProduitRepository;



@Service
public class ProduitServiceImpl implements IProduitService {
	public static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);
	private static final int Optional = 0;
	@Autowired
	ProduitRepository produitrepository;
	
	public List<Produit> show () {
		List<Produit> produits=(List<Produit>) produitrepository.findAll();
		return produits;	

}
	
	public Produit Add(Produit pd) {

	produitrepository.save(pd);
	
	return pd;
	}
	
	public void DeleteProduit(long id) {
		
	Produit pd=produitrepository.findById(id).get();
	
	 produitrepository.delete(pd);
	 
	}
	
	
	public Produit SommeprixProduit() {
	
		List<Produit> pd=(List<Produit>)produitrepository.findAll();
		l.info(pd);
		
    Produit  l=null;
    boolean k= l.getCategorie().getNom().equals("luxe");
     
		return l;
		}
		
			
		

			

}
