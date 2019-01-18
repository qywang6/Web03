package com.auto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auto.entity.Emp;

public class FindAllEmpDao {
   public List<Emp> findAll(){
	  List<Emp> emps = new ArrayList<Emp>();
	   try {
		   String sql = "select * from emp";
		   Connection conn = DBUtil.getConnection();
		   PreparedStatement prep = conn.prepareStatement(sql);
		   // 查询需要返回一个员工的结果集
		   ResultSet res = prep.executeQuery();
		   while(res.next()){
			   Emp emp = new Emp();
			   emp.setCommon(res.getDouble("comm"));
			   emp.setDeptno(res.getInt("deptno"));
			   emp.setEmpno(res.getInt("empno"));
			   emp.setEname(res.getString("ename"));
			   emp.setHiredate(res.getDate("hiredate"));
			   emp.setJob(res.getString("job"));
			   emp.setMgr(res.getInt("mgr"));
			   emp.setSal(res.getDouble("sal"));
			   emps.add(emp);
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return emps;
   }
}
