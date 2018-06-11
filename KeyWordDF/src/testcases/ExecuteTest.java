package testcases;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actions.ReadObject;
import actions.UIactions;
import excelhandle.ReadExcel;

public class ExecuteTest {

	WebDriver driver=null;

	@Test(dataProvider = "inputtestdata")
	public void testLogin(String testcaseName, String keyword, String element, String locator, String value)
			throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");

	    if(testcaseName!=null&&testcaseName.length()!=0){
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        } 
		ReadObject readObj = new ReadObject();
		Properties prop = readObj.getObjectRepository();
		UIactions action = new UIactions(driver);
		action.perform(prop, keyword, element, locator, value);

	}

	@DataProvider(name = "inputtestdata")
	public Object[][] getDataFromDataProvider() throws IOException {
		Object[][] object = null;
		ReadExcel excelFile = new ReadExcel();
		Sheet rSheet = excelFile.readExcelFile("D:\\inputdata.xlsx", "Keyword");

		int rCount = rSheet.getPhysicalNumberOfRows();
		object = new Object[rCount][5];
		for (int i = 1; i < rCount; i++) {
			XSSFRow row = (XSSFRow) rSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				XSSFCell cell = row.getCell(j);
				if(cell == null) {
					continue;
				} 
				object[i][j] = cell.getStringCellValue();
			}
		}
		return object;
	}
}
