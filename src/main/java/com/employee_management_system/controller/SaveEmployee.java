package com.employee_management_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee_management_system.dao.AdminDao;
import com.employee_management_system.dao.EmployeeDao;
import com.employee_management_system.dto.Admin;
import com.employee_management_system.dto.Employee;
@WebServlet("/SaveEmployee")
public class SaveEmployee  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	Admin admin=(Admin)session.getAttribute("Admin");
	
	if(admin!=null) {
	String name=req.getParameter("Name");
	String email=req.getParameter("Email");
	long contact=Long.parseLong(req.getParameter("Contact"));
	String designation=	req.getParameter("Designation");
	double salary=Double.parseDouble(req.getParameter("Salary"));
	
	ServletContext context=getServletContext();
    String companyname=	context.getInitParameter("CompanyName");
		
    Employee employee=new Employee();
    employee.setEmployeeName(name);
    employee.setEmployeeEmail(email);
    employee.setEmployeeContact(contact);
    employee.setEmployeeDesignation(designation);
    employee.setEmployeeSalary(salary);
    employee.setCompanyName(companyname);
    employee.setAdmin(admin);
    
    EmployeeDao dao=new EmployeeDao();
    dao.saveEmployee(employee);
    
 List<Employee> employees = admin.getEmployees();
 employees.add(employee);
 
 AdminDao admindao= new AdminDao();
 admindao.updateAdmin(admin);
    
    resp.sendRedirect("DashBoard.jsp");
    
	}else {
		resp.sendRedirect("AdminLogin.jsp");
	}
	
	
}}
