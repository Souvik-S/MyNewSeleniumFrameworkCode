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

public class CheckoutOverviewPage{
	
	WebDriver driver;
	
	public CheckoutOverviewPage(){
		driver = BaseTest.returnDriver();
	}
	
	By checkoutOverviewPageTitle = By.xpath("//span[text()='Checkout: Overview']");
	By checkoutOverviewPageProduct = By.xpath("//div[@class='inventory_item_name']");
	By checkoutOverviewPageProductPrice = By.xpath("//div[@class='inventory_item_price']");
	By checkoutOverviewPage_itemTotal = By.xpath("//div[@class='summary_subtotal_label']");
	By checkoutOverviewPage_tax = By.xpath("//div[@class='summary_tax_label']");
	By checkoutOverviewPage_totalPrice = By.xpath("//div[@class='summary_info_label summary_total_label']");
	By checkoutOverviewPage_finishButton = By.id("finish");
	

	public void verifyCheckoutOverviewPageLoaded() {
		Assert.assertEquals(driver.findElement(checkoutOverviewPageTitle).isDisplayed(), true);
		Reporter.log("Verified Loading of Checkout Overview Page successfully");
	}
	
	public void verifyCheckoutItemName(String productname) {
		Assert.assertEquals(driver.findElement(checkoutOverviewPageProduct).isDisplayed(), true);
		Assert.assertEquals((driver.findElement(checkoutOverviewPageProduct).getText()).contains(productname), true);
		Reporter.log("Verified Checkout Overview Page product");
	}
	
	public void verifyCheckoutItemPrice(String price) {
		Assert.assertEquals(driver.findElement(checkoutOverviewPageProductPrice).isDisplayed(), true);
		Assert.assertEquals((driver.findElement(checkoutOverviewPageProductPrice).getText()).contains(price), true);
		Reporter.log("Verified Checkout Overview Page product price");
	}
	
	public void verifyTotalPrice() {
		String itemTotal = driver.findElement(checkoutOverviewPage_itemTotal).getText();
		String tax = driver.findElement(checkoutOverviewPage_tax).getText();
		itemTotal = itemTotal.substring(itemTotal.indexOf('$')+1);
		tax = tax.substring(tax.indexOf('$')+1);
		float totalPrice = Float.parseFloat(itemTotal)+Float.parseFloat(tax);
		Assert.assertEquals((driver.findElement(checkoutOverviewPage_totalPrice).getText()).contains(""+totalPrice), true);
		Reporter.log("Verified Total Price in  Checkout Overview Page");
	}
	
	public void clickFinishButton() {
		WebElement ele = driver.findElement(checkoutOverviewPage_finishButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",ele);
		 driver.findElement(checkoutOverviewPage_finishButton).click();
		Reporter.log("Clicked on Finish Button");
	}

}
