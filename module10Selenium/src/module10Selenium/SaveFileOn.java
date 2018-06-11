package module10Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SaveFileOn {

	public static void main(String[] args) throws FindFailed {

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.last.fm/music/+free-music-downloads");

		WebElement element = driver
				.findElement(By.xpath("//*[@id=\"freedownloads-section\"]/table/tbody/tr[1]/td[3]/a"));

		Actions myaction = new Actions(driver);
		myaction.contextClick(element).perform();
		Screen screen = new Screen();
		Pattern clickSaveLinkAs = new Pattern("/src/resources/Savelinkas.png");
		Pattern locationOnDesktop = new Pattern("/src/resources/Desktop.png");
		Pattern saveFile = new Pattern("/src/resources/Save.png");

		screen.click(clickSaveLinkAs);

		screen.click(locationOnDesktop);

		screen.type("C:\\Music Assignment");

		screen.click(saveFile);
		
		System.out.println("File has been saved successfully.");

	}

}
