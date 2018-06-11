/**
 * 
 */
package pomassignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author M1035775
 *
 */
public class LocateElements {
	
	WebDriver driver;
	Actions myActions;
	
	public LocateElements(WebDriver driver) {
		this.driver = driver;
	}
	
	

	
	@FindBy(id="topNav1")
	@CacheLookup
	WebElement booksTab;
	
	@FindBy(xpath="//a[@href='/b/books/biography/_/N-29Z8q8Zsoc']")
	@CacheLookup
	WebElement biographyMenu;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/header/h1/span[2]/span[2]")
	@CacheLookup
	WebElement biograpgyText;
	
	@FindBy(xpath="//section[@id='hotBooksWithDesc_Bestsellers']/header/h2")
	@CacheLookup
	WebElement bestSellersText;
	
	@FindBy(xpath="//a[@class='icon-close-modal']")
	@CacheLookup
	WebElement cancelPopup;
	
	public void mouseOnBooksTab() {
		cancelPopup.click();
		myActions = new Actions(driver);
		myActions.moveToElement(booksTab).perform();
	}
	
	public void clickBiography() {
		biographyMenu.click();
	}
	
	public void textBiograpgy() {
		String txt = biograpgyText.getText();
		if(txt.equalsIgnoreCase("Biography")) {
			System.out.println(txt +" is displayed correctly.");
		}
	}
	
	public void textBestsellers() {
		String txt = bestSellersText.getText();
		if(txt.equalsIgnoreCase("Bestsellers")) {
			System.out.println(txt +" is displayed correctly.");
		}
	}
	

}
