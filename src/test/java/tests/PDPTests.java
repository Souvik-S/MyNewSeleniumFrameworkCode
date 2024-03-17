package tests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDescriptionPage;
import utils.CommonFunctions;
import utils.PropertyReadWrite;

public class PDPTests extends BaseTest {
	
	String dataPath = "D:\\Eclipse_WorkSpace\\SeleniumFramework\\src\\test\\resources\\testdata\\loginData.properties";
	
	
	@Parameters({"url"})
	@Test
	public void Test1(String url) throws InterruptedException, IOException {
		LoginPage loginpage = new LoginPage();
		CommonFunctions commonFunction = new CommonFunctions();
		HomePage homepage = new HomePage();
		ProductDescriptionPage pdp = new ProductDescriptionPage();
		
		
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
		
		
	}

}
