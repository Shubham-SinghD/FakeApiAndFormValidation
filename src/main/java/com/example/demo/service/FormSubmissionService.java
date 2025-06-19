package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.FormSubmissionRepository;
import com.example.demo.entity.FormSubmission;

@Service
public class FormSubmissionService {
	@Autowired
	private FormSubmissionRepository formSubmissionRepository;
	
	public void handleUpl(FormSubmission formSubmission) {
		
		FormSubmission save = formSubmissionRepository.save(formSubmission);
		return;
	
	}
	
	public List<FormSubmission> showData() {
		List<FormSubmission> all = formSubmissionRepository.findAll();
		return all;
	}
	
	
	
	
	
	
	
	
	
	
}
