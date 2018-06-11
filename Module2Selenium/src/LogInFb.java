

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInFb {
	WebDriver driver;

	@Test(dataProvider = "testdata")
	public void FbLogIn(String name, String pwd) {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumResources\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demosite.center/wordpress/wp-login.php");

		driver.findElement(By.id("user_login")).sendKeys(name);

		driver.findElement(By.id("user_pass")).sendKeys(pwd);

		driver.findElement(By.id("wp-submit")).click();
	}

	@DataProvider(name = "testdata")
	public Object[][] inputTestData() throws Exception {

		Object data[][] = new Object[5][2];
		InputStream readExcel = new FileInputStream("D:\\inputdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(readExcel);
		XSSFSheet sheet = wb.getSheetAt(0);

		XSSFRow row;
		XSSFCell cell = null;

		int rCount = sheet.getLastRowNum();

		for (int i = 0; i <= rCount; i++) {
			row = sheet.getRow(i);
			int cCount = row.getLastCellNum();
			for (int j = 0; j < cCount; j++) {
				cell = row.getCell(j);
				data[i][j] = cell.getStringCellValue();
			}
		}
		return data;
	}

}
