package com.service;

import com.dao.MedicineDao;
import com.dao.impl.MedicineDaoImpl;
import com.entity.Medicine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet(name = "UpdateMedicineServlet", value = "/UpdateMedicine.do")
public class UpdateMedicineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_idstr = request.getParameter("m_id");
        Integer m_id = Integer.parseInt(m_idstr);
        String m_name = request.getParameter("m_name");
        String m_type = request.getParameter("m_type");
        String m_brand = request.getParameter("m_brand");
        String m_pricestr = request.getParameter("m_price");
        Integer m_price = Integer.parseInt(m_pricestr);
        String m_specification = request.getParameter("m_specification");
        Medicine medicine = new Medicine();
        medicine.setM_id(m_id);
        medicine.setM_name(new String(m_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        medicine.setM_type(new String(m_type.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        medicine.setM_brand(new String(m_brand.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        medicine.setM_price(m_price);
        medicine.setM_specification(new String(m_specification.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        request.setCharacterEncoding("UTF-8");

        MedicineDaoImpl dao = new MedicineDao();
        try {
            dao.update(medicine);
            response.sendRedirect("mfindAll.do");
        } catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
