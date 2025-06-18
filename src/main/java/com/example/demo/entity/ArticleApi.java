package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="shubham_article")
public class ArticleApi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
    private String title;
    private String body;
    private String link;
    private int comment_count;
	public ArticleApi(Long userId, Long id, String title, String body, String link, int comment_count) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
		this.link = link;
		this.comment_count = comment_count;
	}
	public ArticleApi() {
		super();
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	@Override
	public String toString() {
		return "ArticleApi [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + ", link=" + link
				+ ", comment_count=" + comment_count + "]";
	}
    
    

}
