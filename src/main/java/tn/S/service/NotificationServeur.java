package tn.S.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.S.entities.Employes;
import tn.S.repository.EmployeRepository;



@Service
public class NotificationServeur {

	
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	EmployeRepository userRepository;
	@Autowired
   cryptWithMD5 cryptWithMD5;
	public NotificationServeur(JavaMailSender javaMAilSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(Employes user){
		
		String password="";
		
		for (int i=0;i<10;i++ ) {
			password = password+randomCharacter("abcdefjhijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUV");
		}
		String randomdigit=randomCharacter("123456789");
		password=insertAtRandom(password, randomdigit);
		String randomSymbol=randomCharacter("$£@@@");
		password = insertAtRandom(password, randomSymbol);
		String pass=password;
		String cryptePassword=cryptWithMD5.cryptWithMD5(pass);
		System.out.println("avant base de donne "+cryptePassword);
		
		user.setPassword(cryptePassword);		
		userRepository.save(user);
		System.out.println("apres base de donne "+cryptePassword);
		System.out.println("base de donne "+user.getPassword());
		
		System.out.println(pass);
		//sending email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("youssef.ayari1@esprit.tn");
		mail.setSubject("3S");
		mail.setText(cryptePassword);
		javaMailSender.send(mail);
		System.out.println("apres mail"+user.getPassword());
	}
	public static String randomCharacter(String charachter) {
		int n = charachter.length();
		int r = (int)(n*Math.random());
		
		return charachter.substring(r,r+1);
	}
	public static String insertAtRandom(String str,String toInsert) {
		int n = str.length();
		int r=(int)(n * Math.random());
		return str.substring(0,r)+ toInsert + str.substring(r);
	}	
	
	
}
