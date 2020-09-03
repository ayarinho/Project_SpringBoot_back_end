package tn.S.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.S.entities.Categorie;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {


	@Query(value="SELECT designation FROM Categorie")
	public List<String> getAllProduitJPQL();
	
}
