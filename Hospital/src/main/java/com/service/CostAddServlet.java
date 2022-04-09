package com.service;

import com.dao.CostDao;
import com.dao.impl.CostDaoImpl;
import com.entity.Cost;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet(name = "CostAddServlet", value = "/CostAdd.do")
public class CostAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_name = request.getParameter("p_name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String costStr = request.getParameter("cost");
        Integer cost1 = Integer.parseInt(costStr);
        String state = request.getParameter("state");
        Cost cost = new Cost();
        cost.setP_name(new String(p_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        cost.setSex(new String(sex.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        cost.setAge(new String(age.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        cost.setPhone(new String(phone.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        cost.setCost(cost1);
        cost.setState(new String(state.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        CostDaoImpl dao = new CostDao();
        request.setCharacterEncoding("utf-8");
        try {
            dao.add(cost);
            response.sendRedirect("cost.do");
        } catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }




    }
}
