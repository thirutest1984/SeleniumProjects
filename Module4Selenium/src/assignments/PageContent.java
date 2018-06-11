package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageContent {
	
	WebDriver driver;
	String data = "";

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void pageDataOnConsole() {
		driver.get("https://www.wikipedia.org");
		data = driver.getPageSource();
		System.out.println(data);
	}
	
	public void pageDataverbose() {
		driver.get("https://www.wikipedia.org");
		data = driver.getPageSource();
		if(data.contains("en.wikipedia.org")) {
			System.out.println("Found the string en.wikipedia.org.");
		}
	}

	public static void main(String[] args) {
		PageContent pc = new PageContent();
		pc.invokeBrowser();
		pc.pageDataverbose();
		pc.pageDataOnConsole();

	}

}
