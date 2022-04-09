package com.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MedicineDao;
import com.dao.impl.MedicineDaoImpl;


/**
 * Servlet implementation class MdeleteServlet
 */
@WebServlet(name = "MdeleteServlet", value = "/mdelete.do")
public class MdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("m_id");
		Integer m_id = Integer.parseInt(strId);
		MedicineDaoImpl dao= new MedicineDao();
		try {
			dao.m_delete(m_id);
			response.sendRedirect("mfindAll.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
