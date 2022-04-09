package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.DepartmentDaoImpl;
import com.entity.Department;
import com.util.JdbcUtil;

public class DepartmentDao implements DepartmentDaoImpl {
	/*
	 * 保存药品信息
	*/
	@Override
    public Department d_save(Department department) throws SQLException {
		String sql = "INSERT INTO department3(kno,kname) VALUES(?,?)";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department.getKno());
			pstmt.setString(2, department.getKname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return department;
	} 
	/*
	 * 根据Cnoo排序
	 */
	@Override
    public List<Department> kfindAll() throws SQLException{
		List<Department> list = new ArrayList<Department>();
		String sql = "SELECT kno,kname FROM department3 ORDER BY kno";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Department department = new Department();
//				department.setCnoo(rs.getNString(columnIndex));
//				department.setCnoo(rs.getString("Cnoo"));
				department.setKno(rs.getString("kno"));
//				department.setCname(Cname);
				department.setKname(rs.getString("kname"));

				list.add(department);
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
    public void k_delete(String kno) throws SQLException{
		String sql = "DELETE FROM department3 WHERE kno=?";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtil.close(conn);
		}
		
	}
}
