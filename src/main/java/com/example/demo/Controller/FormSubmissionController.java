package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FormSubmission;
import com.example.demo.service.FormSubmissionService;

@RestController
@CrossOrigin(origins = "*")
public class FormSubmissionController {

	@Autowired
	FormSubmissionService formSubmissionService;
	@PostMapping("/upload")
	public ResponseEntity<String> handleUpload(@RequestBody FormSubmission formSubmission) {
		formSubmissionService.handleUpl(formSubmission);

	        return ResponseEntity.ok("Form submitted and file uploaded successfully!");
	    }
	
	@GetMapping("/allFormDataShowing")
	public List<FormSubmission> showFormData() {
		List<FormSubmission> showData = formSubmissionService.showData();
		return showData;
	}
	
	
	
	
	}

	


