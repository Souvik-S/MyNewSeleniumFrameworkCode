package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;

public class ProductDescriptionPage{
	
	WebDriver driver;
	
	public ProductDescriptionPage(WebDriver driver){
		this.driver = driver;
	}
	
	By backToProductsText = By.id("back-to-products");
	By addToCart_Button = By.xpath("//button[text()='Add to cart']");
	By itemPrice = By.xpath("//div[@class='inventory_details_price']");
	By remove_Button = By.xpath("//button[text()='Remove']");
	
	
	
	public void verifyProductDescriptionPageLoaded() {
		Assert.assertEquals(driver.findElement(backToProductsText).isDisplayed(), true);
		Reporter.log("Verified Loading of Product Desciption Page successfully");
	}

	public void verifyAddToCartIsPresent() {
		Assert.assertEquals(driver.findElement(addToCart_Button).isDisplayed(), true);
		Reporter.log("Add to Cart button is Present");
	}
	
	public void verifyItemPriceIsValid() {
		String price = driver.findElement(itemPrice).getText();
		price = price.substring(1); 
		Assert.assertEquals(Float.parseFloat(price)>0.00, true);
		Reporter.log("Price of the product is > 0 and is valid");
	}
	
	public void addToCart() {
		driver.findElement(addToCart_Button).click();
		Reporter.log("Clicked on Add to Cart");
	}
	
	public void verifyRemoveButtonIsPresent() {
		Assert.assertEquals(driver.findElement(remove_Button).isDisplayed(), true);
		Reporter.log("Remove button is Present");
	}

}
