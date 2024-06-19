package testCases;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import fileUtility.ExcelFileUtility;
import fileUtility.PFileUtility;
import pomFiles.RegisterPage;
import webDriver_JavaUtility.WebDriverUtility;

public class RegisterUser {
	WebDriver driver=null;
	@Test
	public void registerUser() throws FileNotFoundException, Exception {
		PFileUtility pfu=new PFileUtility();
		String BROWSER=pfu.getFileData("browser");
		
		ExcelFileUtility efu=new ExcelFileUtility();
		int row=efu.getRowCount("register");
		int col=efu.getCellCount("register");
		WebDriverUtility wdu=new WebDriverUtility();
		
		for(int i=1;i<row;i++) {
				
				driver=wdu.launchBrowser(BROWSER);
				
				driver.get(pfu.getFileData("url"));
				driver.findElement(By.xpath("//button[text()='Login']")).click();
				
				
				
				RegisterPage rp=new RegisterPage(driver);
				rp.getCreateAccButton().click();
				rp.getFname().sendKeys(efu.getDataFromExcel("register", i, 0));
				rp.getLname().sendKeys(efu.getDataFromExcel("register", i, 1));
				String gender=efu.getDataFromExcel("register", i, 2);
				if(gender.equalsIgnoreCase("female"))
					rp.getFname().click();
				else if(gender.equalsIgnoreCase("male"))
					rp.getMale().click();
				else
					rp.getOther().click();
				rp.getPno().sendKeys(efu.getDataFromExcel("register", i, 3));
				rp.getEmail().sendKeys(efu.getDataFromExcel("register", i, 4));
				rp.getPwd().sendKeys(efu.getDataFromExcel("register", i, 5));
				rp.getCpwd().sendKeys(efu.getDataFromExcel("register", i, 6));
				rp.getT_c().click();
				rp.getRegisterButton().click();
				wdu.waitForElement(driver, driver.findElement(By.id("loginBtn")));
				wdu.closeBrowser();
		}	
	}
}
