package com.dao;

import com.dao.impl.InpatientDaoImpl;
import com.entity.Inpatient;
import com.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 买热孜亚
 */
public class InpatientDao implements InpatientDaoImpl {
    /*
     * 根据已知patient_id查询患者信息
     * @throws SQLException
     */
    @Override
    public Inpatient findByWardId(Integer ward_id) throws SQLException {
        String sql = "SELECT ward_id,p_name,bed_id,cost,indated FROM IPD WHERE ward_id=?";
        Inpatient ipd = null;
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ward_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                ipd = new Inpatient();
                ipd.setWard_id(rs.getInt("ward_id"));
                ipd.setP_name(rs.getString("p_name"));
                ipd.setBed_id(rs.getString("bed_id"));
                ipd.setCost(rs.getString("cost"));
                ipd.setIndated(rs.getTimestamp("indated"));
            }
        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        }finally {
            JdbcUtil.close(conn);
        }

        return ipd;

    }
    /*
     * 根据账号的创建时间排序查询
     * @throws SQLException
     */
    @Override
    public List<Inpatient> findAll() throws SQLException{
        List<Inpatient> list = new ArrayList<>();
        String sql = "SELECT ward_id,p_name,bed_id,cost,indated FROM IPD ORDER BY indated DESC";
        Connection conn =null;

        try {
            conn = JdbcUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Inpatient ipd=new Inpatient();
                ipd.setWard_id(rs.getInt("ward_id"));
                ipd.setP_name(rs.getString("p_name"));
                ipd.setBed_id(rs.getString("bed_id"));
                ipd.setCost(rs.getString("cost"));
                ipd.setIndated(rs.getTimestamp("indated"));
                list.add(ipd);
            }
        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        }finally{
            JdbcUtil.close(conn);
        }
        return list;
    }

    /*
     * 分页查询
     * @throws SQLException
     */
    @Override
    public List<Inpatient> findByPage(int page, int perPage) throws SQLException{
        List<Inpatient> list = new ArrayList<>();
        String sql = "SELECT ward_id,p_name,bed_id,cost,indated FROM IPD LIMIT ?,?";
        Connection conn =null;

        try {
            conn = JdbcUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int begin = (page-1)*perPage;
            pstmt.setInt(1, begin);
            pstmt.setInt(2, perPage);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Inpatient ipd=new Inpatient();
                ipd.setWard_id(rs.getInt("ward_id"));
                ipd.setP_name(rs.getString("p_name"));
                ipd.setBed_id(rs.getString("bed_id"));
                ipd.setCost(rs.getString("cost"));
                ipd.setIndated(rs.getTimestamp("indated"));
                list.add(ipd);
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
        String sql = "SELECT COUNT(ward_id) FROM IPD";
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
    public void delete(Integer ward_id) throws SQLException {
        String sql = "DELETE FROM IPD WHERE ward_id=?";
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ward_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            JdbcUtil.close(conn);
        }
    }

    /**
     * 保存新增住院患者
     * @param inpatient
     * @throws SQLException
     */
    @Override
    public void add(Inpatient inpatient) throws SQLException {
        String sql = "INSERT INTO ipd(ward_id, p_name, bed_id, cost, indated) VALUE(DEFAULT,?,?,?,NOW())";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = JdbcUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,inpatient.getP_name());
            preparedStatement.setString(2,inpatient.getBed_id());
            preparedStatement.setString(3,inpatient.getCost());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(con);
        }
    }

    /**
     * 修改住院患者信息
     * @param inpatient
     * @throws SQLException
     */
    @Override
    public void update(Inpatient inpatient) throws SQLException {
        String sql ="UPDATE ipd SET p_name=?,bed_id=?,cost=? WHERE ward_id=?";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = JdbcUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, inpatient.getP_name());
            preparedStatement.setString(2, inpatient.getBed_id());
            preparedStatement.setString(3, inpatient.getCost());
            preparedStatement.setInt(4, inpatient.getWard_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(con);
        }
    }

}
