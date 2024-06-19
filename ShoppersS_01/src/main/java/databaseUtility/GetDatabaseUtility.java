package databaseUtility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.AfterMethod;

import com.mysql.jdbc.Driver;
/*methods
 * 1. getConnection(url,un,pwd)
 * 2. closeConnection()
 * 3. ResultSet executeSelectQuery(String query)
 * 4. int executeNonSelectQuery(String query)
 * */
public class GetDatabaseUtility {
	Connection con=null;
	Driver driver=null;
	Statement stat=null;
	
	//all the table data
	public ResultSet getEntireTableDataFromDatabase(String tablename) throws Exception {
		driver=new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fis=new FileInputStream("./testData/configurationData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		con=DriverManager.getConnection(prop.getProperty("sqlUrl"), prop.getProperty("un"), prop.getProperty("pwd"));
		
		stat=con.createStatement();
		
		ResultSet set=stat.executeQuery("select * from "+tablename);
		
		return set;
	}
	
	//Closing the connection
	@AfterMethod
	public void closeConnection() throws Exception {
		con.close();
	}
	
	//getting specific data from table
	public String getSpecificDataFromFile(String tablename,String primaryKey) throws Exception {
		driver=new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fis=new FileInputStream("./testData/configurationData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		con=DriverManager.getConnection(prop.getProperty("sqlUrl"), prop.getProperty("un"), prop.getProperty("pwd"));
		
		stat=con.createStatement();
		
		ResultSet set=stat.executeQuery("select * from "+tablename);
		con.close();
		while(set.next()) {
			if(set.getString(2).equals(primaryKey))
				return set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getInt(3);
			
		}
		return "That data in not present in the sheet";
		
	}
	
	//deleting entire table
	public void deleteTableData(String tablename) throws Exception {
		driver = new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fis=new FileInputStream("./testData/configurationData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		con=DriverManager.getConnection(prop.getProperty("sqlUrl"), prop.getProperty("un"), prop.getProperty("pwd"));
		
		stat=con.createStatement();
		int num=stat.executeUpdate("drop table "+tablename);
		if(num==1)
			System.out.println("Table deleted😉😉");
		else
			System.out.println("Some issue with query😐😐");
	}
	
	//Deleting particular record from table
	public void deleteParticularRecordFromTable(String tablenam, int project_id) throws Exception {
		driver = new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fis=new FileInputStream("./testData/configurationData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		con=DriverManager.getConnection(prop.getProperty("sqlUrl"), prop.getProperty("un"), prop.getProperty("pwd"));
		
		stat=con.createStatement();
		int num=stat.executeUpdate(" delete from chandan where project_id="+project_id);
		if(num==1)
			System.out.println("Table deleted😉😉");
		else
			System.out.println("Some issue with query😐😐");
	}
}
