package com.service;

import com.dao.InpatientDao;
import com.dao.impl.InpatientDaoImpl;
import com.entity.Inpatient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * @买热孜亚
 * 查询住院患者信息
 */
@WebServlet(name = "FindInPatientServlet", value = "/FindInPatient.do")
public class FindInPatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InpatientDaoImpl dao = new InpatientDao();
        try {
            List<Inpatient> inpatientList = dao.findAll();
            //请求转发
            request.setAttribute("inpatientList", inpatientList);
            request.getRequestDispatcher("inpatient_info_list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
