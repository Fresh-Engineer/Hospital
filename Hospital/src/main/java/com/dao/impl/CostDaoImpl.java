package com.dao.impl;

import com.entity.Cost;

import java.sql.SQLException;
import java.util.List;

public interface CostDaoImpl {
    void add(Cost cost) throws SQLException;

    void update(Cost cost) throws SQLException;

    Cost findByCostId(Integer cost_id) throws SQLException;

    void delete(Integer cost_id) throws SQLException;

    List<Cost> findAll() throws SQLException;

    List<Cost> findByPage(int page, int perPage) throws SQLException;

    int findMaxPage(int perPage) throws SQLException;
}
