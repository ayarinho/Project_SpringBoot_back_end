package tn.S.service;



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.S.entities.Employes;

import tn.S.repository.EmployeRepository;








@Service
public class EmployeServiceImpl implements IEmployeService{
	
	public static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
	
	private static final int Optional = 0;
	@Autowired
	EmployeRepository employerepository;
	@Autowired
	cryptWithMD5 cryptWithMD5;
	@Autowired
	NotificationServeur notificationserveur;
	
	public List<Employes> ShowEmploye () {
		List<Employes> employers=(List<Employes>) employerepository.findAll();
		return employers;	

}
	
	public Employes Add(Employes Emp) {
		
		notificationserveur.sendNotification(Emp);
		//String password = cryptWithMD5.cryptWithMD5(Emp.getPassword());
		
		//System.out.println(Emp.getPassword());

		
		//Emp.setPassword(password);
		employerepository.save(Emp);
	
		return Emp;
	}
	
	public void DeleteEmploye(long id) {
		
		
		 employerepository.deleteById(id);
		}
		
	public Employes updateEmp( long id,Employes amp) {
		
		List<Employes> employers=(List<Employes>) employerepository.findAll();
		for(Employes emp:employers) {
			if(emp.getId()==id) {
				employerepository.save(amp);
				return emp;
			}
		}
		return null;
	}		
   
	
	@Override
	public Employes getEmpById(String password) {
		
		List<Employes > users = (List<Employes>)employerepository.findAll();
	
		for(Employes A:users)	{
			
			if( A.getPassword().equals(password)) {
				
				return A;
			}
	
		}
			
	return null;
		

		
	}
	
	public Employes authentification(String username, String password) {
		System.out.println(username + password);
		List<Employes > users = (List<Employes>)employerepository.findAll();
		for (Employes  user : users) {
			if (user.getUsername().equals(username)) {
				if (user.getPassword().equals(cryptWithMD5.cryptWithMD5(password))) {
					return user;
				}

		
	}
		}
		return null;
		}
	
	public String getUsername() {
		String k=null;
		List<Employes > users = (List<Employes>)employerepository.findAll();
		for (Employes  user : users) {
           k=user.getUsername();
		}
		return k;
	}
	
	public List<String> getPassword1() {
		
		List<Employes> users = (List<Employes>)employerepository.findAll();
		List<String > k = new ArrayList<>() ;

        for(Employes A:users) {
        	k.add(A.getPassword());
    		
        }
        return k;

	}
	
public List<String> getUsername1() {
		
		List<Employes> users = (List<Employes>)employerepository.findAll();
		List<String > k = new ArrayList<>() ;

        for(Employes A:users) {
        	k.add(A.getUsername());
        }
        return k;

	}
	
@Override
public String forgetPassword(String email) {
	int existe=0;
	String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(email);
	if (!matcher.matches()) {
		return "invalid email";
	}
	List<Employes>users =(List<Employes>)employerepository.findAll();
	for(Employes us:users) {
		if(us.getEmail().equals(email)) {
			notificationserveur.sendNotification(us);
			
			
			existe=1;
			return "we sind you a new password pleaz try to connect with it";
			
		
		}
	}
	if(existe==0) {
		return"this compte n'existe pas you can create an accompte";
	}
	return null;
}
	

	public Employes Username(String name) {
		
		List<Employes > user = (List<Employes>)employerepository.findAll();
		
		for(Employes k:user)	{
			
			if( k.getUsername().equals(name)) {
				
				return k;
			}
	
		}
			
	return null;
		

		
	}
	
	public void AddPhoto(Long id,String photoname) {
		
		List<Employes > user = (List<Employes>)employerepository.findAll();
		
		for(Employes pp:user) {
			
			if(pp.getId().equals(id)) {
				 
				pp.setImage(photoname);
				employerepository.save(pp);
			}
				
		}
			
		
			
		
		
		
	}
}
