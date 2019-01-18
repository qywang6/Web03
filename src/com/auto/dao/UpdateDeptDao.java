package com.auto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.auto.entity.Dept;

public class UpdateDeptDao {
	public void updateDept(Dept dept){
		
		try {
			String sql = "update dept set dname=?,loc=? where deptno=?";
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep  = conn.prepareStatement(sql);
			prep.setString(1, dept.getDname());
			prep.setString(2, dept.getLoc());
			prep.setInt(3, dept.getDeptno());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
