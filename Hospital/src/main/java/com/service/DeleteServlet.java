package com.service;

import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 斯洪霄
 * 实现注销管理员信息
 */
@WebServlet(name = "DeleteServlet", value = "/Delete.do")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDaoImpl dao = new AdminDao();
        if (request.getParameter("id")!=null) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            try {
                dao.deleteUser(id);
                response.sendRedirect("Logout.do");
                System.out.println("账户已注销并退出登录");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        }else {
            response.sendRedirect("Logout.do");
            System.out.println("用户未在线");
        }
    }
}
