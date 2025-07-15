package com.infosys.servlet_simple_demo_crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.infosys.servlet_simple_demo_crud.dao.StudentDao;
import com.infosys.servlet_simple_demo_crud.entity.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentController extends  HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Insert Student Completed.");
		System.out.println("================================");
		
//		1) Access data from server and showon console
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		Long phoneNumber=Long.parseLong(req.getParameter("phoneNumber"));
		LocalDate dob=LocalDate.parse(req.getParameter("dob"));
		String gender=req.getParameter("gender");
//		
		//print on console
		System.out.println("Student Id is         : " + id);
		System.out.println("Student Name is       : " + name);
		System.out.println("Student Password is   : " + password);
		System.out.println("Student Email is      : " + email);
		System.out.println("Student PhoneNumber is: " + phoneNumber);
		System.out.println("Student DOB is        : " + dob);
		System.out.println("Student Gender is     : " + gender);
//		
		
		
		
		
		// #### SEND data to DATABASE using save/insert Dao ######

		Student student = new Student(id, name, password, email, phoneNumber, dob, gender);
		Student student1 = new StudentDao().saveStudentDao(student);

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		if (student1 != null) {
			pw.write("<html><body><h3 style='color:blue;'>Registered Successfully</h3>");
			pw.write("</body></html>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("student-login.jsp");
			dispatcher.include(req, resp);
		} else {
			pw.write("<html><body><h3 style='color:red;'>Something went wrong!</h3>");
			pw.write("</body></html>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("student-register.jsp");
			dispatcher.include(req, resp);
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		2)Details shown on UI from the server, not on console
		
//		resp.setContentType("text/html");
//
//		PrintWriter pw=resp.getWriter();
		
//		pw.write(id);//It converts to Unicode value so make it or convert it to String
	
//		pw.write(String.valueOf(id));
//		pw.write(id);
		
//		pw.write(id+"");
//		pw.write(name);
		
		
		// Here we can't change the Color/text/or any modification while getting response from server to UI
		// TODO: How to write Java Code in HTML (here we use '' at the place of "")
		
//		pw.write("<html><body><h3 style='color:Red'>name</h3>");// here this 'name' behave as text for h3 it prints same
		
//		pw.write("<html><body>");
//		pw.write("<h3 style='white-space: pre;'>Id is             = <span style='color:Red'>" + id + "</span></h3>");
//		pw.write("<h3 style='white-space: pre;'>Name is       = <span style='color:Blue'>" + name + "</span></h3>");
//		pw.write("<h3 style='white-space: pre;'>Password is = <span style='color:Blue'>" + password + "</span></h3>");
//		pw.write("<h3 style='white-space: pre;'>Email is       = <span style='color:Blue'>" + email + "</span></h3>");
//		pw.write("<h3 style='white-space: pre;'>Phon.No. is  = <span style='color:Blue'>" + phoneNumber+ "</span></h3>");
//		pw.write("<h3 style='white-space: pre;'>DOB is         = <span style='color:Blue'>" + dob + "</span></h3>");
//		pw.write("<h3 style='white-space: pre;'>Gender is     = <span style='color:Blue'>" + gender + "</span></h3>");
//		pw.write("</body></html>");
//		
	}
}
