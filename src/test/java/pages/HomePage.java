package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;

public class HomePage{
	
	WebDriver driver;
	
	public HomePage(){
		driver = BaseTest.returnDriver();
	}
	
	By homePageTitle = By.xpath("//div[text()='Swag Labs']");
	By productFilter = By.className("product_sort_container");
	By firstItemPrice = By.xpath("(//div[@class='inventory_item_price'])[1]");
	By addToCartButtonBackPack = By.id("add-to-cart-sauce-labs-backpack");
	
	
	public void verifyHomePageLoaded() {
		Assert.assertEquals(driver.findElement(homePageTitle).isDisplayed(), true);
		Reporter.log("Verified Loading of Home Page successfully");
	}
	
	public void filterProducts(String value) {
		Select se = new Select(driver.findElement(productFilter));
		se.selectByVisibleText(value);
		Reporter.log("Filtered the products by : "+value);
	}
	
	public void verifyItemPrice(String price) {
		Assert.assertEquals((driver.findElement(firstItemPrice).getText()).contains(price), true);
		Reporter.log("Verified price successfully as : "+price);
	}
	
	public void verifyProductIsPresent(String productname) {
		String xpath = "//div[@class='inventory_item_name '][text()='"+productname+"']";
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).isDisplayed(), true);
		Reporter.log("Product is present named : "+productname);
	}
	
	public void verifyAddToCartIsPresent() {
		Assert.assertEquals(driver.findElement(addToCartButtonBackPack).isDisplayed(), true);
		Reporter.log("Add to Cart button for BackPack is Present");
	}
	
	public void verifyItemPriceIsValid(String productname) {
		String xpath = "//div[text()='"+productname+"']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']";
		String price = driver.findElement(By.xpath(xpath)).getText();
		price = price.substring(1); 
		Assert.assertEquals(Float.parseFloat(price)>0.00, true);
		Reporter.log("Price of the product is > 0 and is valid");
	}
	
	public void openProductDescriptionForItem(String productname) {
		String xpath = "//div[@class='inventory_item_name '][text()='"+productname+"']";
		driver.findElement(By.xpath(xpath)).click();
		Reporter.log("Clicked on product for opening Product description page : "+productname);
	}

}
