//package com.example.demo.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entity.ArticleApi;
//import com.example.demo.service.ArticleService;
//
//
//@RestController
//public class ArticleController {
//	@Autowired
//	private ArticleService articleService;
//	
////	@GetMapping("/Home")
////	public String home() {
////		return "Home PAge";
////	}
//	
//	@PostMapping("/setArt")
//	public  ArticleApi setAticleUser(@RequestBody ArticleApi articleapi) {
//		return articleService.setArticle(articleapi);
//	}
//	
//	@GetMapping("/getArt")
//	public List<ArticleApi> getArticle() {
//		return articleService.getArticle();
//	}
//	@DeleteMapping("/deleteArt/{id}")
//	public String deleteArticle(@PathVariable("id") Long id) {
//		return articleService.deleteArticlie(id);
//	}
//	
//	
//
//}
