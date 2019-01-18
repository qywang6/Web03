<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addEmp.do" method="post">
		员工编号:<input name="empno" /><br/>
		员工姓名:<input name="ename" /><br/>
		员工职位:<input name="job" /><br/>
		直属领导:<input name="mgr" /><br/>
		入职时间:<input name="hiredate" /><br/>
		员工工资:<input name="sal" /><br/>
		员工奖金:<input name="comm" /><br/>
		员工部门:<input name="deptno" /><br/>
		<input  type="submit" value="提交" />
	</form>
</body>
</html>