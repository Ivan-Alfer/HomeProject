package by.home.homeproject.dbdaotest;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class DBBaseDaoTest {
	
	protected IDataSet beforeData;
	
	private static Properties prop;
	
	protected static IDatabaseTester tester;
	
	protected Session session;
	
	protected IDatabaseConnection dbConn;

	protected abstract String getPath();
	
	@BeforeClass
	public static void takeConnection() throws Exception {
		prop = new Properties();
		try {
			prop.load(
					Thread.currentThread().getContextClassLoader().getResourceAsStream("dbtest.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		tester = new JdbcDatabaseTester(prop.getProperty("db.driver"), prop.getProperty("db.url"),
				prop.getProperty("db.username"), prop.getProperty("db.password"));
	}
	
	@Before
	public void setUp() throws Exception {		
		dbConn = tester.getConnection(); 
		beforeData = new FlatXmlDataSetBuilder().build(new File(getPath()));
		tester.setDataSet(beforeData);

		DatabaseOperation.CLEAN_INSERT.execute(dbConn, beforeData);
	}
	
	@After
	public void closeConnection() throws SQLException{
		dbConn.close();
	}
}