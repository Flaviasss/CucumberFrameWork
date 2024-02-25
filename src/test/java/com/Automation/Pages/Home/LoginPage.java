package com.Automation.Pages.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Pages.Base.BasePage;

public class LoginPage extends BasePage {
	
	
	@FindBy(xpath="//input[@name='username']")WebElement userNameElement;
	@FindBy(xpath="//input[@name='pw']")WebElement password;
	@FindBy(xpath="//input[@id='Login']")WebElement loginButton;
	@FindBy(xpath="//input[@class='r4 fl mr8']")WebElement rememberMeCheckbox ;
	@FindBy(className="logout") WebElement logout;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	
	public void enterUsername(String usernamedata) throws InterruptedException {
		enterText(userNameElement, usernamedata, "username field");
		Thread.sleep(5000);
	}
	
	public void enterPassword(String passworddata) {
		enterText(password, passworddata, "password field");
	}
	
	private void enterText(WebElement password2, String passworddata, String string) {
		// TODO Auto-generated method stub
		
	}


	public WebDriver clickButton() {
		clickElement(loginButton,"login button");
		return driver;
	}
	
	private void clickElement(WebElement loginButton2, String string) {
		// TODO Auto-generated method stub
		
	}


	public String getTitleOfThePAge() {
		//waitUntilPageLoads();
		return getPageTitle();
	}


	private String getPageTitle() {
		// TODO Auto-generated method stub
		return null;
	}




}
	
	

