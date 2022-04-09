package com.service;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DoctorDao;
import com.dao.impl.DoctorDaoImpl;
import com.entity.Doctor;

/**
 * Servlet implementation class AddDoctor
 */
@WebServlet("/addDoctor.do")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strm_Id = request.getParameter("cnoo");
		String cnoo = String.valueOf(strm_Id);
		String cname = request.getParameter("cname");
		String cteacher = request.getParameter("cteacher");
		String ccredit = request.getParameter("ccredit");
		Doctor doctor = new Doctor();
		doctor.setCnoo(new String(cnoo.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		doctor.setCname(new String(cname.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		doctor.setCteacher(new String(cteacher.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		doctor.setCcredit(new String(ccredit.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));

		DoctorDaoImpl dao = new DoctorDao();
		request.setCharacterEncoding("UTF-8");
		try {
			dao.d_save(doctor);
			response.sendRedirect("dfindAll.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
