package by.home.service;

import java.util.List;

import by.home.entity.Student;
import by.home.service.exception.ServiceException;


public interface StudentService {

	List<Student> getStudents() throws ServiceException;

	void addStudent(Student student) throws ServiceException;
	
	void deleteStudent(int id) throws ServiceException;

	void updateStudent(Student student) throws ServiceException;
}
