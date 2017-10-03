<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Main page</title>
<script type="text/javascript" src="WEB-INF/js/main.js"></script>
</head>
<body>

<%-- 	<a href="${pageContext.request.contextPath}/all_students">Show all students</a> --%>
	<a href="${pageContext.request.contextPath}/all_subjects">Show all
		subjects</a>
	<a href="${pageContext.request.contextPath}/all">Show all</a>


	<button onclick="allStudents()">Show all students</button>
	
	<p id="all_students"></p>
 	<!-- <script>
		function allStudents() {
			var xhr = new XMLHttpRequest();
			var txt = "";
			xhr.open('GET', 'http://localhost:8080/HomeProject/all_students',
					true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var stringStud = xhr.responseText;
						var students = JSON.parse(stringStud);

						txt += "<table border='1'>"
					        for (student in students) {
						        txt += "<tr>";
					            txt += "<td>" + students[student].id + "</td>";
					            txt += "<td>" + students[student].firstName + "</td>";
					            txt += "<td>" + students[student].lastName + "</td>";
					            
					        }
					        txt += "</table>"     	
						document.getElementById("all_students").innerHTML = txt;


					}
				}
			};
			xhr.send();

		}
	</script>  -->


</body>
</html>