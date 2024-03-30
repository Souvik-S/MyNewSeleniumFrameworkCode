package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;

public class CheckoutPage{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver){
		this.driver = driver;
	}
	
	By checkoutPageTitle = By.xpath("//span[text()='Checkout: Your Information']");
	By checkoutPage_firstname = By.id("first-name");
	By checkoutPage_lastname = By.id("last-name");
	By checkoutPage_pincode = By.id("postal-code");
	By checkoutPage_continueButton = By.id("continue");
	

	public void verifyCheckoutPageLoaded() {
		Assert.assertEquals(driver.findElement(checkoutPageTitle).isDisplayed(), true);
		Reporter.log("Verified Loading of Checkout Page successfully");
	}
	
	public void enterCheckoutDetails(String firstname, String lastname, String pincode) {
		driver.findElement(checkoutPage_firstname).sendKeys(firstname);
		driver.findElement(checkoutPage_lastname).sendKeys(lastname);
		driver.findElement(checkoutPage_pincode).sendKeys(pincode);
		Reporter.log("Entered Customer details in the Checkoutpage");
	}
	
	public void clickContinueButton() {
		driver.findElement(checkoutPage_continueButton).click();
		Reporter.log("Clicked on Continue Button");
	}
	
	

}
