package com.myBlog.services;

import java.util.List;

import com.myBlog.models.Article;
import com.myBlog.models.PageBean;
import com.myBlog.repository.ArticleRepository;

public class ArticleServices {
	private ArticleRepository articleRepository = new ArticleRepository();
	public void publishArticle(Article article) {
		articleRepository.PublishArticle(article);
	}
	public PageBean findAllArticles(Integer currentPage, Integer pageSize) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		int totalCount = articleRepository.queryTotalCount();
		pageBean.setTotalCount(totalCount);
		List<Article> articleList = articleRepository.finAllArticles(currentPage, pageSize);
		pageBean.setData(articleList);
		return pageBean;
	}
	public void DeleteArticleById(int articleId) {
		articleRepository.deleteArticleByArticleId(articleId);
	}
	public void updateArticle(Article article) {
		articleRepository.updateArticle(article);
	}
	public PageBean findAllArticlesByUser(Integer currentPage, Integer pageSize,Integer userId) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		int totalCount = articleRepository.queryTotalCount();
		pageBean.setTotalCount(totalCount);
		List<Article> articleList = articleRepository.findArticlesByUserId(currentPage, pageSize, userId);
		pageBean.setData(articleList);
		return pageBean;
	}
}
