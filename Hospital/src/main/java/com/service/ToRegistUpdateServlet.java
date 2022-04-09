package com.service;

import com.dao.RegistDao;
import com.dao.impl.RegistDaoImpl;
import com.entity.Regist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ToRegistUpdateServlet", value = "/ToRegistUpdate.do")
public class ToRegistUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String IDcard = request.getParameter("IDcard").trim();
        RegistDaoImpl dao = new RegistDao();
        try {
            Regist regist = dao.findByIDcard(IDcard);
            request.setAttribute("regist",regist);
            request.getRequestDispatcher("RegistUpdate.jsp").forward(request,response);
        } catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}
