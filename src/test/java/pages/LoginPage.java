package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	By userName = By.id("user-name");
	By userPassword = By.id("password");
	By loginButton = By.id("login-button");
	By wrongUsernamePasswordText = By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");
	By lockedUserText = By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']");
	
	
	public void enterUsername(String username) {
		driver.findElement(userName).sendKeys(username);
		Reporter.log("Entered the username as : "+username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(userPassword).sendKeys(password);
		Reporter.log("Entered the password as : "+password);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
		Reporter.log("Clicked on Login Button");
	}
	
	public void verifyWrongUserNamePassword() {
		Assert.assertEquals(driver.findElement(wrongUsernamePasswordText).isDisplayed(), true);
		Reporter.log("Verified Display of Wrong Username and Password");
	}
	
	public void verifylockedUser() {
		Assert.assertEquals(driver.findElement(lockedUserText).isDisplayed(), true);
		Reporter.log("Verified Locked User");
	}

}
