package com.auto.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.dao.FindEmpDao;
import com.auto.entity.Emp;

public class ToUpdateEmpServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 接收浏览器传递中文参数使用utf-8
		request.setCharacterEncoding("utf-8");
		// 发送到浏览器中文参数使用utf-8
		response.setContentType("text/html;charset=utf8");
		//接收页面传递的员工编号
		int empno = Integer.parseInt(request.getParameter("id"));
		// 通过员工编号从数据库中查询到一个员工对象信息
		FindEmpDao  empDao = new FindEmpDao();
		Emp emp = empDao.findEmpById(empno);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("updateEmp.jsp").forward(request, response);

	}
}
