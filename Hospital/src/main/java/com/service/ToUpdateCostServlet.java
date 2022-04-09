package com.service;

import com.dao.CostDao;
import com.dao.impl.CostDaoImpl;
import com.entity.Cost;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ToUpdateCostServlet", value = "/ToUpdateCost.do")
public class ToUpdateCostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cost_idstr = request.getParameter("cost_id").trim();
        Integer cost_id = Integer.parseInt(cost_idstr);
        CostDaoImpl dao = new CostDao();
        try {
            Cost cost = dao.findByCostId(cost_id);
            request.setAttribute("cost",cost);
            request.getRequestDispatcher("cost_update.jsp").forward(request,response);
        } catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
