package com.service;

import com.dao.PatientDao;
import com.dao.impl.PatientDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 买热孜亚
 * 删除病人信息
 */
@WebServlet(name = "DeletePatientServlet", value = "/DeletePatient.do")
public class DeletePatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("p_id");
        Integer p_id = Integer.parseInt(strId);
        PatientDaoImpl dao = new PatientDao();
        try {
            dao.delete(p_id);
            response.sendRedirect("FindAllPatient.do");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}
