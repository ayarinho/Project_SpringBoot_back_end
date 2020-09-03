package tn.S.controlleur;




import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.S.entities.Employes;
import tn.S.entities.Produit;
import tn.S.repository.CategorieRepository;
import tn.S.repository.EmployeRepository;
import tn.S.repository.ProduitRepository;
import tn.S.service.IClientsService;
import tn.S.service.IEmployeService;
import tn.S.service.IProduitService;



@RestController
@RequestMapping("/")
@CrossOrigin("*")

@Api(value = "Intervenant Rest Controller: contains all operations for managing intervenant")
public class RestControlleur {

	@Autowired
	IProduitService iproduitservice;
	
	@Autowired
	IClientsService  iclientservice;

	@Autowired
	EmployeRepository employerrepository;

	@Autowired
	IEmployeService iemployerservice;
     

	
	@Autowired
	CategorieRepository categorierepository;
	@Autowired
	ProduitRepository produitRepository;
	
	

	// http://localhost:8081//show-all-produit"
	@GetMapping(value = "/show-all-produit")

	@ApiOperation(value = "Liste Produit", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research"),
			@ApiResponse(code = 204, message = "No Content: no result founded"), })

	public List<Produit> show() {
		return iproduitservice.show();
	}
	
	

@ControllerAdvice
public class Handler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex, 
                HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof NullPointerException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
	@GetMapping(value = "/show-all-employers")
	public List<Employes> ShowEmploer() {
		return iemployerservice.ShowEmploye();
	}

	/*public ResponseEntity<List<Produit>> geProduit() {
		List<Produit> intervenant = iproduitservice.show();
		if (!CollectionUtils.isEmpty(intervenant)) {
			return new ResponseEntity<List<Produit>>(intervenant, HttpStatus.OK);
		}
		return new ResponseEntity<List<Produit>>(HttpStatus.NO_CONTENT);
	}*/


	@DeleteMapping("/deleteProd/{id_p}")
	@ApiOperation(value = "delete Produit", response = List.class)
	public void DeleteProduit(@RequestParam( "id_p") long id) {

		iproduitservice.DeleteProduit(id);
	}


	@GetMapping(value = "/somme-prix-produit")
	@ApiOperation(value = "Sommeprix Produit", response = List.class)
	public Produit SommeprixProduit() {
		return iproduitservice.SommeprixProduit();
	}

	@GetMapping(value = "/get-produit")
	public List<String> getAllProduitJPQL(){
		List<String> ak= categorierepository.getAllProduitJPQL();
		return  ak; }
	
	
	@GetMapping(value = "/get-price")
	public List<Double> getAllpriceJPQL(){
		List<Double> ak= produitRepository.getAllpriceJPQL();
		return  ak;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/add-employe") 
	@ResponseBody 
	public Employes Add(@RequestBody Employes pd) {
		//employerrepository.save(pd);
		return iemployerservice.Add(pd);
		}
	
	
	@DeleteMapping("/deleteEmp/{id_ad}") 
	@ResponseBody 
	public void DeleteEmploye(@PathVariable("id_ad") long id){ 
		iemployerservice.DeleteEmploye(id);}  
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/modify-emp/{id}") 
	@ResponseBody 
	public Employes modifyAd(@PathVariable("id") long id,@RequestBody  Employes emp) 
	{ 	return iemployerservice.updateEmp(id,emp); }

	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/get-emp/{password}")
	@ResponseBody
	public Employes getEmpById(@PathVariable("password") String password){
		
		return  iemployerservice.getEmpById(password);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/salem/{name}")
	@ResponseBody
	public Employes Username(@PathVariable("name") String name){
		
		return  iemployerservice.Username(name);
	}
	
	
	@CrossOrigin("*")
	@PostMapping(value = "/authentification/{username}/{password}")
	@ResponseBody
	public Employes authentification(@PathVariable("username")String username,@PathVariable("password") String password) {
		return iemployerservice.authentification(username, password);
	}
	
	@CrossOrigin("*")
	@PostMapping(value = "/photo/{id}/{photoname}")
	@ResponseBody
	public void AddPhoto(@PathVariable("id")Long id, @PathVariable("photoname")String photoname)  {
	
		iemployerservice.AddPhoto(id, photoname);
	}
	
	@CrossOrigin("*")
	@PostMapping(value = "/got/")
	@ResponseBody
	public void getAll()  {
	
		// iclientservice.getAll();
	}
	
	
	
	
	@GetMapping(value = "/getPassword")
	public List<String> getPassword1(){
		
		
		return  iemployerservice.getPassword1();
	}
	@GetMapping(value = "/getUsername")
	public List<String> getUsername1(){
		
		return  iemployerservice.getUsername1();

}
	@GetMapping(value = "/getclient/{id}")
	public String getClientsbyEmp(@PathVariable("id")long Id) {
		
		return iclientservice.getClientsbyEmp(Id);
	}
	
	

	@GetMapping(value = "/get/{email}")
	@ResponseBody
	public  String forgetPassword(@PathVariable("email")  String email){
		
		return  iemployerservice.forgetPassword(email);
	}

}
