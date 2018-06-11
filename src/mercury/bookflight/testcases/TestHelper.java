package mercury.bookflight.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import helper.JyperionListener;
import helper.SendEmailReport;

@Listeners(JyperionListener.class)

public class TestHelper {

  WebDriver driver;
  
  

  public TestHelper() {
  }

  @BeforeMethod
  public void openBrowser() {
    System.out.println("Browser is opened.");
  }

  @AfterMethod
  public void closeBrowser() {
    System.out.println("Browser is closed.");
  }

  @BeforeClass
  public void beforeClass() {
    System.out.println("Testcase class is started.");
  }

  @AfterClass
  public void afterClass() {
    System.out.println("Testcase class is finished.");
  }

  @BeforeTest
  public void beforeTest() {
    System.out.println("Flight booking tests are started.");
  }

  @AfterTest
  public void afterTest() {
    System.out.println("Flight booking tests are finished.");
  }

  @BeforeSuite
  public void beforeSuite() {
    System.out.println("Mercury flight booking test project suite is started.");
  }

  @AfterSuite
  public void sendReport() {
    System.out.println("Mercury flight booking test project suite is executed and preparing to send test report...");
    SendEmailReport.sendPdfReport("sendFrom@gmail.com", "passwordhere", "sendTo@gmail.com", "Test report",
				"Report");
  }


}
