package com.service;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InpatientDao;
import com.dao.impl.InpatientDaoImpl;

/**
 * 删除患者信息
 * 
 */
@WebServlet(name = "DeleteInPatientServlet",value = "/DeleteInPatient.do")
public class DeleteInPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String strId = request.getParameter("ward_id");
		Integer ward_id = Integer.parseInt(strId);
		InpatientDaoImpl dao = new InpatientDao();
		try {
			dao.delete(ward_id);
			response.sendRedirect("FindInPatient.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}	
	}
}
