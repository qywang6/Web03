package com.auto.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.dao.AddEmpDao;
import com.auto.entity.Emp;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class AddEmpServlet extends HttpServlet {
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		// 接收浏览器传递中文参数使用utf-8
		request.setCharacterEncoding("utf-8");
		// 发送到浏览器中文参数使用utf-8
		response.setContentType("text/html;charset=utf8");
		//接收表单提交的请求参数
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = 0;
		//如果从页面获取的直属领导编号不为空，则可以进行强制转换
		if(!request.getParameter("mgr").equals("")){
			 mgr = Integer.parseInt(request.getParameter("mgr"));
		}
		
		String hiredate = request.getParameter("hiredate");
		double sal = Double.parseDouble(request.getParameter("sal"));
		double comm = Double.parseDouble(request.getParameter("comm"));
		int deptno  =Integer.parseInt( request.getParameter("deptno"));
		Emp emp = new Emp();
		emp.setCommon(comm);
		emp.setDeptno(deptno);
		emp.setEmpno(empno);
		emp.setEname(ename);
		// 因为员工对象中hiredate属性是一个Date(日期)类型数据，而我们从表单
		// 接收的hiredate是一个字符串，我们要将该字符串设置给Emp对象的日期
		// 属性，需要将字符串转换为Date类型数据 
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		Date hdate;
		try {
			hdate = sdf.parse(hiredate);
			emp.setHiredate(hdate);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emp.setJob(job);
		emp.setMgr(mgr);
		emp.setSal(sal);
		AddEmpDao empDao = new AddEmpDao();
		empDao.addEmp(emp);
		PrintWriter out = response.getWriter();
		// 重定向 ：重新发送一次请求 ，在增加完员工之后，可以再执行一次查询，
		// 将所有的员工查询出来
		response.sendRedirect("findAllEmp.do");
		
	}
}
