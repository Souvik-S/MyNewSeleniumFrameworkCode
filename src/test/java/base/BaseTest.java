package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver = null;
	
	@BeforeSuite
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		Reporter.log("Chrome Driver setup is done");
	}
	
	@BeforeMethod
	public void driverInstanceSetup() {
		Reporter.log("Starting the Test Case execution");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Chrome Driver Instance is created");
		Reporter.log("Chrome Instance is maximized");
	}
	
	public void openURL(String url)
	{
		driver.get(url);
		Reporter.log("Url is opened : "+url);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
		Reporter.log("Closed the Chrome driver Instance");
	}
	
	@AfterSuite
	public void quitTest() {
		driver.quit();
		Reporter.log("Quitted the Chrome driver Instance");
	}

	public static WebDriver returnDriver() {
		return driver;
	}
}
