<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	 <form action="Controller" method="post"> 
		<input type="hidden" name="command" value="add_new_subject" /> New Subject:<br />
		<input type="text" name="subject" value="" /><br /> 
		<input type="submit" value="sign in" />
	 </form> 

<br/>
	<a href="${pageContext.request.contextPath}/">Main page</a>
</body>
</html>