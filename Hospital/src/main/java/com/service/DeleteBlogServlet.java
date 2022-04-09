package com.service;

import com.dao.BlogFatherDao;
import com.dao.impl.BlogFatherDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 斯洪霄
 */
@WebServlet(name = "DeleteBlogServlet", value = "/DeleteBlog.do")
public class DeleteBlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("father_id");
        if (idStr!=null&&!idStr.equals("")){
            int id = Integer.parseInt(idStr);
            BlogFatherDaoImpl dao = new BlogFatherDao();
            try {
                dao.delete(id);
                response.sendRedirect("ShowBlog.do");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        }
    }
}
