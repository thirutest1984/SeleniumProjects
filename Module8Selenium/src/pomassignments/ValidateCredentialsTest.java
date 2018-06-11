package pomassignments;

/*
 * author: M1035775 Kotra Thirumala
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateCredentialsTest {
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void destoryBrowser() {
		driver.quit();
	}
	
	@Test
	public void validateLogIn() {
		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		login_page.enterLogInDetails("kotra.thirumala@mindtree.com", "password123");
		
	}

}
