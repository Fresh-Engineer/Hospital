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
 * 实现反馈信息修改功能
 */
@WebServlet(name = "UpdateBlogServlet", value = "/UpdateBlog.do")
public class UpdateBlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("user_name");
        String blog_content = request.getParameter("blog_content");
        String idStr = request.getParameter("father_id");
        BlogFather blogFather = new BlogFather();
        blogFather.setFather_id(Integer.parseInt(idStr));
        blogFather.setUser_name(new String(user_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        blogFather.setBlog_content(new String(blog_content.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        BlogFatherDaoImpl dao = new BlogFatherDao();
        try {
            dao.update(blogFather);
            response.sendRedirect("ShowBlog.do");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
