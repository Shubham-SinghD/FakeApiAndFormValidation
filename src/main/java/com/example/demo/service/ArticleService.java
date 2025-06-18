package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ArticleRepo;
import com.example.demo.entity.ArticleApi;

@Service
public class ArticleService {
	
	
	@Autowired
	private ArticleRepo articleRepo;
	
	public ArticleApi setArticle(ArticleApi articleApi) {
		return articleRepo.save(articleApi);
	}
	
	
	public List<ArticleApi> getArticle() {
		return articleRepo.findAll();
	}
	
	public String deleteArticlie(long id) {
		articleRepo.deleteById(id);
		return "Deleted Article";
	}

}
