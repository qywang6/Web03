package com.auto.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.dao.FindAllDeptDao;
import com.auto.entity.Dept;

public class FindAllDeptServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 接收浏览器传递中文参数使用utf-8
		request.setCharacterEncoding("utf-8");
		// 发送到浏览器中文参数使用utf-8
		response.setContentType("text/html;charset=utf8");
		FindAllDeptDao deptDao = new FindAllDeptDao();
		int currentPage2 = 0;
		try{
			// 如果执行查询获取不到currentPage参数，会出现空指针异常
			// 但是我们默认查询时，不带currentPage参数，默认查询的是第一页
			// 此时如果出现NullPointerException ，我们默认设置当前页为第一页。
			String currentPage = request.getParameter("currentPage");
			// 如果获取的currentPage为空，不进行整数转换。
			
			currentPage2 = Integer.parseInt(currentPage);
			
			// NullPointerException是为了防止页面没有传入curretPage参数
			// NumberFormatException 是为了防止页面传入的curretPage参数不是正常的
			// 数字字符串
		}catch(NullPointerException|NumberFormatException e){
			currentPage2=1;
		}
		// 查询得到总行数
		int rows = deptDao.findRows();
		//根据总行数以及每页最大显示数pageSize，计算总页数
		int totalPage = 0;
		if(rows%5==0){
			totalPage =  rows/5 ;
		}else{
		    totalPage =  rows/5 +1;
		}

		
		List<Dept> depts = deptDao.findAllDepts(currentPage2);
		//将部门集合绑定到request请求对象中
		request.setAttribute("depts", depts);	
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", currentPage2);
		//将部门集合通过request转发到deptList.jsp页面
		request.getRequestDispatcher("deptList.jsp").forward(request, response);
	
	}
}
