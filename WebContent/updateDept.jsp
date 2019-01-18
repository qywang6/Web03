<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.auto.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	 Dept dept =(Dept) request.getAttribute("dept");
	%>
	<form action="updateDept.do">
		部门编号:<input  name="deptno" value="<%=dept.getDeptno()%>" readonly="readonly"/><br/>
		部门名称:<input name="dname"  value="<%=dept.getDname()%>" /><br/>
		部门地址:<input name="loc"   value="<%=dept.getLoc()%>"/><br/>
		<input type="submit" value="修改部门">
	</form>
</body>
</html>