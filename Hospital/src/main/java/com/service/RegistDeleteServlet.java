package com.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegistDao;
import com.dao.impl.RegistDaoImpl;

/**
 * 取消挂号
 */
@WebServlet(name = "RegistDeleteServlet", value = "/registDelete.do")
public class RegistDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("IDcard");
//		Integer IDcard = Integer.parseInt(strId);
		RegistDaoImpl dao = new RegistDao();
		try {
			dao.delete(strId);
			response.sendRedirect("findByRegist.do");
		}catch(SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
