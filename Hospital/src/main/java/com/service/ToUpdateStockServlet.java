package com.service;

import com.dao.StockDao;
import com.dao.impl.StockDaoImpl;
import com.entity.Stock;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ToUpdateStockServlet", value = "/ToUpdateStock.do")
public class ToUpdateStockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_sidstr = request.getParameter("m_sid");
        Integer m_sid = Integer.parseInt(m_sidstr);
        StockDaoImpl dao = new StockDao();
        try {
            Stock stock = dao.findByMSid(m_sid);
            request.setAttribute("stock",stock);
            request.getRequestDispatcher("stock_update.jsp").forward(request,response);
        } catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
