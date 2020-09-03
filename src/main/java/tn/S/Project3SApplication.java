package tn.S;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.S.entities.Categorie;
import tn.S.entities.Produit;
import tn.S.repository.CategorieRepository;
import tn.S.repository.EmployeRepository;
import tn.S.repository.ProduitRepository;
import tn.S.service.Storageservice;

@SpringBootApplication
@EnableSwagger2
public class Project3SApplication {

	@Resource
	  Storageservice storageService;
	
	public static void main(String[] args) {

		/*new File(RestcontrolleurUpload.uploadDirectory).mkdir();
		SpringApplication.run(Project3SApplication.class, args);*/
	ApplicationContext A = SpringApplication.run(Project3SApplication.class, args);

ProduitRepository produitrepository = A.getBean(ProduitRepository.class);

		produitrepository.save(new Produit("delice", 1257));
		produitrepository.save(new Produit("Saidaa", 1288));
		produitrepository.save(new Produit("Nutella", 2528));

		Categorie c1 = new Categorie("luxe", "mc");
		Categorie c2 = new Categorie("cher", "kc");

		CategorieRepository categoriereposiyory = A.getBean(CategorieRepository.class);

		categoriereposiyory.save(c1);
		categoriereposiyory.save(c2);

		produitrepository.save(new Produit("Nutella", 252, c1));
		produitrepository.save(new Produit("Nutella", 254, c1));
		produitrepository.save(new Produit("Nutella", 400, c1));

		produitrepository.findAll().forEach(e -> e.getNom());
		
		
		EmployeRepository employerepository = A.getBean(EmployeRepository.class);

	


	}
	
	public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }
	
	

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("tn.S"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("docs-api.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Gain Java Knowledge Api").description("Sample Api for Gain Java Knowledge")
				.termsOfServiceUrl("https://www.youtube.com/watch?v=BriwcM14RpE").license("GainJavaKnowledge License")
				.licenseUrl("https://www.youtube.com/watch?v=BriwcM14RpE").version("1.0").build();

	}
}
