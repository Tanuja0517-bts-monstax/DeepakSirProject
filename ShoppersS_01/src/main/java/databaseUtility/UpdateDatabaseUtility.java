package databaseUtility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class UpdateDatabaseUtility {
	public void setDataUtility(String tablename) throws Exception {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fis=new FileInputStream("./testData/configurationData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		Connection con=DriverManager.getConnection(prop.getProperty("sqlUrl"), prop.getProperty("un"), prop.getProperty("pwd"));
		
		Statement stat=con.createStatement();
		
		int num=stat.executeUpdate("insert into "+tablename+" values(300,'ProjectNo_300',3001)");
		if(num==1)
			System.out.println("Data entered in the table successfully😄😄");
		else
			System.out.println("Something is wrong with the query😥😥");
		
		con.close();  
	}
}
