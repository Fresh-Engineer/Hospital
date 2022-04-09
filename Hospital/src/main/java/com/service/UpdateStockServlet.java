package com.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StockDao;
import com.dao.impl.StockDaoImpl;
import com.entity.Stock;



/**
 * Servlet implementation class UpdateStockServlet
 */
@WebServlet(name = "UpdateStockServlet", value = "/UpdateStock.do")
public class UpdateStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strsId = request.getParameter("m_sid");
		Integer m_sid = Integer.parseInt(strsId);
		String m_name = request.getParameter("m_name");
		String strn = request.getParameter("m_snumber");
		Integer m_snumber = Integer.parseInt(strn);
		Stock stock = new Stock();
		stock.setM_sid(m_sid);
		stock.setM_name(new String(m_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		stock.setM_snumber(m_snumber);

		StockDaoImpl dao = new StockDao();
		request.setCharacterEncoding("UTF-8");
		try {
			dao.updateStock(stock);
			response.sendRedirect("msfindAll.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}
