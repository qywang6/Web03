package com.auto.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.dao.UpdateDeptDao;
import com.auto.entity.Dept;

public class UpdateDeptServlet extends HttpServlet {
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		UpdateDeptDao  updateDao = new UpdateDeptDao();
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		dept.setDname(dname);
		dept.setLoc(loc);
		updateDao.updateDept(dept);
		response.sendRedirect("findAllDept.do");
	}
}
