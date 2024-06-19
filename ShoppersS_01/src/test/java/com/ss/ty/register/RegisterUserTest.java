package com.ss.ty.register;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import fileUtility.ExcelFileUtility;
import fileUtility.PFileUtility;
import pomFiles.RegisterPage;
import webDriver_JavaUtility.WebDriverUtility;

public class RegisterUserTest {
	public WebDriver driver=null;
	PFileUtility pfu=new PFileUtility();
	

	@Test
	public void registerUser() {
		RegisterPage rp=new RegisterPage(driver);
		driver.findElement(By.id("loginBtn")).click();
		rp.getCreateAccButton();
		rp.getFname().sendKeys("Joey");
		rp.getLname().sendKeys("Tribbiani");
		rp.getMale().click();
		rp.getEmail().sendKeys("iLoveFood@gmail.com");
		rp.getPno().sendKeys("8308111348");
		rp.getPwd().sendKeys("FRIENDSs@6");
		rp.getCpwd().sendKeys("FRIENDSs@6");
		rp.getT_c().click();
		rp.getRegisterButton();
	}
}
