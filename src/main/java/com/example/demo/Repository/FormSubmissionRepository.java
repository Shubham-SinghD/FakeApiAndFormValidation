package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FormSubmission;
@Repository
public interface FormSubmissionRepository extends JpaRepository<FormSubmission, Long>{

}
 