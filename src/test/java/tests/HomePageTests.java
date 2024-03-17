package tests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonFunctions;
import utils.PropertyReadWrite;

public class HomePageTests extends BaseTest {
	
	String dataPath = "D:\\Eclipse_WorkSpace\\SeleniumFramework\\src\\test\\resources\\testdata\\loginData.properties";
	
	
	@Parameters({"url"})
	//@Test(priority = 1)
	public void Test1(String url) throws InterruptedException, IOException {
		LoginPage loginpage = new LoginPage();
		CommonFunctions commonFunction = new CommonFunctions();
		HomePage homepage = new HomePage();
		
		
		openURL(url);
		loginpage.enterUsername(PropertyReadWrite.readProperty(dataPath, "username1"));
		loginpage.enterPassword(PropertyReadWrite.readProperty(dataPath, "password"));
		loginpage.clickLogin();
		commonFunction.waitForTime(3);
		homepage.verifyHomePageLoaded();
		homepage.filterProducts(PropertyReadWrite.readProperty(dataPath, "filterChoice"));
		commonFunction.waitForTime(2);
		homepage.verifyItemPrice(PropertyReadWrite.readProperty(dataPath, "firstItemPrice"));
	}
	
	@Parameters({"url"})
	@Test(priority = 1)
	public void Test2(String url) throws InterruptedException, IOException {
		LoginPage loginpage = new LoginPage();
		CommonFunctions commonFunction = new CommonFunctions();
		HomePage homepage = new HomePage();
		
		
		openURL(url);
		loginpage.enterUsername(PropertyReadWrite.readProperty(dataPath, "username1"));
		loginpage.enterPassword(PropertyReadWrite.readProperty(dataPath, "password"));
		loginpage.clickLogin();
		commonFunction.waitForTime(3);
		homepage.verifyHomePageLoaded();
		homepage.verifyProductIsPresent("Sauce Labs Backpack");
		homepage.verifyAddToCartIsPresent();
		homepage.verifyItemPriceIsValid("Sauce Labs Backpack");
	}

}
