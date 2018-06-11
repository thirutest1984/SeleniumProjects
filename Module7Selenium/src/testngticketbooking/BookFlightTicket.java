package testngticketbooking;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookFlightTicket {
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	@AfterClass
	public void destory() {
		driver.quit();
	}
	@Test(priority=0)
	public void signIn() {
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("mselenium");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mselenium");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		screenshot("signIn");

	}
	@Test(priority=1)
	public void findFlight() {
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		
		WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
		Select spassengers = new Select(passenger);
		spassengers.selectByValue("2");
		
		WebElement from = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select fromPlace = new Select(from);
		fromPlace.selectByValue("London");
		
		WebElement sMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
		Select fromMonth = new Select(sMonth);
		fromMonth.selectByVisibleText("March");
		
		WebElement sDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
		Select fromDay = new Select(sDay);
		fromDay.selectByValue("10");
		
		WebElement destination = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select toPlace = new Select(destination);
		toPlace.selectByValue("Zurich");
		
		WebElement rMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
		Select toMonth = new Select(rMonth);
		toMonth.selectByVisibleText("March");
		
		WebElement rDay = driver.findElement(By.xpath("//select[@name='toDay']"));
		Select toDay = new Select(rDay);
		toDay.selectByVisibleText("15");
		
		driver.findElement(By.xpath("//input[@value='Business']")).click();
		
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		screenshot("findFlight");

	}
	@Test(priority=2)
	public void selectAflight() {
		driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();
		
		driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$631$273$14:30']")).click();
		
		driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
		screenshot("selectAflight");
	}
	@Test(priority=3)
	public void bookAflight() {
		
		driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys("mindtree");

		driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys("selenium");
		
		driver.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr[1]/td/img[1]"));
		System.out.println("Title is: "+ele.isDisplayed());
		screenshot("bookAflight");
	}
	
	public void screenshot(String method) {
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		String timeStamp = t.toString();
		timeStamp = timeStamp.replace(" ","_");
		timeStamp = timeStamp.replace(":","_");
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./screenshots\\"+method+"_"+timeStamp+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
