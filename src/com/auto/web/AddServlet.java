package com.auto.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		String username =  request.getParameter("username");
		double sal =Double.parseDouble(request.getParameter("salary")) ;
		String address = request.getParameter("address");
		String job = request.getParameter("job");
		PrintWriter out = response.getWriter();
		out.println(username+"的职业是"+job+
				",他住在"+address+",目前的工资是"+sal);
	}
}
