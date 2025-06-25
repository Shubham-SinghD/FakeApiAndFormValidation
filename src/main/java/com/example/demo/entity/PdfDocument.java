package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
//@Data
@Entity
@Table(name = "pdf_documents")
public class PdfDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    private String filename;

    @Lob
    @Column(name = "pdf_content")
    private byte[] pdfContent;

    public PdfDocument() {
    }

    public PdfDocument(String filename, byte[] pdfContent) {
        this.filename = filename;
        this.pdfContent = pdfContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getPdfContent() {
        return pdfContent;
    }

    public void setPdfContent(byte[] pdfContent) {
        this.pdfContent = pdfContent;
    }
}