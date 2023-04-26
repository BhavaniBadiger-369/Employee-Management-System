package com.employee_management_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee_management_system.dao.EmployeeDao;
import com.employee_management_system.dto.Admin;
import com.employee_management_system.dto.Employee;

@WebServlet("/ViewEmployees")
public class GetAllEmployees extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

HttpSession session= req.getSession();
Admin admin=(Admin)session.getAttribute("Admin");
	
if(admin!=null) {
	
	EmployeeDao dao= new EmployeeDao();
List<Employee> employees=dao.getAllEmployees(admin);

 req.setAttribute("EmployeesList", employees);
	req.getRequestDispatcher("ViewEmployees.jsp").forward(req, resp);
	
	}else {
		resp.sendRedirect("AdminLogin.jsp");
	}
}
}
