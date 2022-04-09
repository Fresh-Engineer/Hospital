package com.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PatientDao;
import com.dao.impl.PatientDaoImpl;
import com.entity.Patient;

/**
 *新增患者
 */
@WebServlet(name = "AddServlet",value = "/add.do")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受请求 获取请求参数
		String p_name = request.getParameter("p_name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");		
		Patient pat = new Patient();
		pat.setP_name(new String(p_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		pat.setSex(new String(sex.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		pat.setAge(new String(age.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		pat.setPhone(new String(phone.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
		request.setCharacterEncoding("UTF-8");
		//处理请求 调用dao
		PatientDaoImpl dao = new PatientDao();
		try {
			dao.save(pat);
			// 响应结果
			response.sendRedirect("FindAllPatient.do");
		} catch (SQLException e) {		
			e.printStackTrace();
			response.sendRedirect("error.html");
		}		
	}

}
