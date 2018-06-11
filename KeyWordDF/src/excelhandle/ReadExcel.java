package excelhandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public Sheet readExcelFile(String filePath,String sheetName) throws IOException {
		
		File file = new File(filePath);
		
		FileInputStream inputstream = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		
		Sheet sheet = wb.getSheet(sheetName);
		
		return sheet;
		
	}

}
