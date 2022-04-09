package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CostDao;
import com.dao.impl.CostDaoImpl;
import com.entity.Cost;

/**
 * 查询所有账号
 */
@WebServlet(name = "FindAllCostServlet", value = "/findAll.do")
public class FindAllCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CostDaoImpl dao = new CostDao();
		try {
			List<Cost> list = dao.findAll();
			//请求转发
			request.setAttribute("list", list);
			request.getRequestDispatcher("cost.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
	
}
