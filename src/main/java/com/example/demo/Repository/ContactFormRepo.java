package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ContactForm;
@Repository
public interface ContactFormRepo extends JpaRepository<ContactForm, Long>{
}
