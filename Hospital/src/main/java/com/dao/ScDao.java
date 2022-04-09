package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.ScDaoImpl;
import com.entity.Sc;
import com.util.JdbcUtil;

public class ScDao implements ScDaoImpl {
	/*
	 * 保存药品信息
	*/
	@Override
	public Sc s_save(Sc sc) throws SQLException {
		String sql = "INSERT INTO sc3(sno,ssno,srade) VALUES(?,?,?)";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sc.getSno());
			pstmt.setString(2, sc.getSsno());
			pstmt.setString(3, sc.getSrade());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return sc;
	} 
	@Override
	public List<Sc> sfindAll() throws SQLException{
		List<Sc> list = new ArrayList<Sc>();
		String sql = "SELECT sno,ssno,srade FROM sc3 ORDER BY sno";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Sc sc = new Sc();
				sc.setSno(rs.getString("sno"));
				sc.setSsno(rs.getString("ssno"));
				sc.setSrade(rs.getString("srade"));
				list.add(sc);
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
	public void s_delete(String sno) throws SQLException{
		String sql = "DELETE FROM sc3 WHERE sno=?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtil.close(conn);
		}
		
	}
}
