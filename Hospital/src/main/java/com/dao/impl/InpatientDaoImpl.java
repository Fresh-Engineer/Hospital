package com.dao.impl;

import com.entity.Inpatient;

import java.sql.SQLException;
import java.util.List;

public interface InpatientDaoImpl {
    /*
     * 根据已知patient_id查询患者信息
     * @throws SQLException
     */
    Inpatient findByWardId(Integer ward_id) throws SQLException;

    /*
     * 根据账号的创建时间排序查询
     * @throws SQLException
     */
    List<Inpatient> findAll() throws SQLException;

    /*
     * 分页查询
     * @throws SQLException
     */
    List<Inpatient> findByPage(int page, int perPage) throws SQLException;

    int findMaxPage(int perPage) throws SQLException;

    /*
     * 删除账号
     * @throws SQLException
     */
    void delete(Integer ward_id) throws SQLException;

    void add(Inpatient inpatient) throws SQLException;

    void update(Inpatient inpatient) throws SQLException;
}
