package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.StockDaoImpl;
import com.entity.Stock;
import com.util.JdbcUtil;

public class StockDao implements StockDaoImpl {
	
	/*
	 * 排序
	 */
	@Override
	public List<Stock> msfindAll() throws SQLException{
		List<Stock> list = new ArrayList<Stock>();
		String sql = "SELECT  m_sid,m_name,m_pdate,m_edate,m_snumber,m_place FROM m_stock";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Stock stock = new Stock();
				stock.setM_sid(rs.getInt("m_sid"));
				stock.setM_name(rs.getString("m_name"));
				stock.setM_pdate(rs.getDate("m_pdate"));
				stock.setM_edate(rs.getDate("m_edate"));
				stock.setM_snumber(rs.getInt("m_snumber"));
				stock.setM_place(rs.getString("m_place"));
				list.add(stock);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtil.close(conn);
		}
		System.out.println(list);
		return list;
	}
	/*
	 * 删除信息
	 */
	@Override
	public void ms_delete(Integer m_sid) throws SQLException{
		String sql = "DELETE FROM m_stock WHERE m_sid=?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m_sid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtil.close(conn);
		}
	}
	/*
	 * 修改库存
	 */
	@Override
	public void updateStock(Stock stock)throws SQLException{
		String sql = "UPDATE m_stock SET m_name=?,m_snumber=? WHERE m_sid=?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stock.getM_name());
			pstmt.setInt(2, stock.getM_snumber());
			pstmt.setInt(3, stock.getM_sid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	@Override
	public void add(Stock stock)throws SQLException {
		String sql = "INSERT INTO m_stock(m_sid, m_name, m_pdate, m_edate, m_snumber, m_place) VALUE(DEFAULT,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = JdbcUtil.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,stock.getM_name());
			preparedStatement.setDate(2,stock.getM_pdate());
			preparedStatement.setDate(3,stock.getM_edate());
			preparedStatement.setInt(4,stock.getM_snumber());
			preparedStatement.setString(5,stock.getM_place());
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
	 * 按id查询
	 * @param m_sid
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Stock findByMSid(Integer m_sid) throws SQLException {
		String sql = "SELECT m_sid,m_name,m_pdate,m_edate,m_snumber,m_place FROM m_stock WHERE m_sid=?";
		Stock stock = null;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,m_sid);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				stock = new Stock();
				stock.setM_sid(rs.getInt("m_sid"));
				stock.setM_name(rs.getString("m_name"));
				stock.setM_pdate(rs.getDate("m_pdate"));
				stock.setM_edate(rs.getDate("m_edate"));
				stock.setM_snumber(rs.getInt("m_snumber"));
				stock.setM_place(rs.getString("m_place"));
			}
		} catch (SQLException e){
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
		return stock;
	}
}
