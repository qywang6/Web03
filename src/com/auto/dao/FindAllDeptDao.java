package com.auto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auto.entity.Dept;


public class FindAllDeptDao {
	public List<Dept> findAllDept(){
		List<Dept> depts = new ArrayList<Dept>();
		try {
			String sql = "select * from dept";
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			ResultSet res = prep.executeQuery();
			while(res.next()){
				Dept dept = new Dept();
				dept.setDeptno(res.getInt("deptno"));
				dept.setDname(res.getString("dname"));
				dept.setLoc(res.getString("loc"));
				depts.add(dept);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return depts;
		
	}
	
	public List<Dept> findAllDepts(int currentPage){
		List<Dept> depts = new ArrayList<Dept>();
		try {
			String sql = "select * from dept limit ?,5";
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			int begin=0;
			begin = (currentPage-1)*5;
			prep.setInt(1, begin);
			ResultSet res = prep.executeQuery();
			while(res.next()){
				Dept dept = new Dept();
				dept.setDeptno(res.getInt(1));
				dept.setDname(res.getString(2));
				dept.setLoc(res.getString(3));
				depts.add(dept);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return depts;
	}
	
	//统计总记录数
	public int findRows(){
		int rows = 0;
		try {
			String sql = "select count(*) from dept";
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			ResultSet res = prep.executeQuery();
			if(res.next()){
				rows = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
		
}
