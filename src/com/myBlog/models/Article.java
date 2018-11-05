package com.myBlog.models;

import java.io.Serializable;

public class Article implements Serializable{
	private int id;
	private String title;
	private String content;
	private String pub_date;
	private int user_id;
	private int articletype_id;
	private String url;
	public Article() {
		super();
	}
	public Article(String title, String content, String pub_date, int user_id,String url) {
		this.title = title;
		this.content = content;
		this.pub_date = pub_date;
		this.user_id = user_id;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getArticletype_id() {
		return articletype_id;
	}
	public void setArticletype_id(int articletype_id) {
		this.articletype_id = articletype_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
