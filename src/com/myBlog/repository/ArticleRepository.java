package com.myBlog.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.myBlog.models.Article;
import com.myBlog.utils.JdbcTools;
import com.mysql.jdbc.Connection;

public class ArticleRepository {
	
	public void PublishArticle(Article article) {
		String sql = "insert into t_article(title,content,pub_date,user_id,url)value(?,?,?,?,?) ";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcTools.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, article.getTitle());
			stmt.setString(2, article.getContent());
			stmt.setString(3, article.getPub_date());
			stmt.setInt(4, article.getUser_id());
			stmt.setString(5, article.getUrl());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn, stmt, null);
		}
	}
	public List<Article> finAllArticles(Integer currentPage,Integer pageSize){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet st = null;
		List<Article> list = new ArrayList<>(); 
		String sql = "select * from t_article limit ?,?";
		try {
			conn = JdbcTools.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (currentPage-1)*pageSize);
			stmt.setInt(2, pageSize);
			st = stmt.executeQuery();
			while(st.next()) {
			      Article article = new Article();
			      article.setId(st.getInt("id"));
			      article.setTitle(st.getString("title"));
			      article.setContent(st.getString("content"));
			      article.setPub_date(st.getString("pub_date"));
			      article.setUser_id(st.getInt("id"));
			      article.setUrl(st.getString("url"));
			      list.add(article);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn, stmt, st);
		}
		return null;
	}
	public List<Article> findArticlesByUserId(Integer currentPage,Integer pageSize, Integer userId){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet st = null;
		List<Article> list = new ArrayList<>();
		String sql = "select * from t_article where user_id = ? limit ?,?";
		try {
			conn = JdbcTools.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			stmt.setInt(2, (currentPage-1)*pageSize);
			stmt.setInt(3, pageSize);
			st = stmt.executeQuery();
			while(st.next()) {
			      Article article = new Article();
			      article.setId(st.getInt("id"));
			      article.setTitle(st.getString("title"));
			      article.setContent(st.getString("content"));
			      article.setPub_date(st.getString("pub_date"));
			      article.setUser_id(st.getInt("id"));
			      article.setUrl(st.getString("url"));
			      list.add(article);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn, stmt, st);
		}
		return null;
	}
	public void deleteArticleByArticleId(Integer articleId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from t_article where id = ?";
		try {
			conn = JdbcTools.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, articleId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn, stmt, null);
		}
	}
	public void updateArticle(Article article) {
		String sql = "update  t_article set title= ?, content =?,url=? where user_id =? ";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcTools.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, article.getTitle());
			stmt.setString(2, article.getContent());
			stmt.setString(3,article.getUrl());
			stmt.setInt(4, article.getUser_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn, stmt, null);
		}
	}
	public Integer queryTotalCount() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet st = null;
		int count = 0;
		String sql = "select count(*) from t_article ";
		try {
			conn = JdbcTools.getConnection();
			stmt = conn.prepareStatement(sql);
			st = stmt.executeQuery();
			if(st.next()) {
				count = st.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn, stmt, st);
		}
		return count;
	}
}
