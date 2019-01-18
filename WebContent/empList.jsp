<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,com.auto.entity.Emp "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1px" cellpadding="0px" cellspacing="0px" style="text-align: center;">
		<tr>
			<td>员工编号	</td>
			<td>员工姓名</td>
			<td>员工职位	</td>
			<td>直属领导</td>
			<td>入职时间</td>
			<td>员工工资</td>
			<td>员工奖金</td>
			<td>部门编号</td>
			<td>操作</td>
		</tr>
		<%
			List<Emp> emps = (List<Emp>)request.getAttribute("emps");
		   for(int i=0;i<emps.size();i++){
			   // 循环一次获得 一个emp对象
			    Emp e = emps.get(i);
		%>	   
		
		<tr>
			<td><%=e.getEmpno() %></td>
			<td><%=e.getEname() %></td>
			<td><%=e.getJob() %>	</td>
			<td><%=e.getMgr() %></td>
			<td><%=e.getHiredate() %></td>
			<td><%=e.getSal() %></td>
			<td><%=e.getCommon() %></td>
			<td><%=e.getDeptno() %></td>
			<td><a href="toUpdateEmp.do?id=<%=e.getEmpno() %>">修改</a></td>
		</tr>
		<% 
		   }
			%>
	</table>
	
	<a  href="addEmp.jsp">增加</a>
</body>
</html>