package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.RegistDaoImpl;
import com.entity.Regist;
import com.util.JdbcUtil;

public class RegistDao implements RegistDaoImpl {

	/**
	 * 保存账号
	 * @throws SQLException 
	 * */
	@Override
	public void save(Regist regist) throws SQLException {
		String sql = "INSERT INTO regis(datetime,userName,sex,IDcard,phone,created,updated) VALUES(?,?,?,?,?,NOW(),NOW())";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1,regist.getDatetime());
			pstmt.setString(2,regist.getUserName());
			pstmt.setString(3,regist.getSex());
			pstmt.setString(4,regist.getIDcard());
			pstmt.setString(5,regist.getPhone());
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
	 * 修改
	 * @throws SQLException 
	 * */
	
	@Override
	public void updateUser(Regist regist) throws SQLException {
		String sql = "UPDATE regis SET datetime=?,userName=?,sex=?,phone=? WHERE IDcard=?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, regist.getDatetime());
			pstmt.setString(2, regist.getUserName());
			pstmt.setString(3, regist.getSex());
			pstmt.setString(4, regist.getPhone());
			pstmt.setString(5, regist.getIDcard());
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
	 * 删除账号
	 * @throws SQLException 
	 * */
	@Override
	public void delete(String IDcard) throws SQLException {
		String sql = "DELETE FROM regis WHERE IDcard=?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, IDcard);
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
	 * 根据账号的创建时间排序查询
	 * @throws SQLException
	 * */
	@Override
	public List<Regist> findRAll() throws SQLException{
		
		List<Regist> list = new ArrayList<Regist>();
		String sql = "SELECT datetime,userName,sex,IDcard,phone,created,updated FROM regis ORDER BY created DESC";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Regist regist = new Regist();
				regist.setDatetime(rs.getDate("datetime"));
				regist.setUserName(rs.getString("userName"));
				regist.setSex(rs.getString("sex"));
				regist.setIDcard(rs.getString("IDcard"));
				regist.setPhone(rs.getString("phone"));
				regist.setCreated(rs.getTimestamp("created"));
				regist.setUpdated(rs.getTimestamp("updated"));
				list.add(regist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return list;
	}

	/**
	 * 根据IDcard查询个人信息
	 * @param IDcard
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Regist findByIDcard(String IDcard) throws SQLException{
		String sql = "SELECT datetime,userName,IDcard,sex,phone FROM regis WHERE IDcard=?";
		Regist regist = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,IDcard);
			rs = pstmt.executeQuery();
			if (rs.next()){
				regist = new Regist();
				regist.setUserName(rs.getString("userName"));
				regist.setSex(rs.getString("sex"));
				regist.setPhone(rs.getString("phone"));
				regist.setDatetime(rs.getDate("datetime"));
				regist.setIDcard(rs.getString("IDcard"));
			}
		} catch (SQLException e){
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
		return regist;
	}

	/**
	 * 分页查询
	 * @throws SQLException 
	 * */
	
	@Override
	public List<Regist> findByPage(int page, int perPage) throws SQLException{
		List<Regist> list = new ArrayList<Regist>();
		String sql = "SELECT datetime,userName,sex,IDcard,phone,created,updated FROM regis LIMIT ?,?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int begin = (page-1)*perPage;
			pstmt.setInt(1, begin);
			pstmt.setInt(2, perPage);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Regist regist = new Regist();
				regist.setDatetime(rs.getDate("datetime"));
				regist.setUserName(rs.getString("userName"));
				regist.setSex(rs.getString("sex"));
				regist.setIDcard(rs.getString("IDcard"));
				regist.setPhone(rs.getString("phone"));
				regist.setCreated(rs.getTimestamp("created"));
				regist.setUpdated(rs.getTimestamp("updated"));
				list.add(regist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return list;
	}
	
	@Override
	public int findMaxPage(int perPage) throws SQLException {
		int maxPage = 0;
		String sql = "SELECT COUNT(datetime) FROM regis";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			int recoreds = rs.getInt(1);
			maxPage = recoreds%perPage == 0 ? recoreds/perPage : recoreds/perPage + 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return maxPage;
	}

}
