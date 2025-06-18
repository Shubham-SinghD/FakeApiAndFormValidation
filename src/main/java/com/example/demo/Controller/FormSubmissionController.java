package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.FormSubmissionRepository;
import com.example.demo.entity.FormSubmission;

@RestController
@CrossOrigin(origins = "*")
public class FormSubmissionController {
	@Autowired
	FormSubmissionRepository formSubmissionRepository;
	
	@PostMapping("/upload")
	public ResponseEntity<String> handleUpload(@RequestBody FormSubmission formSubmission) {
	        formSubmissionRepository.save(formSubmission);

	        return ResponseEntity.ok("Form submitted and file uploaded successfully!");
	    }
	}

	


