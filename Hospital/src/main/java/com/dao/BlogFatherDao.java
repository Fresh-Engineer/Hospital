package com.dao;

import com.dao.impl.BlogFatherDaoImpl;
import com.entity.BlogFather;
import com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 斯洪霄
 * 患者反馈信息实体类
 */
public class BlogFatherDao implements BlogFatherDaoImpl {
    BlogFather blogFather;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql;

    /**
     * 查询功能实现
     */
    @Override
    public List<BlogFather> selectAll() throws SQLException {
        List<BlogFather> list = new ArrayList<>();
        sql = "select * from blog_father";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                blogFather = new BlogFather();
                blogFather.setFather_id(resultSet.getInt("father_id"));
                blogFather.setUser_name(resultSet.getString("user_name"));
                blogFather.setBlog_content(resultSet.getString("blog_content"));
                blogFather.setDate(resultSet.getString("date"));

                list.add(blogFather);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
        return list;
    }

    /**
     * 添加功能实现
     */
    @Override
    public void insert(BlogFather blogFather) throws SQLException {
        sql = "insert into blog_father(father_id,user_name,blog_content)" +
                "values(default,?,?)";
        connection = JdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,blogFather.getUser_name());
            preparedStatement.setString(2,blogFather.getBlog_content());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    /**
     * 删除功能实现
     */
    @Override
    public void delete(int father_id) throws SQLException {
        sql = "delete from blog_father where father_id = ?";
        connection = JdbcUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,father_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            JdbcUtil.close(connection);
        }
    }

    /**
     * 修改评论功能实现
     */
    @Override
    public void update(BlogFather blogFather) throws SQLException {
        sql = "update blog_father set user_name=?, blog_content=? where father_id=?";
        connection = JdbcUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,blogFather.getUser_name());
            preparedStatement.setString(2,blogFather.getBlog_content());
            preparedStatement.setInt(3,blogFather.getFather_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    /**
     * 通过id号查询功能实现
     */
    @Override
    public List<BlogFather> selectByID(int father_id) throws SQLException {
        connection = JdbcUtil.getConnection();
        List<BlogFather>blogFatherList = new ArrayList<>();
        sql = "select * from blog_father where father_id=?";
        BlogFather blogFather = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,father_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                blogFather = new BlogFather();
                blogFather.setFather_id(resultSet.getInt("father_id"));
                blogFather.setUser_name(resultSet.getString("user_name"));
                blogFather.setBlog_content(resultSet.getString("blog_content"));
                blogFather.setDate(resultSet.getString("date"));
                blogFatherList.add(blogFather);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
        return blogFatherList;
    }
}
