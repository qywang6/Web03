package com.auto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.auto.entity.Dept;


public class AddDeptDao {
	public void addDept(Dept dept){
		
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "insert into dept  values(?,?,?)";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, dept.getDeptno());
			prep.setString(2, dept.getDname());
			prep.setString(3, dept.getLoc());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
