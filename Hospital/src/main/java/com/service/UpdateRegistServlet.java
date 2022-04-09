package com.service;

import com.dao.RegistDao;
import com.dao.impl.RegistDaoImpl;
import com.entity.Regist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateRegistServlet", value = "/UpdateRegist.do")
public class UpdateRegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        RegistDaoImpl dao = new RegistDao();
        try {
            dao.updateUser(regist);
            response.sendRedirect("findByRegist.do");
        } catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}
