package com.service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 实现管理员退出登录
 * @author 斯洪霄
 */
@WebServlet(name = "LogoutServlet", value = "/Logout.do")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        response.sendRedirect("login.jsp");
        System.out.println("用户"+session.getId()+"已下线");
    }
}
