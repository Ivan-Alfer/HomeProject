function allStudents() {
	var xhr = new XMLHttpRequest();
	var txt = "";
	xhr.open('GET', 'http://localhost:8080/HomeProject/all_students', true);
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
