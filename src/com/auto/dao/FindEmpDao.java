package com.auto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.auto.entity.Emp;

public class FindEmpDao {
	// �÷����ܹ�����Ա����������������ݿ��в�ѯ��һ��Ա����Ϣ
	// ��װ����Ϊһ��Ա��������Ϣ
	public Emp  findEmpById(int empno){
		Emp  emp = null;
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from emp where empno = ?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, empno);
			// �ý�����Ǹ���Ա����ŷ��ص�һ��Ա����Ϣ
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
