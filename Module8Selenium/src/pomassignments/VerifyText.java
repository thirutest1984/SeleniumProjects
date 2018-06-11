/**
 * 
 */
package pomassignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author M1035775
 *
 */
public class VerifyText {

	WebDriver driver;

	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.barnesandnoble.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void destoryBrowser() {
		driver.quit();
	}
	
	@Test
	public void validateTexts() {
		LocateElements locate_elements = PageFactory.initElements(driver, LocateElements.class);
		locate_elements.mouseOnBooksTab();
		locate_elements.clickBiography();
		locate_elements.textBiograpgy();
		locate_elements.textBestsellers();
	}

}
