package com.dao.impl;

import com.entity.Sc;

import java.sql.SQLException;
import java.util.List;

public interface ScDaoImpl {
    /*
     * 保存药品信息
     */
    Sc s_save(Sc sc) throws SQLException;

    List<Sc> sfindAll() throws SQLException;

    /*
     * 删除信息
     */
    void s_delete(String sno) throws SQLException;
}
