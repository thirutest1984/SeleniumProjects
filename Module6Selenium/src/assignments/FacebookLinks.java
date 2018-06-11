package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLinks {

	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void checkLinks() {
		driver.get("https://facebook.com");
		WebElement element = driver
				.findElement(By.xpath("//ul[@class='uiList pageFooterLinkList _509- _4ki _703 _6-i']"));
		List<WebElement> linkElements = element.findElements(By.tagName("a"));

		String linktxts[] = new String[linkElements.size()];

		int i = 0;
		for (WebElement e : linkElements) {
			linktxts[i] = e.getText();
			i++;
		}
		for (String s : linktxts) {
			if (s.equalsIgnoreCase("Settings") || s.equalsIgnoreCase("Activity log")) {
				System.out.println(s + " : Element is not clickable.");
			} else {
				driver.findElement(By.linkText(s)).click();
				System.out.println(s + " : Element is clicked.");
				driver.navigate().back();
			}
		}
	}
	
	/*
	 * This is an alternative scripts for the problem but this will not work because of an element that is no longer attached to the DOM.
	public void checkLinks() {
		driver.get("https://facebook.com");
		WebElement element = driver.findElement(By.xpath("//ul[@class='uiList pageFooterLinkList _509- _4ki _703 _6-i']"));
		List<WebElement> linkElements = element.findElements(By.tagName("a"));
		for(WebElement ele : linkElements) { 
				ele.click(); 
				driver.navigate().back(); 
		}
	}
	*/

	public static void main(String args[]) {
		FacebookLinks fbl = new FacebookLinks();
		fbl.invokeBrowser();
		fbl.checkLinks();
	}
}
