package by.home.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import by.home.entity.Student;

@Component
public interface StudentDao {

	void addStudent(Student student);

	List<Student> getStudents();
	
	void deleteStudent(int id);

	void updateStudent(Student student);
}
