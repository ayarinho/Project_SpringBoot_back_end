package tn.S.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.S.entities.Employes;

@Service
public interface IEmployeService {
	public List<Employes> ShowEmploye ();
	public Employes Add(Employes pd);
    public void DeleteEmploye(long id);
    public Employes updateEmp( long id,Employes amp) ;
    public Employes getEmpById(String password);
	public Employes authentification(String username,String password);
	public List<String> getPassword1();
	public List<String> getUsername1();
	public String forgetPassword(String email) ;
	public Employes Username(String name);
	public void AddPhoto(Long id,String photoname) ;
}
