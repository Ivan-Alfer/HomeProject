package by.home.homeproject.service;

import by.home.homeproject.service.impl.MarkServiceImpl;
import by.home.homeproject.service.impl.StudentServiceImpl;
import by.home.homeproject.service.impl.SubjectServiceImpl;

public class ServiceFactory {
private static final ServiceFactory INSTANCE = new ServiceFactory();
	
	private ServiceFactory(){
	}
	
	public static ServiceFactory getInstance(){
		return INSTANCE;
	}


	public StudentService getStudentService(){
		return new StudentServiceImpl();
	}
	
	public SubjectService getSubjectService(){
		return new SubjectServiceImpl();
	}
	
	public MarkService getMarkService(){
		return new MarkServiceImpl();
	}
}
