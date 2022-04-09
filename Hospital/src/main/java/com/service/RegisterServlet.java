package com.service;

import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.entity.Admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 斯洪霄
 * 实现注册功能
 */
@WebServlet(name = "RegisterServlet", value = "/Register.do")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接受请求，获取请求参数
        Admin admin = new Admin();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        admin.setUsername(username);
        admin.setPassword(password);
        //处理请求 调用Dao
        AdminDaoImpl dao = new AdminDao();
        try {
            System.out.println("账号"+username+"被存到数据库中");
            dao.addUser(admin);
            //响应结果
            response.sendRedirect("login.jsp");
        } catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}
