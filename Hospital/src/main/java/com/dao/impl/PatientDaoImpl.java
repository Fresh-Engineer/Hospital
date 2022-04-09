package com.dao.impl;

import com.entity.Patient;

import java.sql.SQLException;
import java.util.List;

public interface PatientDaoImpl {
    void save(Patient pat) throws SQLException;

    Patient findByPatientId(Integer p_id) throws SQLException;

    List<Patient> findAll() throws SQLException;

    void updatePatient(Patient pat) throws SQLException;

    List<Patient> findByPage(int page, int perPage) throws SQLException;

    int findMaxPage(int perPage) throws SQLException;

    /*
     * 删除账号
     * @throws SQLException
     */
    void delete(Integer p_id) throws SQLException;
}
