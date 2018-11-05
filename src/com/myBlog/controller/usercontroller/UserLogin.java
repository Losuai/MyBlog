package com.myBlog.controller.usercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myBlog.models.User;
import com.myBlog.services.UserServices;
@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private UserServices userServices = new UserServices();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPasswod(password);
		if(userServices.login(user)) {
			HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(10);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else {
			out.println("√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ ‰»Î£°");
			resp.setHeader("refresh", "1,url=");
		}
	}

}
