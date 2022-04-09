package com.service;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DoctorDao;
import com.dao.impl.DoctorDaoImpl;


/**
 * Servlet implementation class KdeleteServlet
 */
@WebServlet(name = "DdeleteServlet", value = "/ddelete.do")
public class DdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("cnoo");
		String cnoo = String.valueOf(strId);
		DoctorDaoImpl dao= new DoctorDao();
		try {
			dao.d_delete(cnoo);
			response.sendRedirect("dfindAll.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
}
