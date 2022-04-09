package com.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.StockDao;
import com.dao.impl.StockDaoImpl;


/**
 * Servlet implementation class MsdeleteServlet
 */
@WebServlet(name = "MsdeleteServlet", value = "/msdelete.do" )
public class MsdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strsId = request.getParameter("m_sid");
		Integer ms_id = Integer.parseInt(strsId);
		StockDaoImpl dao = new StockDao();
		try {
			dao.ms_delete(ms_id);
			response.sendRedirect("msfindAll.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
