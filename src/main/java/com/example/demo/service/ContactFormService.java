package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ContactFormRepo;
import com.example.demo.entity.ContactForm;

@Service
public class ContactFormService {
	@Autowired
	private ContactFormRepo contactFormRepo;
	
	
	public ContactForm setCOntactForm(ContactForm cf) {
		return contactFormRepo.save(cf);
		
	}

}
