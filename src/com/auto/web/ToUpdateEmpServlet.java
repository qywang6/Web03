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
		// ����������������Ĳ���ʹ��utf-8
		request.setCharacterEncoding("utf-8");
		// ���͵���������Ĳ���ʹ��utf-8
		response.setContentType("text/html;charset=utf8");
		//����ҳ�洫�ݵ�Ա�����
		int empno = Integer.parseInt(request.getParameter("id"));
		// ͨ��Ա����Ŵ����ݿ��в�ѯ��һ��Ա��������Ϣ
		FindEmpDao  empDao = new FindEmpDao();
		Emp emp = empDao.findEmpById(empno);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("updateEmp.jsp").forward(request, response);

	}
}
