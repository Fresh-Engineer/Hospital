package com.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CostDao;
import com.dao.impl.CostDaoImpl;

/**
 * 删除费用
 */
@WebServlet(name = "CostDeleteServlet", value = "/costDelete.do")
public class CostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strId = request.getParameter("cost_id");
		Integer cost_id = Integer.parseInt(strId);
		CostDaoImpl dao = new CostDao();
		try {
			dao.delete(cost_id);
			response.sendRedirect("findAll.do");
		}catch(SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
