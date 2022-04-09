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
@WebServlet(name = "FindByCostPageServlet", value = "/findByCostPage.do")
public class FindByCostPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("page");
		int page = 1;
		if(str!=null) {
			page = Integer.parseInt(str);
		}
		CostDaoImpl dao = new CostDao();
		try {
			List<Cost> list = dao.findByPage(page, 10);
			int maxPage = dao.findMaxPage(10);
			// 请求转发
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.setAttribute("maxPage", maxPage);
			
			request.getRequestDispatcher("cost.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
