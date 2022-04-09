package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegistDao;
import com.dao.impl.RegistDaoImpl;
import com.entity.Regist;

/**
 * 所有挂号查询
 */
@WebServlet(name = "FindByRegistServlet",value = "/findByRegist.do")
public class FindByRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistDaoImpl dao = new RegistDao();
		try {
			List<Regist> list = dao.findRAll();
			//请求转发
			request.setAttribute("list",list);
			request.getRequestDispatcher("guaH.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
