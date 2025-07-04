package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ArticleApi;

@Repository
public interface ArticleRepo extends JpaRepository<ArticleApi, Long> {

}
