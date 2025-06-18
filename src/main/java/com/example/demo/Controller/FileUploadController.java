//package com.example.demo.Controller;
//
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.http.ResponseEntity;
//
//import java.io.File;
//import java.io.IOException;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class FileUploadController {
//
//    private static final String UPLOAD_DIR = "uploads/";
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        try {
//            File directory = new File(UPLOAD_DIR);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            String filePath = UPLOAD_DIR + file.getOriginalFilename();
//            System.out.println("Saving file to: " + filePath); // Debug log
//            file.transferTo(new File(filePath));
//
//            return ResponseEntity.ok("File uploaded successfully: " + filePath);
//        } catch (IOException e) {
//            e.printStackTrace(); // Print full error
//            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
//        }
//    }
//
//}
