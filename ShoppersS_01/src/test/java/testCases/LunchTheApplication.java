package testCases;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import fileUtility.PFileUtility;

public class LunchTheApplication {
	WebDriver driver=null;
	@Test
	public void launchApp() throws Exception, Exception {
		PFileUtility pfile=new PFileUtility();
		String BROWSER=pfile.getFileData("browser");
		String URL=pfile.getFileData("url");
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equalsIgnoreCase("Edge"))
			driver=new EdgeDriver();
		else if(BROWSER.equalsIgnoreCase("Firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		
		driver.quit();
	}
}
