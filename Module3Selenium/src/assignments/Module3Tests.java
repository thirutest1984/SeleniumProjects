package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Module3Tests {
	WebDriver driver;
	
	// method for start the browser
	public void startBrowser() {
		// using chrome browser
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	// log in facebook method using cssSelector to find web elements
	public void logInFacebook() {
		driver.get("https:\\facebook.com");
		driver.findElement(By.cssSelector("input#email")).sendKeys("module3selenium@gmail.com");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("password");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
	}
	
	public void pageNavigation() {
		driver.navigate().to("https:\\facebook.com");
		System.out.println("Home page: "+driver.getTitle());
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		System.out.println("Log in page: "+driver.getTitle());
		driver.navigate().refresh();
		System.out.println("Navigate refresh: "+driver.getTitle());
		driver.navigate().back();
		System.out.println("Navigate back to home page: "+driver.getTitle());
		driver.navigate().forward();
		System.out.println("Navigate forwarded to log in page: "+driver.getTitle());
	}

	public static void main(String[] args) {
		// class object reference
		Module3Tests mt = new Module3Tests();
		// calling methods
		mt.startBrowser();
		mt.logInFacebook();
		mt.pageNavigation();

	}

}
