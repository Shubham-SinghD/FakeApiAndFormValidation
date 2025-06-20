package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PdfDocument;
@Repository
public interface ResumeRepo extends JpaRepository<PdfDocument, Integer> {




}
