package com.dao.impl;

import com.entity.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface DoctorDaoImpl {
    /*
     * 保存药品信息
     */
    Doctor d_save(Doctor doctor) throws SQLException;

    /*
     * 根据Cnoo排序
     */
    List<Doctor> dfindAll() throws SQLException;

    /*
     * 删除信息
     */
    void d_delete(String cnoo) throws SQLException;
}
