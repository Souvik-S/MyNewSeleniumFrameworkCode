package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;

public class CheckoutCompletePage{
	
	WebDriver driver;
	
	public CheckoutCompletePage(){
		driver = BaseTest.returnDriver();
	}
	
	By checkoutOverviewPageTitle = By.xpath("//span[text()='Checkout: Complete!']");
	By checkoutOverviewPage_orderPlaceText = By.xpath("//h2[text()='Thank you for your order!']");
	

	public void verifyCheckoutCompletePageLoaded() {
		Assert.assertEquals(driver.findElement(checkoutOverviewPageTitle).isDisplayed(), true);
		Reporter.log("Verified Loading of Checkout Complete Page successfully");
	}
	
	public void verifyOrderPlacement() {
		Assert.assertEquals(driver.findElement(checkoutOverviewPage_orderPlaceText).isDisplayed(), true);
		Reporter.log("Verified Checkout Overview Page product");
	}
	
}
