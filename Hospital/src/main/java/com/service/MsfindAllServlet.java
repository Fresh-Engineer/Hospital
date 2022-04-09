package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StockDao;
import com.dao.impl.StockDaoImpl;
import com.entity.Stock;

/**
 * Servlet implementation class MsfindAllServlet
 */
@WebServlet(name = "MsfindAllServlet", value = "/msfindAll.do")
public class MsfindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDaoImpl dao = new StockDao();
		try {
			List<Stock> list = dao.msfindAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("stock.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
			
	}

}
