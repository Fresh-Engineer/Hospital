package com.dao.impl;

import com.entity.BlogFather;

import java.sql.SQLException;
import java.util.List;

public interface BlogFatherDaoImpl {
    List<BlogFather> selectAll() throws SQLException;
    List<BlogFather> selectByID(int father_id) throws SQLException;
    void insert(BlogFather blogFather) throws SQLException;
    void delete(int father_id) throws SQLException;
    void update(BlogFather blogFather) throws SQLException;
}
