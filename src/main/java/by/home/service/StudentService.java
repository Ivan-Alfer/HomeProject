package by.home.homeproject.service;

import java.util.List;

import by.home.homeproject.entity.Student;
import by.home.homeproject.service.exception.ServiceException;

public interface StudentService {

	List<Student> getStudents() throws ServiceException;

	void addStudent(Student student) throws ServiceException;
	
	void deleteStudent(int id) throws ServiceException;

	void updateStudent(Student student) throws ServiceException;
}
