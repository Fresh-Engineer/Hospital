package com.dao.impl;

import com.entity.Medicine;

import java.sql.SQLException;
import java.util.List;

public interface MedicineDaoImpl {
    void m_save(Medicine medicine) throws SQLException;

    List<Medicine> mfindAll() throws SQLException;

    void m_delete(Integer m_id) throws SQLException;

    Medicine m_findById(Integer m_id) throws SQLException;

    void update(Medicine medicine) throws SQLException;
}
