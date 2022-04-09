package com.dao;

import com.dao.impl.PatientDaoImpl;
import com.entity.Patient;
import com.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 买热孜亚
 */
public class PatientDao implements PatientDaoImpl {

    /**
     * 保存新增患者
     * @throws SQLException
     */
    @Override
    public void save(Patient pat) throws SQLException {
        String sql = "INSERT INTO patient(p_id,p_name,sex,age,phone,created) VALUES(default,?,?,?,?,NOW())";
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, pat.getP_name());
            pstmt.setString(2, pat.getSex());
            pstmt.setString(3, pat.getAge());
            pstmt.setString(4, pat.getPhone());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }finally {
            JdbcUtil.close(conn);
        }
    }

    /**
     * 根据已知patient_id查询患者信息
     * @throws SQLException
     */
    @Override
    public Patient findByPatientId(Integer p_id) throws SQLException {
        String sql = "SELECT p_id,p_name,sex,age,phone,created FROM patient WHERE p_id=?";
        Patient pat = null;
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, p_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                pat = new Patient();
                pat.setP_id(rs.getInt("p_id"));
                pat.setP_name(rs.getString("p_name"));
                pat.setSex(rs.getString("sex"));
                pat.setAge(rs.getString("age"));
                pat.setPhone(rs.getString("phone"));
                pat.setCreated(rs.getTimestamp("created"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            JdbcUtil.close(conn);
        }
        return pat;
    }
    /**
     * 根据账号的创建时间排序查询
     * @throws SQLException
     */
    @Override
    public List<Patient> findAll() throws SQLException{
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT p_id,p_name,sex,age,phone,created FROM patient ORDER BY created DESC";
        Connection conn =null;
        try {
            conn = JdbcUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Patient pat=new Patient();
                pat.setP_id(rs.getInt("p_id"));
                pat.setP_name(rs.getString("p_name"));
                pat.setSex(rs.getString("sex"));
                pat.setAge(rs.getString("age"));
                pat.setPhone(rs.getString("phone"));
                pat.setCreated(rs.getTimestamp("created"));
                list.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally{
            JdbcUtil.close(conn);
        }
        return list;
    }
    /**
     * 修改患者信息
     * @throws SQLException
     */
    @Override
    public void updatePatient(Patient pat) throws SQLException {
        String sql = "UPDATE patient SET p_name=?,sex=?,age=?,phone=? WHERE p_id=?";
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pat.getP_name());
            pstmt.setString(2, pat.getSex());
            pstmt.setString(3, pat.getAge());
            pstmt.setString(4, pat.getPhone());
            pstmt.setInt(5, pat.getP_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            JdbcUtil.close(conn);
        }
    }
    /**
     * 分页查询
     * @throws SQLException
     */
    @Override
    public List<Patient> findByPage(int page, int perPage) throws SQLException{
        List<Patient> list = new ArrayList<Patient>();
        String sql = "SELECT p_id,p_name,sex,age,phone,created FROM patient LIMIT ?,?";
        Connection conn =null;
        try {
            conn = JdbcUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int begin = (page-1)*perPage;
            pstmt.setInt(1, begin);
            pstmt.setInt(2, perPage);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Patient pat=new Patient();
                pat.setP_id(rs.getInt("p_id"));
                pat.setP_name(rs.getString("p_name"));
                pat.setSex(rs.getString("sex"));
                pat.setAge(rs.getString("age"));
                pat.setPhone(rs.getString("phone"));
                pat.setCreated(rs.getTimestamp("created"));
                list.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally{
            JdbcUtil.close(conn);
        }
        return list;
    }

    @Override
    public int findMaxPage(int perPage) throws SQLException{
        int maxPage = 0;
        String sql = "SELECT COUNT(p_id) FROM patient";
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int recoreds = rs.getInt(1);
            maxPage = recoreds % perPage == 0 ? recoreds / perPage : recoreds / perPage + 1;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(conn);
        }
        return maxPage;
    }
    /*
     * 删除账号
     * @throws SQLException
     */
    @Override
    public void delete(Integer p_id) throws SQLException {
        String sql = "DELETE FROM patient WHERE p_id=?";
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, p_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            JdbcUtil.close(conn);
        }
    }
}
