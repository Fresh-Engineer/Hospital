package com.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegistDao;
import com.dao.impl.RegistDaoImpl;
import com.entity.Regist;
@WebServlet(name = "RegistServlet", value = "/regist.do")
public class RegistServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收请求  获取请求参数
		String datetime = request.getParameter("datetime");
		String userName = request.getParameter("userName");
		String sex = request.getParameter("sex");
		String IDcard = request.getParameter("IDcard");
		String phone = request.getParameter("phone");
		Regist regist = new Regist();
		regist.setDatetime(Date.valueOf(datetime));
		regist.setUserName(new String(userName.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		regist.setSex(new String(sex.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		regist.setIDcard(new String(IDcard.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		regist.setPhone(new String(phone.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		request.setCharacterEncoding("UTF-8");
		//处理请求  调用dao
		RegistDaoImpl dao = new RegistDao();
		try {
			dao.save(regist);
			//响应结果
			response.sendRedirect("findByRegist.do");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}
}
