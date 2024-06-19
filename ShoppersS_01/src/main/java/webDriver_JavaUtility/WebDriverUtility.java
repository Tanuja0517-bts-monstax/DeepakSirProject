package webDriver_JavaUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriver driver=null;
	
	public WebDriver launchBrowser(String BROWSER) {
		if(BROWSER.equalsIgnoreCase("Chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equalsIgnoreCase("Edge"))
			driver=new EdgeDriver();
		else if(BROWSER.equalsIgnoreCase("Firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		return driver;
	}
	
	public void switchToWindow(WebDriver driver,String WindowID) {
		driver.switchTo().window(WindowID);
	}
	
	public void switchToFrameIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameString(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}
	
	public void switchToFramwWebElement(WebDriver driver,WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void waitForElement(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void closeBrowser() {
		driver.close();
	}
}
