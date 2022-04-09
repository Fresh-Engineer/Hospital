package com.service;

import com.dao.StockDao;
import com.dao.impl.StockDaoImpl;
import com.entity.Stock;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "AddStockServlet", value = "/AddStock.do")
public class AddStockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_name = request.getParameter("m_name");
        String m_pdate = request.getParameter("m_pdate");
        String m_edate = request.getParameter("m_edate");
        String m_snumberstr = request.getParameter("m_snumber");
        Integer m_snumber = Integer.parseInt(m_snumberstr);
        String m_place = request.getParameter("m_place");

        Stock stock = new Stock();
        stock.setM_name(new String(m_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        stock.setM_pdate(Date.valueOf(m_pdate));
        stock.setM_edate(Date.valueOf(m_edate));
        stock.setM_snumber(m_snumber);
        stock.setM_place(new String(m_place.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));

        StockDaoImpl dao = new StockDao();
        request.setCharacterEncoding("UTF-8");
        try {
            dao.add(stock);
            response.sendRedirect("msfindAll.do");
        } catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
