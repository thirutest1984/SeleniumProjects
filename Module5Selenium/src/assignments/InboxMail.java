package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ThreadedRefreshHandler;

public class InboxMail {

	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void inboxCount() {
		driver.get("https://google.com");
		driver.findElement(By.cssSelector("a[href='https://mail.google.com/mail/?tab=wm']")).click();
		driver.findElement(By.id("identifierId")).sendKeys("thirutest1984@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='password']"))));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("dedeepya");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		String text = driver.findElement(By.partialLinkText("Inbox")).getText();
		System.out.println(text);
	}

	public static void main(String[] args) {
		InboxMail im = new InboxMail();
		im.invokeBrowser();
		im.inboxCount();
	}

}
