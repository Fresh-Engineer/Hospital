package com.dao.impl;

import com.entity.Stock;

import java.sql.SQLException;
import java.util.List;

public interface StockDaoImpl {
    /*
     * 排序
     */
    List<Stock> msfindAll() throws SQLException;

    /*
     * 删除信息
     */
    void ms_delete(Integer m_sid) throws SQLException;

    /*
     * 修改库存
     */
    void updateStock(Stock stock) throws SQLException;

    void add(Stock stock) throws SQLException;

    Stock findByMSid(Integer m_sid) throws SQLException;
}
