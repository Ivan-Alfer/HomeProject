package by.home.homeproject.service.impl;

import java.util.List;

import by.home.homeproject.dao.DaoFactory;
import by.home.homeproject.dao.MarkDao;
import by.home.homeproject.entity.Mark;
import by.home.homeproject.service.MarkService;

public class MarkServiceImpl implements MarkService {

	private DaoFactory daoFactory = DaoFactory.getInstance();
	private MarkDao markDao = daoFactory.getMarkDaoImpl();

	@Override
	public List<Mark> getMarks() {
		List<Mark> marks = markDao.getEntities();
		return marks;
	}

	@Override
	public void addMark(Mark mark) {
		markDao.addEntity(mark);
	}

	@Override
	public void deleteMark(int id) {
		markDao.deleteEntity(id);

	}

	@Override
	public void updateMark(Mark mark) {
		markDao.updateEntity(mark);;

	}

	@Override
	public List<Mark> getAllEntities() {
		List<Mark> marks = markDao.getAllEntities();
		return marks;
	}

	@Override
	public List<Mark> getAllAboutStudent(Integer studentId) {
		List<Mark> marks = markDao.getAllAboutStudent(studentId);
		return marks;
	}

	@Override
	public List<Mark> getAllStudentOnTheSubject(Integer subjectId) {
		List<Mark> marks = markDao.getAllStudentOnTheSubject(subjectId);
		return marks;
	}

}
