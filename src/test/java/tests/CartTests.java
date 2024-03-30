package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDescriptionPage;
import utils.CommonFunctions;
import utils.PropertyReadWrite;

public class CartTests extends BaseTest {
	
	String dataPath = "D:\\Eclipse_WorkSpace\\SeleniumFramework\\src\\test\\resources\\testdata\\loginData.properties";
	WebDriver driver;
	
	
	@Parameters({"url"})
	@Test
	public void Test1(String url) throws InterruptedException, IOException {
		driver = returnDriver();
		LoginPage loginpage = new LoginPage(driver);
		CommonFunctions commonFunction = new CommonFunctions();
		HomePage homepage = new HomePage(driver);
		ProductDescriptionPage pdp = new ProductDescriptionPage(driver);
		CartPage cartpage = new CartPage(driver);
		
		
		openURL(url);
		loginpage.enterUsername(PropertyReadWrite.readProperty(dataPath, "username1"));
		loginpage.enterPassword(PropertyReadWrite.readProperty(dataPath, "password"));
		loginpage.clickLogin();
		commonFunction.waitForTime(3);
		homepage.verifyHomePageLoaded();
		homepage.openProductDescriptionForItem("Sauce Labs Backpack");
		commonFunction.waitForTime(3);
		pdp.verifyProductDescriptionPageLoaded();
		pdp.verifyAddToCartIsPresent();
		pdp.verifyItemPriceIsValid();
		pdp.addToCart();
		commonFunction.waitForTime(2);
		pdp.verifyRemoveButtonIsPresent();
		cartpage.navigateToCartPage();
		commonFunction.waitForTime(3);
		cartpage.verifyCartPageLoaded();
		cartpage.verifyCartItem("Sauce Labs Backpack");
		cartpage.verifyCartItemPrice("29.99");
	}

}
