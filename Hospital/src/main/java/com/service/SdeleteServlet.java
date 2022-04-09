package com.service;

import com.dao.ScDao;
import com.dao.impl.ScDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Servlet implementation class MdeleteServlet
 */
@WebServlet(name = "SdeleteServlet", value = "/sdelete.do")
public class SdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("sno");
		String sno = String.valueOf(strId);
		ScDaoImpl dao= new ScDao();
		try {
			dao.s_delete(sno);
			response.sendRedirect("sfindAll.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
