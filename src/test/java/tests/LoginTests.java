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

public class LoginTests extends BaseTest {
	
	String dataPath = "D:\\Eclipse_WorkSpace\\SeleniumFramework\\src\\test\\resources\\testdata\\loginData.properties";
	WebDriver driver;
	LoginPage loginpage;
	CommonFunctions commonFunction;
	HomePage homepage;
	
	public void testcaseinitialize() {	
		driver = returnDriver();
		 loginpage = new LoginPage(driver);
		 commonFunction = new CommonFunctions();
		 homepage = new HomePage(driver);
		}
	
	@Parameters({"url"})
	@Test(priority = 1)
	public void Test1(String url) throws InterruptedException, IOException {
		driverInstanceSetup();
		testcaseinitialize();
		openURL(url);
		loginpage.enterUsername(PropertyReadWrite.readProperty(dataPath, "username1"));
		loginpage.enterPassword(PropertyReadWrite.readProperty(dataPath, "password"));
		loginpage.clickLogin();
		commonFunction.waitForTime(3);
		homepage.verifyHomePageLoaded();
	}
	
	
	@Parameters({"url"})
	@Test(priority = 2)
	public void Test2(String url) throws InterruptedException, IOException {
		driverInstanceSetup();
		testcaseinitialize();
		openURL(url);
		loginpage.enterUsername(PropertyReadWrite.readProperty(dataPath, "username1"));
		loginpage.enterPassword(PropertyReadWrite.readProperty(dataPath, "password2"));
		loginpage.clickLogin();
		commonFunction.waitForTime(3);
		loginpage.verifyWrongUserNamePassword();
	}
	
	
	@Parameters({"url"})
	@Test(priority = 3)
	public void Test3(String url) throws InterruptedException, IOException {
		driverInstanceSetup();
		testcaseinitialize();
		openURL(url);
		loginpage.enterUsername(PropertyReadWrite.readProperty(dataPath, "username2"));
		loginpage.enterPassword(PropertyReadWrite.readProperty(dataPath, "password"));
		loginpage.clickLogin();
		commonFunction.waitForTime(3);
		loginpage.verifylockedUser();
	}

}
