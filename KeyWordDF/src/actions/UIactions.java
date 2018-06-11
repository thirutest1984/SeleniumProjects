package actions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIactions {
	
	WebDriver driver;
	
	public UIactions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void perform(Properties p,String keyword,String element,String locator,String value) throws Exception {
		
		switch (keyword.toUpperCase()) {
		
		case "GOTOURL":
			driver.get(p.getProperty(value));			
			break;
			
		case "SETTEXT":
			driver.findElement(this.getObject(p,element,locator)).sendKeys(value);
			break;
			
		case "CLICK":
			driver.findElement(this.getObject(p,element,locator)).click();
			break;

		default:
			
			break;
		}
	}
	
	public By getObject(Properties p,String element,String locator) throws Exception {
		
        //Find by id
        if(locator.equalsIgnoreCase("ID")){
            
            return By.id(p.getProperty(element));
        }
        
		//Find by xpath
        else if(locator.equalsIgnoreCase("XPATH")){
            
            return By.xpath(p.getProperty(element));
        }
        
        //find by name
        else if(locator.equalsIgnoreCase("NAME")){
            
            return By.name(p.getProperty(element));   
        }
        else
        {
            throw new Exception("Wrong object type");
        }
	}

}
