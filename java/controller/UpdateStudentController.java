package com.infosys.servlet_simple_demo_crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.infosys.servlet_simple_demo_crud.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/updateStudent")
public class UpdateStudentController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		long phoneNumber = Long.parseLong(req.getParameter("phoneNumber"));
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		
		System.out.println(id);
		
		boolean b=new StudentDao().updateStudentDetailsById(id, name, password, email, phoneNumber, dob, gender);
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		if (b) {
			pw.write("<html><body><h3 style='color:blue;'>Details of ID: "+id+" are Updated Successfully.</h3>");
			pw.write("</body></html>");
			
//			req.getSession().setAttribute("updateSuccess", "The Student details of id "+id+" is Updated Successfully.");
//			resp.sendRedirect("student-dislay.jsp");
			
			req.getRequestDispatcher("student-login.jsp").include(req, resp);
			
		} else {
			pw.write("<html><body><h3 style='color:Red;'>!!Details are not Updated, Enter the Data field properly.</h3>");
			pw.write("</body></html>");
			
			req.getRequestDispatcher("student-display.jsp").include(req, resp);
		}
		
	}
}
