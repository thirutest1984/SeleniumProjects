package DDTF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordpressLogIn {
	WebDriver driver;
	@Test(dataProvider="wordpressdata")
	public void login(String uid,String pwd) {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		driver.findElement(By.id("user_login")).sendKeys(uid);
		
		driver.findElement(By.id("user_pass")).sendKeys(pwd);
		
		driver.findElement(By.id("wp-submit")).click();
				
		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"LogIn failed- Incorrect credentials.");
		
		System.out.println("Page title verified- Log In successfully.");
		
		driver.quit();
	}
	
}
	
class Justdata{
	@DataProvider(name = "wordpressdata")
	public Object[][] logInData(){
		Object[][] data = new Object[3][2];
		data[0][0] = "admin1";
		data[0][1] = "demo1";
		
		data[1][0] = "admin2";
		data[1][1] = "demo2";
		
		data[2][0] = "admin";
		data[2][1] = "demo123";
		
		return data;
		
	}

}
