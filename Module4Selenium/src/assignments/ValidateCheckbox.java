package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateCheckbox {

	WebDriver driver;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void checkBox() {
		boolean state;
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
		WebElement ele = driver.findElement(By.id("wpRemember"));
		state = ele.isSelected();
		System.out.println("Checkbox is selected?: "+state);
		ele.click();
		state = ele.isSelected();
		System.out.println("Checkbox is selected?: "+state);
	}
	public void elementExist() {
		WebElement ele = driver.findElement(By.id("wpLoginAttempt"));
		boolean exist = ele.isDisplayed();
		System.out.println("Log in button is displayed?: "+exist);
	}
	public void readText() {
		WebElement ele = driver.findElement(By.id("wpName1"));
		String text = ele.getAttribute("placeholder");
		System.out.println("Username box hint text is: "+text);
	}

	public static void main(String[] args) {
		ValidateCheckbox vc = new ValidateCheckbox();
		vc.invokeBrowser();
		vc.checkBox();
		vc.elementExist();
		vc.readText();
	}

}
