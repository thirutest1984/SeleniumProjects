package mercury.bookflight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FindFlightPage {

	WebDriver driver;

	public FindFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@value='roundtrip']")
	@CacheLookup
	WebElement journeyTrip;

	@FindBy(how = How.XPATH, using = "//select[@name='passCount']")
	@CacheLookup
	WebElement pCount;

	@FindBy(how = How.XPATH, using = "//select[@name='fromPort']")
	@CacheLookup
	WebElement startPlace;

	@FindBy(how = How.XPATH, using = "//select[@name='fromMonth']")
	@CacheLookup
	WebElement startMonth;

	@FindBy(how = How.XPATH, using = "//select[@name='fromDay']")
	@CacheLookup
	WebElement startDay;

	@FindBy(how = How.XPATH, using = "//select[@name='toPort']")
	@CacheLookup
	WebElement endPlace;

	@FindBy(how = How.XPATH, using = "//select[@name='toMonth']")
	@CacheLookup
	WebElement returnMonth;

	@FindBy(how = How.XPATH, using = "//select[@name='toDay']")
	@CacheLookup
	WebElement returnDay;

	@FindBy(how = How.XPATH, using = "//input[@value='Business']")
	@CacheLookup
	WebElement businessServiceClass;

	@FindBy(how = How.XPATH, using = "//select[@name='airline']")
	@CacheLookup
	WebElement favAirline;

	@FindBy(how = How.XPATH, using = "//input[@name='findFlights']")
	@CacheLookup
	WebElement findFlightsDoneButton;

	public void roundTripJourney() {
		journeyTrip.click();
	}

	public void passengerCount(String count) {
		Select passCount = new Select(pCount);
		passCount.selectByValue(count);
	}

	public void departingFrom(String city) {
		Select depart = new Select(startPlace);
		depart.selectByValue(city);
	}

	public void departingMonth(String month) {
		Select dm = new Select(startMonth);
		dm.selectByValue(month);
	}

	public void departingDay(String day) {
		Select dd = new Select(startDay);
		dd.selectByValue(day);
	}

	public void arrivingIn(String city) {
		Select destination = new Select(endPlace);
		destination.selectByValue(city);
	}

	public void returningMonth(String month) {
		Select rm = new Select(returnMonth);
		rm.selectByValue(month);
	}

	public void returningDay(String day) {
		Select rd = new Select(returnDay);
		rd.selectByValue(day);
	}

	public void businessServiceClass() {
		businessServiceClass.click();
	}

	public void airLinePreference(String airline) {
		Select apref = new Select(favAirline);
		apref.selectByVisibleText(airline);
	}

	public void clickOnFindFlightsFinishButton() {
		findFlightsDoneButton.click();
	}
}
