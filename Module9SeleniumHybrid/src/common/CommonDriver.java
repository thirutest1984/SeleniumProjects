package common;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDriver {
	
	private WebDriver oDriver;
	private long lngPageLoadTimeOut;
	private long lngElementDetectionTimeOut;
	String firstChildWindow;
	
	public CommonDriver(){
		lngPageLoadTimeOut = 60L;
		lngElementDetectionTimeOut = 30L;
	}
	
	public void setPageLoadTimeOut(long lngPageLoadTimeOut){
		this.lngPageLoadTimeOut = lngPageLoadTimeOut;
	}
	
	public void setElementDetectionTimeOut(long lngElementDetectionTimeOut){
		this.lngElementDetectionTimeOut = lngElementDetectionTimeOut;
	}
	
	public void openBrowser(String sBrowserType, String sUrl){
		try{
			
			switch (getBrowserTypeIndexed(sBrowserType)) {
			case 1:
				System.setProperty("webdriver.gecko.driver","src/resources/geckodriver.exe");
				oDriver = new FirefoxDriver();
				break;
			case 2:
				
				System.setProperty("webdriver.ie.driver", "src/resources/IEDriverServer.exe");
				oDriver = new InternetExplorerDriver();
				break;
				
			case 3:
				System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
				oDriver = new ChromeDriver();
				break;
			default:
				throw new Exception("Unknow Browser Type = "+ sBrowserType);
				
			}
				
			
		if(sUrl.isEmpty()){
		
			sUrl = "about:blank";
			}
		
		oDriver.manage().window().maximize();
		
		oDriver.manage().deleteAllCookies();
		
		oDriver.manage().timeouts().pageLoadTimeout(lngPageLoadTimeOut, TimeUnit.SECONDS);
		
		oDriver.manage().timeouts().implicitlyWait(lngElementDetectionTimeOut, TimeUnit.SECONDS);
		
		oDriver.get(sUrl);
		
		Thread.sleep(2000);

		} catch (Throwable t){
			t.printStackTrace();
		}
	}
	
	public void closeAllBrowser(){
		try{
			if(oDriver != null){
				oDriver.quit();
			}
			
		} catch(Throwable t){
			t.printStackTrace();
		}
	}
		
	public WebDriver getDriver(){
		
		return oDriver;
	}
	
	private int getBrowserTypeIndexed(String sBrowserType){
		sBrowserType = sBrowserType.toLowerCase().trim();
		
		if(sBrowserType.isEmpty()){
			return 1;
		}
		
		if(sBrowserType.equals("ff") || sBrowserType.equals("firefox")  || sBrowserType.equals("mozilla") || sBrowserType.equals("mozilla firefox")){
			return 1;
		}
		
		if(sBrowserType.equals("ie") || sBrowserType.equals("explorer")  || sBrowserType.equals("internet explorer")){
			return 2;
		}
		
		if(sBrowserType.equals("chrome") || sBrowserType.equals("google")  || sBrowserType.equals("google chrome")){
			return 3;
		}
		
		return 1;
	}
	
	public void waitTillElementIsVisible( By oBy, long timeoutSeconds){
		try {
			
			WebDriverWait oWait = new WebDriverWait(oDriver, timeoutSeconds);
			
			oWait.until(ExpectedConditions.visibilityOfElementLocated(oBy));
			
		} catch (Throwable t) {
			t.printStackTrace();		}
	}
	
	
	
		public void waitTillElementIsClickable( By oBy, long timeoutSeconds){
			try {
				
				WebDriverWait oWait = new WebDriverWait(oDriver, timeoutSeconds);
				
				oWait.until(ExpectedConditions.elementToBeClickable(oBy));
				
			} catch (Throwable t) {
				t.printStackTrace();		}
		}
	
	public String savePageSnapshot(String sImagePath){
		try {
			
			TakesScreenshot oCamera;
			File oTmpFile, oImageFile;
			oImageFile = new File(sImagePath);
			
			if(new File(sImagePath).exists()){
				throw new Exception("Image File already Exists");
			}
			
			oCamera = (TakesScreenshot) oDriver;
			oTmpFile = oCamera.getScreenshotAs(OutputType.FILE);
			oCamera.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(oTmpFile, oImageFile);
			
			return "File got saved";
			
		} catch (Throwable t) {
			t.printStackTrace();
			return "File already exists";
		}
	}
	
	
	
	public void setText(By oBy, String sText){
		try{

			oDriver.findElement(oBy).sendKeys(sText);
		
		} catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	public String getText(By oBy){
		try{

			return oDriver.findElement(oBy).getText();
		
		} catch(Throwable t){
			t.printStackTrace();
			return "";
		}
	}
	
	public void clickElement(By oBy){
		try{

			oDriver.findElement(oBy).click();
		
		} catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	public void selectItemInListBox(By oBy, String sItemVisibleText){
		try{

			Select oListBox;
			
			oListBox = new Select(oDriver.findElement(oBy));
			
			oListBox.selectByVisibleText(sItemVisibleText);
			
		} catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	public void switchToWindow(int x){
		try{
			firstChildWindow = oDriver.getWindowHandles().toArray()[x].toString();
			oDriver.switchTo().window(firstChildWindow);
		}
		catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	public void scrollTo(By oBy){
		JavascriptExecutor jse;
		jse = (JavascriptExecutor)oDriver;
		int xPoint = oDriver.findElement(oBy).getLocation().x;
		int yPoint = oDriver.findElement(oBy).getLocation().y;
		String command = String.format("window.scrollTo(%d, %d)", xPoint, yPoint);
		jse.executeScript(command);
	}

}
