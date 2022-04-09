package com.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MedicineDao;
import com.dao.impl.MedicineDaoImpl;
import com.entity.Medicine;

/**
 * Servlet implementation class AddMedicine
 */
@WebServlet(name = "AddMedicineServlet", value = "/addMedicine.do")
public class AddMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_name = request.getParameter("m_name");
		String m_type = request.getParameter("m_type");
		String m_brand = request.getParameter("m_brand");
		String strm_Price = request.getParameter("m_price");
		Integer m_price = Integer.parseInt(strm_Price);
		String m_specification = request.getParameter("m_specification");
		Medicine medicine = new Medicine();
		medicine.setM_name(new String(m_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		medicine.setM_type(new String(m_type.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		medicine.setM_brand(new String(m_brand.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		medicine.setM_price(m_price);
		medicine.setM_specification(new String(m_specification.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		MedicineDaoImpl dao = new MedicineDao();
		request.setCharacterEncoding("utf-8");
		try {
			dao.m_save(medicine);
			response.sendRedirect("mfindAll.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
