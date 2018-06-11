package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Facebook {
	WebDriver driver;

	public void invokeBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\SeleniumResources\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"D:\\SeleniumResources\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	public void verifyThings() {
		driver.get("https://www.facebook.org");
		System.out.println("Page title: " + driver.getTitle());
		String txt1 = driver.findElement(By.xpath("//div[@class='_5iyx']")).getText();
		System.out.println("Second thing: " + txt1);
		String txt2 = driver.findElement(By.xpath("//div[@class='_52lr fsm fwn fcg']")).getText();
		System.out.println("Third thing: " + txt2);
	}

	public static void main(String[] args) {
		Facebook fb = new Facebook();
		// chrome
		fb.invokeBrowser("chrome");
		fb.verifyThings();

		// firefox
		fb.invokeBrowser("firefox");
		fb.verifyThings();

		// ie
		fb.invokeBrowser("ie");
		fb.verifyThings();
	}

}
