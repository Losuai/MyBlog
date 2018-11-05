package com.myBlog.controller.articlecontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBlog.models.PageBean;
import com.myBlog.services.ArticleServices;

public class FindAllArticles extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		PageBean pageBean = articleServices.findAllArticles(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
