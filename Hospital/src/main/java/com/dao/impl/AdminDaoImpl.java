package com.dao.impl;

import com.entity.Admin;

import java.sql.SQLException;

public interface AdminDaoImpl {
    void addUser(Admin admin) throws SQLException;

    Admin findByUser(String username, String password) throws SQLException;

    Admin findByUserId(Integer id) throws SQLException;

    void deleteUser(Integer id) throws SQLException;
}
