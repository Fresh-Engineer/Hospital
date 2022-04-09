package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.CostDaoImpl;
import com.entity.Cost;
import com.util.JdbcUtil;


public class CostDao implements CostDaoImpl {

	/**
	 * 添加费用信息
	 * @param cost
	 * @throws SQLException
	 */
	@Override
	public void add(Cost cost) throws SQLException {
		String sql = "INSERT INTO cost(cost_id, p_name, sex, age, phone, cost, state, created) VALUE (DEFAULT,?,?,?,?,?,?,NOW())";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = JdbcUtil.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, cost.getP_name());
			preparedStatement.setString(2, cost.getSex());
			preparedStatement.setString(3, cost.getAge());
			preparedStatement.setString(4, cost.getPhone());
			preparedStatement.setInt(5,cost.getCost());
			preparedStatement.setString(6, cost.getState());
			preparedStatement.executeUpdate();
		} catch (SQLException e){
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
	}

	/**
	 * 修改费用信息
	 * @param cost
	 * @throws SQLException
	 */
	@Override
	public void update(Cost cost) throws SQLException {
		String sql = "UPDATE cost SET p_name=?,sex=?,age=?,phone=?,cost=?,state=? WHERE cost_id=?";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, cost.getP_name());
			preparedStatement.setString(2, cost.getSex());
			preparedStatement.setString(3, cost.getAge());
			preparedStatement.setString(4, cost.getPhone());
			preparedStatement.setInt(5,cost.getCost());
			preparedStatement.setString(6,cost.getState());
			preparedStatement.setInt(7,cost.getCost_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
	}

	/**
	 * 根据ID查询账号
	 * @throws SQLException
	 * */
	@Override
	public Cost findByCostId(Integer cost_id) throws SQLException {
		String sql = "SELECT cost_id,p_name,sex,age,phone,cost,state,created FROM cost WHERE cost_id=?";
		Cost cost = null;
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cost_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				cost = new Cost();
				cost.setCost_id(rs.getInt("cost_id"));
				cost.setP_name(rs.getString("p_name"));
				cost.setSex(rs.getString("sex"));
				cost.setAge(rs.getString("age"));
				cost.setPhone(rs.getString("phone"));
				cost.setCost(rs.getInt("cost"));
				cost.setState(rs.getString("state"));
				cost.setCreated(rs.getTimestamp("created"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return cost;
	}

	/**
	 * 删除账号
	 * @throws SQLException
	 * */
	@Override
	public void delete(Integer cost_id) throws SQLException {
		String sql = "DELETE FROM cost WHERE cost_id=?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cost_id);
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
	public List<Cost> findAll() throws SQLException{

		List<Cost> list = new ArrayList<Cost>();
		String sql = "SELECT cost_id,p_name,sex,age,phone,cost,state,created FROM cost ORDER BY created DESC";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Cost cost = new Cost();
				cost.setCost_id(rs.getInt("cost_id"));
				cost.setP_name(rs.getString("p_name"));
				cost.setSex(rs.getString("sex"));
				cost.setAge(rs.getString("age"));
				cost.setPhone(rs.getString("phone"));
				cost.setCost(rs.getInt("cost"));
				cost.setState(rs.getString("state"));
				cost.setCreated(rs.getTimestamp("created"));
				list.add(cost);
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
	 * 分页查询
	 * @throws SQLException
	 * */

	@Override
	public List<Cost> findByPage(int page, int perPage) throws SQLException{
		List<Cost> list = new ArrayList<Cost>();
		String sql = "SELECT cost_id,p_name,sex,age,phone,cost,state,created FROM cost LIMIT ?,?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int begin = (page-1)*perPage;
			pstmt.setInt(1, begin);
			pstmt.setInt(2, perPage);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Cost cost = new Cost();
				cost.setCost_id(rs.getInt("cost_id"));
				cost.setP_name(rs.getString("p_name"));
				cost.setSex(rs.getString("sex"));
				cost.setAge(rs.getString("age"));
				cost.setPhone(rs.getString("phone"));
				cost.setCost(rs.getInt("cost"));
				cost.setState(rs.getString("state"));
				cost.setCreated(rs.getTimestamp("created"));

				list.add(cost);
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
		String sql = "SELECT COUNT(cost_id) FROM cost";
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
