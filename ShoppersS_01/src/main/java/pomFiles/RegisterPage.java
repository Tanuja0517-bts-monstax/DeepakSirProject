package pomFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}
	@FindBy(xpath = "//span[text()='Create Account']")
	private WebElement createAccButton;
	
	@FindBy(id = "First Name")
	private WebElement fname;
	
	@FindBy(id = "Last Name")
	private WebElement lname;
	
	@FindBy(id = "Female")
	private WebElement female;
	
	@FindBy(id = "Male")
	private WebElement male;
	
	@FindBy(id = "Other")
	private WebElement other;
	
	@FindBy(id = "Phone Number")
	private WebElement pno;
	
	@FindBy(id = "Email Address")
	private WebElement email;
	
	@FindBy(id = "Password")
	private WebElement pwd;
	
	@FindBy(id = "Confirm Password")
	private WebElement cpwd;
	
	@FindBy(id = "Terms and Conditions")
	private WebElement t_c;
	
	@FindBy(id = "btnDisabled")
	private WebElement registerButton;

	public WebElement getCreateAccButton() {
		return createAccButton;
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getFemale() {
		return female;
	}

	public WebElement getMale() {
		return male;
	}

	public WebElement getOther() {
		return other;
	}

	public WebElement getPno() {
		return pno;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getCpwd() {
		return cpwd;
	}

	public WebElement getT_c() {
		return t_c;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
}
