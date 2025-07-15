package com.infosys.servlet_simple_demo_crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.infosys.servlet_simple_demo_crud.dao.StudentDao;
import com.infosys.servlet_simple_demo_crud.entity.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginStudentController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// #### Fetch data from DATABASE using email,password getStudentDetailsDao
		// ######

		String loginEmail = req.getParameter("loginEmail");
		String loginPassword = req.getParameter("loginPassword");

		Student student2 = new StudentDao().getStudentByEmailPasswordDao(loginEmail, loginPassword);

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		if (student2 != null) {
			pw.write("<html><body>");
			pw.write("<h2 style='color:blue;'>Login SuccessFully</h3>");
		
//			pw.write("<h3 style='white-space:pre';>Id is              : <span style='color:Purple;'>" + student2.getId() + "</span></h3>");
//			pw.write("<h3 style='white-space:pre';>Name is        : <span style='color:Purple;'>" + student2.getName() + "</span></h3>");
//			pw.write("<h3 style='white-space:pre';>Password is : <span style='color:Purple;'>" + student2.getPassword() + "</span></h3>");
//			pw.write("<h3 style='white-space:pre';>Email is        : <span style='color:Purple;'>" + student2.getEmail() + "</span></h3>");
//			pw.write("<h3 style='white-space:pre';>PhoneNo. is : <span style='color:Purple;'>" + student2.getPhone() + "</span></h3>");
//			pw.write("<h3 style='white-space:pre';>DOB is          : <span style='color:Purple;'>" + student2.getDob() + "</span></h3>");
//			pw.write("<h3 style='white-space:pre';>Gender is    : <span style='color:Purple;'>" + student2.getGender() + "</span></h3>");
//			pw.write("</body></html>");

//			//TODO: HEre we see the output in the same servlet page with all remaining includes pages or content of that page
//			RequestDispatcher dispatcher = req.getRequestDispatcher("student-display.jsp");
//			dispatcher.include(req, resp);
//			req.getRequestDispatcher("student-display.jsp").include(req, resp);
			
			
			req.setAttribute("studentObj", student2); // pass student data to JSP
			req.getRequestDispatcher("student-display.jsp").forward(req, resp);
			
		} else {
			pw.write("<html><body><h3 style='color:red;'>Something went wrong!</h3>");
			pw.write("</body></html>");

//			RequestDispatcher dispatcher = req.getRequestDispatcher("student-login.jsp");
//			dispatcher.include(req, resp);
			
			req.getRequestDispatcher("student-login.jsp").include(req, resp);
//			req.getRequestDispatcher("student-login.jsp").forward(req, resp);
		}

	}
}
