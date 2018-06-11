package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardHandle {
	
	WebDriver driver;
	Actions myactions;
	Action act;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	// highlights the entire text in the box
	public void useControlAkey() {
		driver.get("https://www.amazon.in");
		WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
		myactions = new Actions(driver);
		act = myactions.moveToElement(ele).click().sendKeys("best brands").keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
		act.perform();
	}
	
	// moves the cursor to beginning of the box
	public void useControlHomekey() {
		WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
		myactions = new Actions(driver);
		act = myactions.moveToElement(ele).click().sendKeys("search for best brands").keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).build();
		act.perform();
	}
	

	public static void main(String[] args) {
		KeyboardHandle kbh = new KeyboardHandle();
		kbh.invokeBrowser();
		kbh.useControlAkey();
		kbh.useControlHomekey();
	}

}
