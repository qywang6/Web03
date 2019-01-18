package com.auto.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.dao.FindAllEmpDao;
import com.auto.entity.Emp;

public class FindAllEmpServlet  extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 接收浏览器传递中文参数使用utf-8
		request.setCharacterEncoding("utf-8");
		// 发送到浏览器中文参数使用utf-8
		response.setContentType("text/html;charset=utf8");
		// 通过FindAllEmpDao 查询返回一个员工对象的集合
		FindAllEmpDao findAllEmp = new FindAllEmpDao();
		
		List<Emp> emps = findAllEmp.findAll();
		// 将emps集合通过request绑定
		request.setAttribute("emps", emps);
		//将 集合转发到员工查询页面
		request.getRequestDispatcher("empList.jsp").forward(request, response);
	}
}
