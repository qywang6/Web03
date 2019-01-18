package com.auto.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.dao.FindDeptDao;
import com.auto.entity.Dept;

public class ToUpdateDeptServlet extends HttpServlet {
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		//接收页面传递的部门编号条件，
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		// 依据该条件从数据库中查询到一个部门对象
		FindDeptDao deptDao = new FindDeptDao();
		Dept dept = deptDao.findDeptById(deptno);
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("updateDept.jsp")
		.forward(request, response);
	}
}
