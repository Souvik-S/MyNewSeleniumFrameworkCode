package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDescriptionPage;
import utils.CommonFunctions;
import utils.PropertyReadWrite;

public class CheckoutTests extends BaseTest {
	
	String dataPath = "D:\\Eclipse_WorkSpace\\SeleniumFramework\\src\\test\\resources\\testdata\\loginData.properties";
	WebDriver driver;
	LoginPage loginpage;
	CommonFunctions commonFunction;
	HomePage homepage;
	ProductDescriptionPage pdp;
	CartPage cartpage;
	CheckoutPage checkoutpage;
	
	public void testcaseinitialize() {	
		driver = returnDriver();
		 loginpage = new LoginPage(driver);
		 commonFunction = new CommonFunctions();
		 homepage = new HomePage(driver);
		 pdp = new ProductDescriptionPage(driver);
		 cartpage = new CartPage(driver);
		 checkoutpage = new CheckoutPage(driver);
		}
	
	
	@Parameters({"url"})
	@Test
	public void Test1(String url) throws InterruptedException, IOException {
		driverInstanceSetup();
		testcaseinitialize();
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
		cartpage.navigateToCheckoutPage();
		commonFunction.waitForTime(3);
		checkoutpage.verifyCheckoutPageLoaded();
		checkoutpage.enterCheckoutDetails(PropertyReadWrite.readProperty(dataPath, "firstname"),
					PropertyReadWrite.readProperty(dataPath, "lastname"),
					PropertyReadWrite.readProperty(dataPath, "pincode"));
		checkoutpage.clickContinueButton();
		
	}

}
