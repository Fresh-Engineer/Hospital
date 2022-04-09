package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.DepartmentDao;
import com.dao.impl.DepartmentDaoImpl;
import com.entity.Department;

/**
 * Servlet implementation class MfindAllServlet
 */
@WebServlet(name = "KfindAllServlet", value = "/kfindAll.do")
public class KfindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentDaoImpl dao = new DepartmentDao();
		try {
			List<Department> list = dao.kfindAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("department.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}

}