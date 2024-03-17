package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;

public class CartPage{
	
	WebDriver driver;
	
	public CartPage(){
		driver = BaseTest.returnDriver();
	}
	
	By navigateToCart = By.xpath("//a[@class='shopping_cart_link']");
	By cartPageTitle = By.xpath("//span[text()='Your Cart']");
	By cartPageProduct = By.xpath("//div[@class='inventory_item_name']");
	By cartPageProductPrice = By.xpath("//div[@class='inventory_item_price']");
	By navigateToCheckout = By.id("checkout");
	
	public void navigateToCartPage() {
		driver.findElement(navigateToCart).click();
		Reporter.log("Navigating to Cart Page");
	}

	public void verifyCartPageLoaded() {
		Assert.assertEquals(driver.findElement(cartPageTitle).isDisplayed(), true);
		Reporter.log("Verified Loading of Cart Page successfully");
	}
	
	public void verifyCartItem(String productname) {
		Assert.assertEquals(driver.findElement(cartPageProduct).isDisplayed(), true);
		Assert.assertEquals((driver.findElement(cartPageProduct).getText()).contains(productname), true);
		Reporter.log("Verified Cart Page product");
	}
	
	public void verifyCartItemPrice(String price) {
		Assert.assertEquals(driver.findElement(cartPageProductPrice).isDisplayed(), true);
		Assert.assertEquals((driver.findElement(cartPageProductPrice).getText()).contains(price), true);
		Reporter.log("Verified Cart Page product price");
	}
	
	public void navigateToCheckoutPage() {
		driver.findElement(navigateToCheckout).click();
		Reporter.log("Navigating to Checkout Page");
	}
	

}
