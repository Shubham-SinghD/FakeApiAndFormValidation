package com.example.demo.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileResponse;
import com.example.demo.entity.PdfDocument;
import com.example.demo.service.ResumeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/resume")
@CrossOrigin(origins = "*")
public class FileUploadController {
	@Autowired
	ResumeService resumeService;
	@PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		return resumeService.uploadFile(file);
	}

	@GetMapping("/AllFile")
	public ResponseEntity<byte[]> showUploadedFile() {
		return resumeService.downloadAllAsZip();
	}
	@GetMapping("/downloadFileResume/{id}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable("id") int id) {
		return resumeService.downloadFile(id);
	   
	}
	
	
	
	

	
	
}