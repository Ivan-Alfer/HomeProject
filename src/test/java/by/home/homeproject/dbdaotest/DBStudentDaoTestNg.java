package by.home.homeproject.dbdaotest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.testng.annotations.Test;

import by.home.dao.impl.StudentDaoImpl;
import by.home.entity.Student;
import by.home.homeproject.hibernateutil.HibernateUtil;

@Test(groups = "checkStudentFunction")
public class DBStudentDaoTestNg extends DBBaseDaoTestNg {

	@Override
	protected String getPath() {
		return "src/test/java/datasetStudent.xml";
	}

	@Test
	public void testUpdateStudent() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		StudentDaoImpl studentDao = new StudentDaoImpl(session);

		List<Student> beforeUpdateStudent = studentDao.getEntities();
		Student updateStudent = beforeUpdateStudent.get(2);
		updateStudent.setFirstName("updateFirstName");
		updateStudent.setLastName("updateLastName");

		studentDao.updateEntity(updateStudent);
		List<Student> actualStudent = studentDao.getEntities();
		Student afterUpadteStudent = actualStudent.get(2);

		assertEquals(afterUpadteStudent.getId(), updateStudent.getId());
		assertEquals(afterUpadteStudent.getFirstName(), updateStudent.getFirstName());
		assertEquals(afterUpadteStudent.getLastName(), updateStudent.getLastName());

	}

	@Test
	public void testDeleteStudent() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		StudentDaoImpl studentDao = new StudentDaoImpl(session);

		List<Student> beforeDeleteStudents = studentDao.getEntities();
		Student deleteStudent = beforeDeleteStudents.get(1);

		studentDao.deleteEntity(deleteStudent.getId());
		List<Student> actualSubjects = studentDao.getEntities();

		assertTrue(actualSubjects.size() == 3);

	}

	@Test
	public void testGetAll() throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		StudentDaoImpl studentDao = new StudentDaoImpl(session);

		List<Student> students = studentDao.getEntities();

		IDataSet databaseDataSet = dbConn.createDataSet();
		ITable actualTable = databaseDataSet.getTable("student");

		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File(getPath()));
		ITable expectedTable = expectedDataSet.getTable("student");

		Assert.assertEquals(expectedTable.getRowCount(), students.size());

		String[] ignore = { "ID" };
		Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, ignore);

	}
}
