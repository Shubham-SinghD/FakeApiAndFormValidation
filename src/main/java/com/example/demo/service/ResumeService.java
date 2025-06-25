package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.ResumeRepo;
import com.example.demo.entity.PdfDocument;
@Service
public class ResumeService {
	@Autowired
	ResumeRepo resumeRepo;
	
	
	public String uploadFile(MultipartFile file) {
		try {
			PdfDocument doc = new PdfDocument(file.getOriginalFilename(),file.getBytes());
			resumeRepo.save(doc);
			return "File Uploaded SuccessFully";
		} catch (IOException e) {
			e.printStackTrace();
			return "File Failled "+e.getMessage();
		}
	}
	



	public ResponseEntity<byte[]> downloadFile(int id) {
        Optional<PdfDocument> optionalDoc = resumeRepo.findById(id);

        if (optionalDoc.isPresent()) {
            PdfDocument doc = optionalDoc.get();
            String filename = doc.getFilename();
            byte[] content = doc.getPdfContent();

            MediaType mediaType = getMediaType(filename);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(mediaType);
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename(filename).build());

            return new ResponseEntity<>(content, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } 
    }

    private MediaType getMediaType(String filename) {
        if (filename == null) return MediaType.APPLICATION_OCTET_STREAM;

        String lower = filename.toLowerCase();
        if (lower.endsWith(".pdf")) return MediaType.APPLICATION_PDF;
        if (lower.endsWith(".png")) return MediaType.IMAGE_PNG;
        if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) return MediaType.IMAGE_JPEG;
        if (lower.endsWith(".gif")) return MediaType.IMAGE_GIF;

        return MediaType.APPLICATION_OCTET_STREAM; 
    }
    


    public ResponseEntity<byte[]> downloadAllAsZip() {
        List<PdfDocument> documents = resumeRepo.findAll();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ZipOutputStream zos = new ZipOutputStream(baos)) {

            for (PdfDocument doc : documents) {
                ZipEntry entry = new ZipEntry(doc.getFilename());
                zos.putNextEntry(entry);
                zos.write(doc.getPdfContent());
                zos.closeEntry();
            }

            zos.finish();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition.attachment().filename("all_files.zip").build());

            return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    
//    public ResponseEntity<byte[]> AlldownloadFile() {
//         List<PdfDocument> optionalDoc = resumeRepo.findAll();
//
//        if (optionalDoc.isEmpty()) {
//        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } 
////        
////            PdfDocument doc = optionalDoc.get(0);
////            String filename = doc.getFilename();
////            byte[] content = doc.getPdfContent();
////
////            MediaType mediaType = getMediaType(filename);
////
////            HttpHeaders headers = new HttpHeaders();
////            headers.setContentType(mediaType);
////            headers.setContentDisposition(ContentDisposition.builder("attachment")
////                    .filename(filename).build());
////
////            return new ResponseEntity<>(content, headers, HttpStatus.OK);
//        PdfDocument doc = optionalDoc.get(0); // Assuming you want the first document
//        String filename = doc.getFilename();
//        byte[] content = doc.getPdfContent();
//
//        MediaType mediaType = getMediaType(filename);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(mediaType);
//        headers.setContentDisposition(ContentDisposition.builder("attachment")
//                .filename(filename).build());
//
//        return new ResponseEntity<>(content, headers, HttpStatus.OK);
//}

    
    public ResponseEntity<List<Map<String, String>>> getAllDocuments() {
        List<PdfDocument> documents = resumeRepo.findAll();

        if (documents.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        List<Map<String, String>> response = new ArrayList<>();

        for (PdfDocument doc : documents) {
            Map<String, String> fileData = new HashMap<>();
            fileData.put("filename", doc.getFilename());
            fileData.put("contentType", getMediaType(doc.getFilename()).toString());
            fileData.put("base64", Base64.getEncoder().encodeToString(doc.getPdfContent()));
            response.add(fileData);
        }

        return ResponseEntity.ok(response);
    }
    


    
	

}
