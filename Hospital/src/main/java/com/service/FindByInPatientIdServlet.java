package com.service;

import com.dao.InpatientDao;
import com.dao.impl.InpatientDaoImpl;
import com.entity.Inpatient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FindByInPatientIdServlet", value = "/FindByInPatientId.do")
public class FindByInPatientIdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ward_idstr = request.getParameter("ward_id");
        Integer ward_id = Integer.parseInt(ward_idstr);
        InpatientDaoImpl dao = new InpatientDao();
        try {
            Inpatient inpatient = dao.findByWardId(ward_id);
            request.setAttribute("inpatient",inpatient);
            request.getRequestDispatcher("inpatient_update.jsp").forward(request,response);
        } catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
