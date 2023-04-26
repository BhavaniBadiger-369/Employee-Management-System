package com.employee_management_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee_management_system.dao.AdminDao;
import com.employee_management_system.dto.Admin;
@WebServlet("/Signup")
public class AdminSignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String adminName = req.getParameter("AdminName");
	String adminEmail = req.getParameter("AdminEmail");
	long adminContact = Long.parseLong(req.getParameter("AdminContact"));	
	String adminPassword =	req.getParameter("AdminPassword");
		
Admin admin=new Admin();
admin.setAdminName(adminName);
admin.setAdminEmail(adminEmail);
admin.setAdminContact(adminContact);
admin.setAdminPassword(adminPassword);

   AdminDao dao=new AdminDao();
   dao.adminSignup(admin);

   req.getRequestDispatcher("AdminLogin.jsp").forward(req, resp);
   
	}

}
