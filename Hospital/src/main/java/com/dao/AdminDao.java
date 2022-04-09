package com.dao;

import com.dao.impl.AdminDaoImpl;
import com.entity.Admin;
import com.util.JdbcUtil;

import java.sql.*;

/**
 * @author 斯洪霄
 * 管理员实体类
 */
public class AdminDao implements AdminDaoImpl{
    String sql = null;
    Admin admin = null;
    ResultSet rs = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    Connection con = null;

    /**
     * 注册账号
     * @param admin
     */
    @Override
    public void addUser(Admin admin) throws SQLException {
        sql = "INSERT INTO admin VALUE(DEFAULT,?,?,NOW(),NOW())";
        try {
            con = JdbcUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            // TODO: handle exception
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(con);
        }
    }

    @Override
    public Admin findByUser(String username, String password) throws SQLException {
        sql = "SELECT id,username,password,created,updated FROM admin WHERE username=? AND password=?";
        try {
            con = JdbcUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            rs = preparedStatement.executeQuery();
            if (rs.next()){
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setCreated(rs.getTimestamp("created"));
                admin.setUpdated(rs.getTimestamp("updated"));
            }
        } catch (SQLException e){
            //TODO handle exception
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(con);
        }
        return admin;
    }

    /**
     * 根据id查询账号密码
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Admin findByUserId(Integer id) throws SQLException{
        sql = "SELECT id,username,password FROM admin WHERE id=?";
        try {
            con = JdbcUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            rs = preparedStatement.executeQuery();
            if (rs.next()){
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(con);
        }
        return admin;
    }

    /**
     * 注销管理员账号
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteUser(Integer id) throws SQLException {
        sql = "DELETE FROM admin WHERE id=?";
        try {
            con = JdbcUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(con);
        }
    }
}
