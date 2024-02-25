package com.Automation.Pages.Home;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Pages.Base.BasePage;



public class HomePage extends BasePage{
	
	@FindBy(xpath ="//one-app-nav-bar-menu-item") WebElement studentDataRegistration;
	

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getTextFromStudentRegistrationFormText() {
		return getTextFromWebElement(studentDataRegistration, "stu regi form text");
	}

	private String getTextFromWebElement(WebElement studentDataRegistration2, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
	



