package com.service;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ScDao;
import com.entity.Sc;

/**
 * Servlet implementation class AddSc
 */
@WebServlet("/addSc.do")
public class AddScServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strm_Id = request.getParameter("sno");
		String sno = String.valueOf(strm_Id);
		String ssno = request.getParameter("ssno");
		String srade = request.getParameter("srade");
		Sc sc = new Sc();
		sc.setSno(new String(sno.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		sc.setSsno(new String(ssno.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		sc.setSrade(new String(srade.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		ScDao dao = new ScDao();
		try {
			dao.s_save(sc);
			response.sendRedirect("sfindAll.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
