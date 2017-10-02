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

 							var div = document.createElement('div');
 							div.innerHTML = student.id +" "+ student.firstName +" "+ student.lastName;
 							document.body.appendChild(div);

						});
						
					}
				}
			};
			xhr.send();

		}
