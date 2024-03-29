
package tn.S.controlleur;

	import java.util.List;
	import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.core.io.Resource;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.multipart.MultipartFile;
	import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tn.S.entities.Employes;
import tn.S.entities.FileInfo;
	import tn.S.message.ResponseMessage;
import tn.S.repository.EmployeRepository;
import tn.S.service.Storageservice;

	 

	@Controller
	@RequestMapping("/")
	@CrossOrigin("*")
	public class RestcontrolleurUpload {

		private static final Logger l= LogManager.getLogger(RestcontrolleurUpload.class);
			String password;
			
		 	@Autowired
		 	RestControlleur restcontrolleur;
		 	@Autowired
		 	EmployeRepository employerrepository;
			  @Autowired
			  Storageservice storageService;
			  @PostMapping("/upload")
			  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
			    String message = "";
			    try {
			      storageService.save(file);
			      message = "Uploaded the file successfully: " + file.getOriginalFilename();
			      Employes em= new Employes();
			     em=restcontrolleur.getEmpById(password);
			  
			      em.setImage(file.getOriginalFilename());
			      employerrepository.save(em);
			      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			    } catch (Exception e) {
			      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			    }
			  }
			  
			  
			  @GetMapping("/files")
			  public ResponseEntity<List<FileInfo>> getListFiles() {
			    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
			      String filename = path.getFileName().toString();
			      String url = MvcUriComponentsBuilder
			          .fromMethodName(RestcontrolleurUpload.class, "getFile", path.getFileName().toString()).build().toString();
			      return new FileInfo(filename, url);
			    }).collect(Collectors.toList());
			    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
			  }
			  @GetMapping("/files/{filename:.+}")
			  @ResponseBody
			  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
			    Resource file = storageService.load(filename);
			    return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
			  }
			}