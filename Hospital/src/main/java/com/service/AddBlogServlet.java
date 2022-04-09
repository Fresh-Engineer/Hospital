package com.service;

import com.dao.BlogFatherDao;
import com.dao.impl.BlogFatherDaoImpl;
import com.entity.BlogFather;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

/**
 * @author 斯洪霄
 */
@WebServlet(name = "AddBlogServlet", value = "/AddBlog.do")
public class AddBlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("user_name");
        String blog  = request.getParameter("blog");
        BlogFather blogFather = new BlogFather();
        blogFather.setUser_name(new String(user_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        blogFather.setBlog_content(new String(blog.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        BlogFatherDaoImpl blogFatherDao = new BlogFatherDao();
        try {
            blogFatherDao.insert(blogFather);
            response.sendRedirect("ShowBlog.do");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
