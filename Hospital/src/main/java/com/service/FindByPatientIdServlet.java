package com.service;

import com.dao.PatientDao;
import com.dao.impl.PatientDaoImpl;
import com.entity.Patient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 根据病人编号查询信息
 * @author 买热孜亚
 */
@WebServlet(name = "FindByPatientIdServlet", value = "/FindByPatientId.do")
public class FindByPatientIdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("p_id");
        Integer p_id = Integer.parseInt(strId);
        PatientDaoImpl dao = new PatientDao();
        try {
            Patient pat = dao.findByPatientId(p_id);
            request.setAttribute("pat", pat);
            request.getRequestDispatcher("patient_update.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
