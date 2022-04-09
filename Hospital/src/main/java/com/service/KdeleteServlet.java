package com.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DepartmentDao;
import com.dao.impl.DepartmentDaoImpl;


/**
 * Servlet implementation class KdeleteServlet
 */
@WebServlet(name = "KdeleteServlet", value = "/kdelete.do")
public class KdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("kno");
		String kno = String.valueOf(strId);
		DepartmentDaoImpl dao= new DepartmentDao();
		try {
			dao.k_delete(kno);
			response.sendRedirect("kfindAll.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
}
