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

@WebServlet("/SaveUpdatedEmployee")
public class SaveUpdatedEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session= req.getSession();
		Admin admin=(Admin)session.getAttribute("Admin");
			
		if(admin!=null) {
		int id=Integer.parseInt(req.getParameter("Id"));
		String name=req.getParameter("Name");
		String email=req.getParameter("Email");
		long contact=Long.parseLong(req.getParameter("Contact"));
		String designation=	req.getParameter("Designation");
		double salary=Double.parseDouble(req.getParameter("Salary"));
		String companyname=req.getParameter("CompanyName");
		
		Employee employee=new Employee();
		employee.setEmployeeId(id);
		employee.setEmployeeName(name);
		employee.setEmployeeEmail(email);
		employee.setEmployeeContact(contact);
		employee.setEmployeeDesignation(designation);
		employee.setEmployeeSalary(salary);
		employee.setCompanyName(companyname);
		employee.setAdmin(admin);
		
		EmployeeDao dao=new EmployeeDao();
		dao.updateEmployee(employee);
	List<Employee> employees=dao.getAllEmployees(admin);
	
	req.setAttribute("EmployeesList", employees);
		
		req.getRequestDispatcher("ViewEmployees.jsp").forward(req, resp);
		
		
	}else {
		resp.sendRedirect("AdminLogin.jsp");
	}
}
}

