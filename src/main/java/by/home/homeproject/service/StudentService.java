package by.home.homeproject.service;

import java.util.List;

import by.home.homeproject.entity.Student;

public interface StudentService {

	List<Student> getStudents();

	void addStudent(Student student);
	
	void deleteStudent(int id);

	void updateStudent(Student student);
}
