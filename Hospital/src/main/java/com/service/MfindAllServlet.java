package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MedicineDao;
import com.dao.impl.MedicineDaoImpl;
import com.entity.Medicine;

/**
 * Servlet implementation class MfindAllServlet
 */
@WebServlet(name = "MfindAllServlet", value = "/mfindAll.do")
public class MfindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicineDaoImpl dao = new MedicineDao();
		try {
			List<Medicine> list = dao.mfindAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("medicine.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}

}
