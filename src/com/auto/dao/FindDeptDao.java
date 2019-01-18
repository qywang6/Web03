package com.auto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.auto.entity.Dept;

public class FindDeptDao {
	// 将servlet中接收到的部门编号作为条件，去数据库查询
	// 满足该条件的部门信息，并返回
	public Dept findDeptById(int deptno){
		Dept dept = null;
		try {
			String sql = "select * from dept where deptno=?";
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, deptno);
			// 该结果集中只有一条数据 
			ResultSet res = prep.executeQuery();
			// 根据表字段名获取该字段值，作为部门对象的属性添加
			if(res.next()){
				dept = new Dept();
				dept.setDeptno(res.getInt("deptno"));
				dept.setDname(res.getString("dname"));
				dept.setLoc(res.getString("loc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	}
}
