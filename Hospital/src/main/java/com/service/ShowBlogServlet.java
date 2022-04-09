package com.service;

import com.dao.BlogFatherDao;
import com.dao.impl.BlogFatherDaoImpl;
import com.entity.BlogFather;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 斯洪霄
 * 实现展示反馈信息功能
 */
@WebServlet(name = "ShowBlogServlet", value = "/ShowBlog.do")
public class ShowBlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BlogFatherDaoImpl dao = new BlogFatherDao();
        try {
            List<BlogFather> list = dao.selectAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("blog.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
