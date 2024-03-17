package tests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDescriptionPage;
import utils.CommonFunctions;
import utils.PropertyReadWrite;

public class CheckoutCompleteTests extends BaseTest {
	
	String dataPath = "D:\\Eclipse_WorkSpace\\SeleniumFramework\\src\\test\\resources\\testdata\\loginData.properties";
	
	
	@Parameters({"url"})
	@Test
	public void Test1(String url) throws InterruptedException, IOException {
		LoginPage loginpage = new LoginPage();
		CommonFunctions commonFunction = new CommonFunctions();
		HomePage homepage = new HomePage();
		ProductDescriptionPage pdp = new ProductDescriptionPage();
		CartPage cartpage = new CartPage();
		CheckoutPage checkoutpage = new CheckoutPage();
		CheckoutOverviewPage checkoutoverviewpage = new CheckoutOverviewPage();
		CheckoutCompletePage checkoutcompletepage = new CheckoutCompletePage();
		
		
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
		commonFunction.waitForTime(3);
		checkoutoverviewpage.verifyCheckoutOverviewPageLoaded();
		checkoutoverviewpage.verifyCheckoutItemName("Sauce Labs Backpack");
		checkoutoverviewpage.verifyCheckoutItemPrice("29.99");
		checkoutoverviewpage.verifyTotalPrice();
		checkoutoverviewpage.clickFinishButton();
		commonFunction.waitForTime(3);
		checkoutcompletepage.verifyCheckoutCompletePageLoaded();
		checkoutcompletepage.verifyOrderPlacement();
	}

}
