package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DoctorDao;
import com.dao.impl.DoctorDaoImpl;
import com.entity.Doctor;

/**
 * Servlet implementation class MfindAllServlet
 */
@WebServlet(name = "DfindAllServlet",value = "/dfindAll.do")
public class DfindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorDaoImpl dao = new DoctorDao();
		try {
			List<Doctor> list = dao.dfindAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("doctor.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}

}