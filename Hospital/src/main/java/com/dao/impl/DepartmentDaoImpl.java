package com.dao.impl;

import com.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDaoImpl {
    /*
     * 保存药品信息
     */
    Department d_save(Department department) throws SQLException;

    /*
     * 根据Cnoo排序
     */
    List<Department> kfindAll() throws SQLException;

    /*
     * 删除信息
     */
    void k_delete(String kno) throws SQLException;
}
