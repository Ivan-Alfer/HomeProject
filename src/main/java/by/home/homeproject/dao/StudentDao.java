package by.home.homeproject.dao;

import java.util.List;

import by.home.homeproject.entity.Student;

public interface StudentDao {

	void addStudent(Student student);

	List<Student> getStudents();
	
	void deleteStudent(int id);

	void updateStudent(Student student);
}
