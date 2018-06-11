package pomassignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="email")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="pass")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	@CacheLookup
	WebElement logInButton;
	
	public void enterLogInDetails(String email,String pwd) {
		username.sendKeys(email);
		password.sendKeys(pwd);
		logInButton.click();
	}

}
