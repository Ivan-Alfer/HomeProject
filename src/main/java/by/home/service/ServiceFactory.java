package by.home.service;

import by.home.service.impl.MarkServiceImpl;
import by.home.service.impl.StudentServiceImpl;
import by.home.service.impl.SubjectServiceImpl;

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
