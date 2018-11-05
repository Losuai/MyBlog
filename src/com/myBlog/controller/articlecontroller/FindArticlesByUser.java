package com.myBlog.controller.articlecontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBlog.models.PageBean;
import com.myBlog.models.User;
import com.myBlog.repository.UserRepository;
import com.myBlog.services.ArticleServices;

public class FindArticlesByUser extends HttpServlet {
	private UserRepository userRepository = new UserRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String currentPage = req.getParameter("currentPage");
		String pageSize = req.getParameter("pageSize");
		if(currentPage == null || currentPage.trim().isEmpty() || currentPage == "" ) {
			currentPage = "1";
		}
		if(pageSize == null || pageSize.isEmpty() || pageSize == "") {
			pageSize = "5";
		}
		ArticleServices articleServices = new ArticleServices();
		User loginingUser = (User)req.getSession().getAttribute("user");
		int userId  = userRepository.findByUsername(loginingUser.getUsername()).getId();
		PageBean pageBean = articleServices.findAllArticlesByUser(Integer.parseInt(currentPage), Integer.parseInt(pageSize),userId);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
