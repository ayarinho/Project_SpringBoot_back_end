package tn.S.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.S.entities.Clients;

public interface ClientRepository  extends JpaRepository<Clients, Long> {

}
