package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ScDao;
import com.dao.impl.ScDaoImpl;
import com.entity.Sc;

/**
 * Servlet implementation class MfindAllServlet
 */
@WebServlet(name = "SfindAllServlet", value = "/sfindAll.do")
public class SfindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScDaoImpl dao = new ScDao();
		try {
			List<Sc> list = dao.sfindAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("sc.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}

}