package com.myBlog.controller.articlecontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.myBlog.models.Article;
import com.myBlog.models.User;
import com.myBlog.repository.UserRepository;
import com.myBlog.services.ArticleServices;

public class UpdateArticle extends HttpServlet {
	private UserRepository userRepository = new UserRepository();
	private ArticleServices articleServices = new ArticleServices();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String title  = req.getParameter("title");
		String content = req.getParameter("content");
		Part part = req.getPart("photo");
		String filename = getFileName(part);
		part.write(filename);
		String url = "D:\\Eclipse\\Workspace\\2016121071\\WebContent\\upload"+ filename;
		User loginingUser = (User)req.getSession().getAttribute("user");
		int userId  = userRepository.findByUsername(loginingUser.getUsername()).getId();
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		article.setUrl(url);
		article.setUser_id(userId);
		articleServices.updateArticle(article);
		out.println("£¡");
		resp.setHeader("refresh", "1,url=");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	private String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
		return filename;
	}
}
