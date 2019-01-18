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
		// ����������������Ĳ���ʹ��utf-8
		request.setCharacterEncoding("utf-8");
		// ���͵���������Ĳ���ʹ��utf-8
		response.setContentType("text/html;charset=utf8");
		FindAllDeptDao deptDao = new FindAllDeptDao();
		int currentPage2 = 0;
		try{
			// ���ִ�в�ѯ��ȡ����currentPage����������ֿ�ָ���쳣
			// ��������Ĭ�ϲ�ѯʱ������currentPage������Ĭ�ϲ�ѯ���ǵ�һҳ
			// ��ʱ�������NullPointerException ������Ĭ�����õ�ǰҳΪ��һҳ��
			String currentPage = request.getParameter("currentPage");
			// �����ȡ��currentPageΪ�գ�����������ת����
			
			currentPage2 = Integer.parseInt(currentPage);
			
			// NullPointerException��Ϊ�˷�ֹҳ��û�д���curretPage����
			// NumberFormatException ��Ϊ�˷�ֹҳ�洫���curretPage��������������
			// �����ַ���
		}catch(NullPointerException|NumberFormatException e){
			currentPage2=1;
		}
		// ��ѯ�õ�������
		int rows = deptDao.findRows();
		//�����������Լ�ÿҳ�����ʾ��pageSize��������ҳ��
		int totalPage = 0;
		if(rows%5==0){
			totalPage =  rows/5 ;
		}else{
		    totalPage =  rows/5 +1;
		}

		
		List<Dept> depts = deptDao.findAllDepts(currentPage2);
		//�����ż��ϰ󶨵�request���������
		request.setAttribute("depts", depts);	
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", currentPage2);
		//�����ż���ͨ��requestת����deptList.jspҳ��
		request.getRequestDispatcher("deptList.jsp").forward(request, response);
	
	}
}
