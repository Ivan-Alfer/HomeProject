package by.home.homeproject.service.impl;

import java.util.List;

import by.home.homeproject.dao.BaseDao;
import by.home.homeproject.dao.DaoFactory;
import by.home.homeproject.entity.Subject;
import by.home.homeproject.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

	private DaoFactory daoFactory = DaoFactory.getInstance();
	private BaseDao<Subject> subjectDao = daoFactory.getSubjectDaoImpl();
	
	@Override
	public List<Subject> getSubjects() {
		List<Subject> subjects = subjectDao.getEntities();
		return subjects;
	}

	@Override
	public void addSubject(Subject subject) {
		subjectDao.addEntity(subject);
		
	}

	@Override
	public void deleteSubject(int id) {
		subjectDao.deleteEntity(id);
		
	}

	@Override
	public void updateSubject(Subject subject) {
		subjectDao.updateEntity(subject);
		
	}

}
