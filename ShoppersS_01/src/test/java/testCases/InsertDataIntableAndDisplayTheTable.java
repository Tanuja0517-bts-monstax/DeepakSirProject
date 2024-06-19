package testCases;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import databaseUtility.GetDatabaseUtility;
import databaseUtility.UpdateDatabaseUtility;

public class InsertDataIntableAndDisplayTheTable {
	@Test
	public void insertDataAndDisplayIt() throws Exception {
		UpdateDatabaseUtility sdbu=new UpdateDatabaseUtility();
		sdbu.setDataUtility("Chandan");
	}
	
	@Test(priority = 1)
	public void tableData1() throws Exception {
		GetDatabaseUtility gdbu=new GetDatabaseUtility();
		ResultSet set=gdbu.getEntireTableDataFromDatabase("chandan");
		
		System.out.println("******************************************************************");
		while(set.next())
			System.out.println(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getInt(3));
	}
	
	@Test(priority = 2)
	public void deleteDataFromTable() throws Exception {
		GetDatabaseUtility udbu=new GetDatabaseUtility();
		udbu.deleteParticularRecordFromTable("chandan", 201);
	}
	
	@Test(priority = 3)
	public void tableData() throws Exception {
		GetDatabaseUtility gdbu=new GetDatabaseUtility();
		ResultSet set=gdbu.getEntireTableDataFromDatabase("chandan");
		
		System.out.println("******************************************************************");
		while(set.next())
			System.out.println(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getInt(3));
	}
}
