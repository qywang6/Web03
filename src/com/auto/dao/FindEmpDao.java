package com.auto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.auto.entity.Emp;

public class FindEmpDao {
	// 该方法能够根据员工编号条件，从数据库中查询到一条员工信息
	// 封装返回为一个员工对象信息
	public Emp  findEmpById(int empno){
		Emp  emp = null;
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from emp where empno = ?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, empno);
			// 该结果集是根据员工编号返回的一行员工信息
			ResultSet res = prep.executeQuery();
			if(res.next()){
				 emp = new Emp();
				 emp.setCommon(res.getDouble("comm"));
				 emp.setDeptno(res.getInt("deptno"));
				 emp.setEmpno(res.getInt("empno"));
				 emp.setEname(res.getString("ename"));
				 emp.setHiredate(res.getDate("hiredate"));
				 emp.setJob(res.getString("job"));
				 emp.setMgr(res.getInt("mgr"));
				 emp.setSal(res.getDouble("sal"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
   
}
