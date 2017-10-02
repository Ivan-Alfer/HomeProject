<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Main page</title>
<script type="text/javascript" src="HomeProject/src/main/webapp/WEB-INF/js/main.js"></script>
</head>
<body>

<%-- 	<a href="${pageContext.request.contextPath}/all_students">Show all students</a> --%>
	<a href="${pageContext.request.contextPath}/all_subjects">Show all
		subjects</a>
	<a href="${pageContext.request.contextPath}/all">Show all</a>


	<button onclick="allStudents()">Show all students</button>
 	<script>
		function allStudents() {
			var xhr = new XMLHttpRequest();

			xhr.open('GET', 'http://localhost:8080/HomeProject/all_students',
					true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var stringStud = xhr.responseText;
						var students = JSON.parse(stringStud);

						
						
 						students.forEach(function(student){

 							
 							var table = document.createElement('table'),
 							    tr = table.appendChild(document.createElement('tbody'))			
 							              .appendChild(document.createElement('tr'));
	 							for (i = 1; i < lastDate; i++) {
							    	tr.appendChild(document.createElement('td'));
							    	var div = document.createElement('div');
		 							div.innerHTML = student.id;
		 							div.innerHTML = student.firstName;
		 							div.innerHTML = student.lastName;
		 							document.body.appendChild(div);
	 							}						

 							
 							//var div = document.createElement('div');
 							//div.innerHTML = student.id + student.firstName + student.lastName;
 							//document.body.appendChild(div);
 							/* var row = document.createElement("TR")
 							 
 							//столбцы
 							var td1 = document.createElement("TD")
 							 var td2 = document.createElement("TD")
 							var td3 = document.createElement("TD")
 							 
 							td1.innerHTML = student.id;
 							 td2.innerHTML = student.firstName;
 							 td3.innerHTML = student.lastName;
 							 row.appendChild(td1);
 							 row.appendChild(td2);
 							 row.appendChild(td3);
 							 list.appendChild(row); */
							
							/* '<tr><td>' + student.id.innerHTML + '</td><td>'	+ student.firstName.innerHTML
							+ '</td><td>' + student.lastName.innerHTML + '</td><tr>'; */
						});
						
						/* for (var i = 0; i < students.length; i++) {
							$('#students').append('<tr><td>' + students[i].id + '</td><td>'	+ students[i].firstName
											+ '</td><td>' + students[i].lastName + '</td><tr>');
						} */

					}
				}
			};
			xhr.send();

		}
	</script> 


</body>
</html>