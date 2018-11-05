package com.myBlog.controller.usercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBlog.models.User;
import com.myBlog.services.UserServices;
@WebServlet("/register")
public class UserRegister extends HttpServlet {
//	private UserServices userServices;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		User user = new User(username,req.getParameter("password"),req.getParameter("email"),req.getParameter("phone"),req.getParameter("qq"),req.getParameter("info"));
		UserServices userServices = new UserServices();
		boolean flag = userServices.register(user);
		if(flag) {
			out.println("注册成功！请登录！");
	    	resp.setHeader("refresh", "3,url=login.html");
		}else{
			out.println("该用户存在！请重新注册！");
	    	resp.setHeader("refresh", "3,url=account.jsp");
		}
	}

}
