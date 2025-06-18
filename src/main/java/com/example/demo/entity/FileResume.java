package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="resume")
public class FileResume {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String filename;
private String fileType;
private Long fileSize;
private LocalDateTime uploadTime;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getFileType() {
	return fileType;
}
public void setFileType(String fileType) {
	this.fileType = fileType;
}
public Long getFileSize() {
	return fileSize;
}
public void setFileSize(Long fileSize) {
	this.fileSize = fileSize;
}
public LocalDateTime getUploadTime() {
	return uploadTime;
}
public void setUploadTime(LocalDateTime uploadTime) {
	this.uploadTime = uploadTime;
}
public FileResume(Long id, String filename, String fileType, Long fileSize, LocalDateTime uploadTime) {
	super();
	this.filename = filename;
	this.fileType = fileType;
	this.fileSize = fileSize;
	this.uploadTime = uploadTime;
}
public FileResume() {
	super();
	// TODO Auto-generated constructor stub
}



}
