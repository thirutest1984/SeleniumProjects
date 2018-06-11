package common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeywordUtility {

	CommonDriver oDriver;
	

	public KeywordUtility() {
		oDriver = new CommonDriver();
	}

	public String performAction(String sActionName, By oBy, String sValue) {
		sActionName = sActionName.trim();

		if (sActionName.isEmpty()) {
			return "";
		}

		if (sActionName.equalsIgnoreCase("click")) {
			oDriver.clickElement(oBy);

			return "";
		}

		if (sActionName.equalsIgnoreCase("openbrowser")) {

			oDriver.openBrowser(sValue, "about:blank");

			return "";
		}
		
		if (sActionName.equalsIgnoreCase("setPageLoadTimeOut")) {

			oDriver.setPageLoadTimeOut(Long.valueOf(sValue));

			return "";
		}

		if (sActionName.equalsIgnoreCase("setElementDetectionTimeout")) {

			oDriver.setElementDetectionTimeOut(Long.valueOf(sValue));

			return "";
		}

		if (sActionName.equalsIgnoreCase("threadsleep")) {

			try {
				Thread.sleep(Long.parseLong(sValue));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "";
		}

		if (sActionName.equalsIgnoreCase("navigateToUrl")) {

			oDriver.getDriver().get(sValue);

			return "";
		}

		if (sActionName.equalsIgnoreCase("navigateBack")) {

			oDriver.getDriver().navigate().back();

			return "";
		}

		if (sActionName.equalsIgnoreCase("navigateForward")) {

			oDriver.getDriver().navigate().forward();

			return "";
		}
		
		if (sActionName.equalsIgnoreCase("navigateRefresh")) {

			oDriver.getDriver().navigate().refresh();;

			return "";
		}

		if (sActionName.equalsIgnoreCase("closeAllBrowser")) {

			oDriver.getDriver().quit();

			return "";
		}

		if (sActionName.equalsIgnoreCase("closeCurrentBrowser")) {

			oDriver.getDriver().close();

			return "";
		}

		if (sActionName.equalsIgnoreCase("waitTillElementIsVisible")) {
			
			oDriver.waitTillElementIsVisible(oBy, Long.valueOf(sValue));

			return "";
		}

		if (sActionName.equalsIgnoreCase("waitTillElementIsClickable")) {
			
			oDriver.waitTillElementIsVisible(oBy, Long.valueOf(sValue));

			return "";
		}

		if (sActionName.equalsIgnoreCase("savepagesnapshot")) {

			String returnvalue = oDriver.savePageSnapshot(sValue);

			return returnvalue;
		}

		if (sActionName.equalsIgnoreCase("submit")) {

			oDriver.getDriver().findElement(oBy).submit();
			return "";
		}
		if (sActionName.equalsIgnoreCase("clear")) {

			oDriver.getDriver().findElement(oBy).clear();
			return "";
		}

		if (sActionName.equalsIgnoreCase("selectParentWindow")) {

			oDriver.getDriver()
					.switchTo()
					.window(oDriver.getDriver().getWindowHandles().toArray()[0].toString());
			return "";
		}

		if (sActionName.equalsIgnoreCase("acceptAlert")) {

			oDriver.getDriver().switchTo().alert().accept();
			return "";
		}

		if (sActionName.equalsIgnoreCase("rejectAlert")) {

			oDriver.getDriver().switchTo().alert().dismiss();
			return "";
		}

		if (sActionName.equalsIgnoreCase("selectDefaultframe")) {
			oDriver.getDriver().switchTo().defaultContent();
			return "";
		}

		if (sActionName.equalsIgnoreCase("gettext")) {
			return oDriver.getDriver().findElement(oBy).getText();

		}

		if (sActionName.equalsIgnoreCase("getTextboxText")) {

			if (oDriver.getDriver().findElement(oBy).getAttribute("value")
					.equals(sValue)) {
				return "pass";
			} else {
				return "error";
			}
		}

		if (sActionName.equalsIgnoreCase("verifytext")) {

			if (oDriver.getDriver().findElement(oBy).getText().equals(sValue)) {
				System.out.println("Expected: "+sValue+"Actual: "+oDriver.getDriver().findElement(oBy).getText());
				return "pass";
			} else {
				return "error";
			}

		}

		if (sActionName.equalsIgnoreCase("getTitle")) {
			return oDriver.getDriver().getTitle();

		}

		if (sActionName.equalsIgnoreCase("verifyTitle")) {
			if (oDriver.getDriver().getTitle().equals(sValue)) {
				return "pass";
			} else {
				return "error";
			}

		}

		if (sActionName.equalsIgnoreCase("getUrl")) {
			return oDriver.getDriver().getCurrentUrl();

		}
		
		if (sActionName.equalsIgnoreCase("verifyUrl")) {
			if (oDriver.getDriver().getCurrentUrl().equals(sValue)) {
				return "pass";
			} else {
				return "error";
			}

		}

		if (sActionName.equalsIgnoreCase("setText")) {
			oDriver.setText(oBy, sValue);
			return "";
		}

		if (sActionName.equalsIgnoreCase("getstatus")) {
			return String.valueOf(oDriver.getDriver().findElement(oBy)
					.isSelected());

		}

		if (sActionName.equalsIgnoreCase("getSelectedItem")) {
			Select olist;
			WebElement oElement;

			oElement = oDriver.getDriver().findElement(oBy);
			olist = new Select(oElement);
			return olist.getFirstSelectedOption().getText();

		}

		if (sActionName.equalsIgnoreCase("selectitembytext")) {
			oDriver.selectItemInListBox(oBy, sValue);
			return "";

		}

		if (sActionName.equalsIgnoreCase("selectitembyvalue")) {
			Select olist;
			WebElement oElement;

			oElement = oDriver.getDriver().findElement(oBy);
			olist = new Select(oElement);
			olist.selectByValue(sValue);
			return "";

		}

		if (sActionName.equalsIgnoreCase("getItemsCount")) {
			Select olist;
			WebElement oElement;

			oElement = oDriver.getDriver().findElement(oBy);
			olist = new Select(oElement);

			return String.valueOf(olist.getOptions().size());

		}

		if (sActionName.equalsIgnoreCase("isdisplayed")) {
			if(oDriver.getDriver().findElement(oBy).isDisplayed()){
				return sValue+" is present";
			}
			else{
				return sValue+" is not present";
			}
		}

		if (sActionName.equalsIgnoreCase("isenabled")) {
			oDriver.getDriver().findElement(oBy).isEnabled();
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("switchToNewWindow")) {
			oDriver.switchToWindow(Integer.parseInt(sValue));
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("scrollTo")) {
			oDriver.scrollTo(oBy);
			return "";
		}

		return "Error: Unknown keyword..";

	}

}
