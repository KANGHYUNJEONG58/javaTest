<%@page import="kr.co.saramin.emaillist.vo.EmaillistVo"%>
<%@page import="kr.co.saramin.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String fn = request.getParameter("fn");
	String ln = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(fn);
	vo.setLastName(ln);
	vo.setEmail(email);
	EmaillistDao dao = new EmaillistDao();
	
	dao.insert(vo);
	
	response.sendRedirect(request.getServletContext().getContextPath());
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>성공!!!</h1>

</body>
</html>