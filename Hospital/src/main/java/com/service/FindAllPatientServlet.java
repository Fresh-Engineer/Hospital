package com.service;

import com.dao.PatientDao;
import com.dao.impl.PatientDaoImpl;
import com.entity.Patient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 买热孜亚
 * 查询所有病人的信息
 */
@WebServlet(name = "FindAllPatientServlet", value = "/FindAllPatient.do")
public class FindAllPatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientDaoImpl dao = new PatientDao();
        try {
            List<Patient> patientList = dao.findAll();
            //请求转发
            request.setAttribute("patientList", patientList);
            request.getRequestDispatcher("patient_list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
