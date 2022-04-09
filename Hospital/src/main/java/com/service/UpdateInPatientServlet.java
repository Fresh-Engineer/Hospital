package com.service;

import com.dao.InpatientDao;
import com.dao.impl.InpatientDaoImpl;
import com.entity.Inpatient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet(name = "UpdateInPatientServlet", value = "/UpdateInPatient.do")
public class UpdateInPatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ward_idstr = request.getParameter("ward_id");
        Integer ward_id = Integer.parseInt(ward_idstr);
        String p_name = request.getParameter("p_name");
        String bed_id = request.getParameter("bed_id");
        String cost = request.getParameter("cost");

        Inpatient inpatient = new Inpatient();

        inpatient.setWard_id(ward_id);
        inpatient.setP_name(new String(p_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        inpatient.setBed_id(new String(bed_id.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        inpatient.setCost(new String(cost.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        InpatientDaoImpl dao = new InpatientDao();
        try {
            dao.update(inpatient);
            response.sendRedirect("FindInPatient.do");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
