package tn.S.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.S.entities.Employes;

@Repository
public interface EmployeRepository extends JpaRepository<Employes, Long> {
	
	


}
