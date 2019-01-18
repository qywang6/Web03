package com.auto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDeptDao {
	public void deleteDept(int deptno){
		
		try {
			String sql = "delete from dept  where deptno=?";
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, deptno);
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
