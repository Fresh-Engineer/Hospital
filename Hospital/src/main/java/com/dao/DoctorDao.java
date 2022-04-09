package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.DoctorDaoImpl;
import com.entity.Doctor;
import com.util.JdbcUtil;

public class DoctorDao implements DoctorDaoImpl {
	/*
	 * 保存药品信息
	*/
	@Override
    public Doctor d_save(Doctor doctor) throws SQLException {
		String sql = "INSERT INTO course2(cnoo,cname,cteacher,ccredit) VALUES(?,?,?,?)";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, doctor.getCnoo());
			pstmt.setString(2, doctor.getCname());
			pstmt.setString(3, doctor.getCteacher());
			pstmt.setString(4, doctor.getCcredit());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return doctor;
	} 
	/*
	 * 根据Cnoo排序
	 */
	@Override
    public List<Doctor> dfindAll() throws SQLException{
		List<Doctor> list = new ArrayList<Doctor>();
		String sql = "SELECT cnoo,cname,cteacher,ccredit FROM course2 ORDER BY cnoo";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Doctor doctor = new Doctor();
//				doctor.setCnoo(rs.getNString(columnIndex));
//				doctor.setCnoo(rs.getString("Cnoo"));
				doctor.setCnoo(rs.getString("cnoo"));
//				doctor.setCname(Cname);
				doctor.setCname(rs.getString("cname"));
//				doctor.setCteacher(Cteacher);
				doctor.setCteacher(rs.getString("cteacher"));
				doctor.setCcredit(rs.getString("ccredit"));
				list.add(doctor);
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
    public void d_delete(String cnoo) throws SQLException{
		String sql = "DELETE FROM course2 WHERE cnoo=?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cnoo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtil.close(conn);
		}
		
	}
}
