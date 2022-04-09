package com.dao.impl;

import com.entity.Regist;

import java.sql.SQLException;
import java.util.List;

public interface RegistDaoImpl {
    void save(Regist regist) throws SQLException;

    void updateUser(Regist regist) throws SQLException;

    void delete(String IDcard) throws SQLException;

    List<Regist> findRAll() throws SQLException;

    Regist findByIDcard(String IDcard) throws SQLException;

    List<Regist> findByPage(int page, int perPage) throws SQLException;

    int findMaxPage(int perPage) throws SQLException;
}
