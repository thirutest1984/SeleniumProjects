package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elements {
	
	WebDriver driver;
	By email = By.id("email");
	By pass = By.id("pass");
	By logIn = By.xpath("//input[@value='Log In']");
	
	public Elements(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateLogIn(String username, String pwd) {
		enterEmail(username);
		enterPassword(pwd);
		logInButton();
	}
	
	public void enterEmail(String username) {
		driver.findElement(email).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(pass).sendKeys(pwd);
	}
	
	public void logInButton() {
		driver.findElement(logIn).click();
	}
}
