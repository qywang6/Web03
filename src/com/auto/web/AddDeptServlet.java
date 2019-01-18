package com.auto.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.dao.AddDeptDao;
import com.auto.entity.Dept;

public class AddDeptServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		// 接收浏览器传递中文参数使用utf-8
		request.setCharacterEncoding("utf-8");
		// 发送到浏览器中文参数使用utf-8
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		// 创建AddDeptDao对象，调用其addDept方法。将从addDept.jsp页面中
		// 传入的部门信息插入到数据库中
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		dept.setDname(dname);
		dept.setLoc(loc);
		AddDeptDao addDeptDao = new AddDeptDao();
		addDeptDao.addDept(dept);
		
//		out.println("添加员工成功");
		response.sendRedirect("findAllDept.do");
	}
}
