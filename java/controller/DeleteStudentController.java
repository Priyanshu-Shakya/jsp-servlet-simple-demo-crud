package com.infosys.servlet_simple_demo_crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.infosys.servlet_simple_demo_crud.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//>>>>>>>>>>>>>>>TODO: IMP<<<<<<<<<<<<<<<<<<<<
@WebServlet(value="/deleteStudent")
public class DeleteStudentController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		
		Boolean b=new StudentDao().deleteStudentById(id);
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		
		if (b) {
			pw.write("<html><body><h3 style='color:Blue;'>Selected id "+id+" data Deleted SuccessFully</h3>");
			pw.write("</body></html>");
			
			req.getRequestDispatcher("student-register.jsp").include(req, resp);
//			req.getSession().setAttribute("msg", "Selected id data Deleted Successfully");
//			resp.sendRedirect("student-display.jsp");
			
		} else {
			pw.write("<html><body><h3 style='color:red;'>Selected id data is not Delete</h3>");
			pw.write("</body></html>");
			
			req.getRequestDispatcher("student-display.jsp").include(req, resp);
		}
	}
}