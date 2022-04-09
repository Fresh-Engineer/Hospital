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
 */
@WebServlet(name = "ShowUpdateServlet", value = "/ShowUpdate.do")
public class ShowUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("father_id");
        if (idStr!=null&&!idStr.equals("")) {
            int id = Integer.parseInt(idStr);
            BlogFatherDaoImpl dao = new BlogFatherDao();
            List<BlogFather> blogFather = null;
            try {
                blogFather = dao.selectByID(id);
                request.setAttribute("blogFather",blogFather);
                request.getRequestDispatcher("blog_update.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        }
    }
}
