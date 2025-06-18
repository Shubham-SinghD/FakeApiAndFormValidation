//package com.example.demo.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entity.ContactForm;
//import com.example.demo.service.ContactFormService;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class ContactFormController {
//	@Autowired
//	private ContactFormService contactFormService;
//	
//	@PostMapping("/submit-form")
//	public ContactForm setContForm(@RequestBody ContactForm cf) {
//		return contactFormService.setCOntactForm(cf);
//	}
//
//}
