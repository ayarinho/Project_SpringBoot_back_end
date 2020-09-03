package tn.S.service;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.S.entities.Clients;
import tn.S.entities.Employes;
import tn.S.entities.ServicesClients;
import tn.S.repository.ClientRepository;
import tn.S.repository.EmployeRepository;





	@Service
	public class  ClientServiceImpl implements IClientsService{
		
		public static final Logger l = LogManager.getLogger(ClientServiceImpl.class);
		
		private static final int Optional = 0;
		@Autowired
		EmployeRepository employerepository;
		@Autowired
		ClientRepository clientrepository;
	
		@Autowired
		cryptWithMD5 cryptWithMD5;
		@Autowired
		NotificationServeur notificationserveur;
		
		
		@Override
		public String getClientsbyEmp(long Id) {
			
			Employes aa = employerepository.findById(Id).get();
			
			return aa.getClients().getClientname();
		}
		
		

		
	
		
	}
		