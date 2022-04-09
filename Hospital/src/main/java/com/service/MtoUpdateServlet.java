package com.service;

import com.dao.MedicineDao;
import com.dao.impl.MedicineDaoImpl;
import com.entity.Medicine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MtoUpdateServlet", value = "/MtoUpdate.do")
public class MtoUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_idstr = request.getParameter("m_id").trim();
        Integer m_id = Integer.parseInt(m_idstr);
        MedicineDaoImpl dao = new MedicineDao();
        try {
            Medicine medicine = dao.m_findById(m_id);
            request.setAttribute("medicine",medicine);
            request.getRequestDispatcher("medicine_update.jsp").forward(request,response);
        } catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
