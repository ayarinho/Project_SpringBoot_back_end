package tn.S.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.S.entities.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	@Query(value="SELECT prix FROM Produit")
	public List<Double> getAllpriceJPQL();

}
