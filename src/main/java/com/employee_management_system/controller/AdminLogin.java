package com.employee_management_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee_management_system.dao.AdminDao;
import com.employee_management_system.dto.Admin;

@WebServlet("/Login")
public class AdminLogin  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String adminEmail=	req.getParameter("AdminEmail");
	String adminPassword=	req.getParameter("AdminPassword");
	
	AdminDao dao= new AdminDao();
Admin admin = dao.adminLogin(adminEmail, adminPassword);
	
	if(admin!=null) {
	HttpSession session = req.getSession();
		session.setAttribute("Admin", admin);
		req.getRequestDispatcher("DashBoard.jsp").forward(req, resp);
		
	}else {
		resp.sendRedirect("AdminSignup.jsp");
	}

	}

}
