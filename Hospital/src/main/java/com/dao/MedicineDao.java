package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.MedicineDaoImpl;
import com.entity.Medicine;
import com.util.JdbcUtil;

public class MedicineDao implements MedicineDaoImpl {
	/**
	 * 保存药品信息
	 * @param medicine
	 * @throws SQLException
	 */
	@Override
    public void m_save(Medicine medicine) throws SQLException {
		String sql = "INSERT INTO m_medicine(m_id,m_name,m_type,m_brand,m_price,m_specification) VALUE(DEFAULT,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, medicine.getM_name());
			pstmt.setString(2, medicine.getM_type());
			pstmt.setString(3, medicine.getM_brand());
			pstmt.setInt(4, medicine.getM_price());
			pstmt.setString(5, medicine.getM_specification());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}

	/**
	 * 根据m_id排序
	 * @return
	 * @throws SQLException
	 */
	@Override
    public List<Medicine> mfindAll() throws SQLException{
		List<Medicine> list = new ArrayList<>();
		String sql = "SELECT m_id,m_name,m_type,m_brand,m_price,m_specification FROM m_medicine ORDER BY m_id";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Medicine medicine = new Medicine();
				medicine.setM_id(rs.getInt("m_id"));
				medicine.setM_name(rs.getString("m_name"));
				medicine.setM_type(rs.getString("m_type"));
				medicine.setM_brand(rs.getString("m_brand"));
				medicine.setM_price(rs.getInt("m_price"));
				medicine.setM_specification(rs.getString("m_specification"));
				list.add(medicine);
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


	/**
	 * 删除信息
	 * @param m_id
	 * @throws SQLException
	 */
	@Override
    public void m_delete(Integer m_id) throws SQLException{
		String sql = "DELETE FROM m_medicine WHERE m_id=?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtil.close(conn);
		}
		
	}

	/**
	 * 根据药品号查询药品信息
	 * @param m_id
	 * @return
	 * @throws SQLException
	 */
	@Override
    public Medicine m_findById(Integer m_id) throws SQLException{
		String sql = "SELECT m_id,m_name,m_type,m_brand,m_price,m_specification FROM m_medicine WHERE m_id=?";
		Connection con = null;
		Medicine medicine = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,m_id);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				medicine = new Medicine();
				medicine.setM_id(rs.getInt("m_id"));
				medicine.setM_name(rs.getString("m_name"));
				medicine.setM_type(rs.getString("m_type"));
				medicine.setM_brand(rs.getString("m_brand"));
				medicine.setM_price(rs.getInt("m_price"));
				medicine.setM_specification(rs.getString("m_specification"));
			}
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
		return medicine;
	}

	/**
	 * 修改药品信息
	 * @param medicine
	 * @throws SQLException
	 */
	@Override
    public void update(Medicine medicine) throws SQLException {
		String sql="UPDATE m_medicine SET m_name=?,m_type=?,m_brand=?,m_price=?,m_specification=? WHERE m_id=?";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, medicine.getM_name());
			preparedStatement.setString(2, medicine.getM_type());
			preparedStatement.setString(3, medicine.getM_brand());
			preparedStatement.setInt(4,medicine.getM_price());
			preparedStatement.setString(5,medicine.getM_specification());
			preparedStatement.setInt(6,medicine.getM_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
	}
}
