package com.example.demo.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import org.springframework.http.MediaType;


@RestController
@RequestMapping("/resume")
@CrossOrigin(origins = "*")
public class FileUploadController {
	
	@PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		String fileName=file.getOriginalFilename();
		try {
			file.transferTo(new File("D:\\sh\\"+fileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "File uploaded Successfully";
	}


}