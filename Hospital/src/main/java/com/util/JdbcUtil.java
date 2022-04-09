package com.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private static BasicDataSource dataSource;

    /**
     * 读取属性文件，初始化数据库连接信息
     */
    static {
        Properties properties = new Properties();
        try {
            properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("dbconnection.properties"));
            String DRIVER = properties.getProperty("DRIVER");
            String URL = properties.getProperty("URL");
            String USERNAME = properties.getProperty("USERNAME");
            String PASSWORD = properties.getProperty("PASSWORD");
            String strInitialSize = properties.getProperty("initialSize");
            String strMaxSize = properties.getProperty("maxSize");
            String strMaxWait = properties.getProperty("maxWait");
            int initialSize = Integer.parseInt(strInitialSize);
            int maxSize = Integer.parseInt(strMaxSize);
            int maxWait = Integer.parseInt(strMaxWait);
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(DRIVER);
            dataSource.setUsername(USERNAME);
            dataSource.setUrl(URL);
            dataSource.setPassword(PASSWORD);
            dataSource.setInitialSize(initialSize);
            dataSource.setMaxWait(maxWait);
            dataSource.setMaxActive(maxSize);
        }catch (IOException e){
            //TODO handle exception
            e.printStackTrace();
        }
    }

    /**
     * 创建连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭连接
     * @param con
     */
    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
