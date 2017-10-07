function allStudents() {
	var xhr = new XMLHttpRequest();
	var txt = "";
	xhr.open('GET', 'http://localhost:8080/HomeProject/all_students', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
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
	};
	xhr.send();
}


$(function() {
	$("#all_subjects").on(
			'click',
			function() {
				$.getJSON('http://localhost:8080/HomeProject/all_subjects',
						function(subjects) {
							subjects.forEach(function(subject) {
								$('#subjectTable').append(
										'<tr><td>' + subject.id + '</td><td>'
												+ subject.subjectName
												+ '</td><tr>');
							})
						});
			});
});
