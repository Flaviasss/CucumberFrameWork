package com.SFDC.Cucumber.Stepdefns;

import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;
import com.Automation.Pages.Home.HomePage;
import com.Automation.Pages.Home.LoginPage;
import com.SFDC.Utilities.Log4JUtility;
import com.SFDC.Utilities.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SFDCloginStepdefination {
	protected static Logger log;
	public  WebDriver driver;
	protected static Log4JUtility logObject=Log4JUtility.getInstance();
	LoginPage login;
	HomePage home;
	
	
	public  void launchBrowser(String browserName) {
		switch(browserName) {
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			
			break;
		case "chrome":
		 WebDriverManager.chromedriver().setup();
	
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			break;
		}
		System.out.println(browserName+" browser opened");
	}
	
	public  void goToUrl(String url) {
		driver.get(url);
		log.info(url+ "is entered");
	}

	public  void closeBrowser() {
		driver.close();
		log.info("current browser closed");
	}
	
	@BeforeAll
	public static void setUpBeforeAllScenarios() {
		log=logObject.getLogger();
	}
	@Before
	public void setUpEachScenario() {
		
		launchBrowser("edge");
		
	}
	@After
	public void tearDown() {
		closeBrowser();
	}
	@AfterStep
	public void after_each_step(Scenario sc) {
		if(sc.isFailed()){
			
		}
	}
	@Given("User open SalesForce application")
	public void user_open_firebase_application() {
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationData");
		String url= appProp.getProperty("url");
		goToUrl(url);
		System.out.println("driver in baseTest="+driver);
	}

	@When("user on {string}")
	public void user_on(String page) {
		 if(page.equalsIgnoreCase("loginpage"))
		    	login=new LoginPage(driver);
		    else if(page.equalsIgnoreCase("homepage"))
		    	home=new HomePage(driver);
	}

	@When("User enters value into text box username as {string}")
	public void user_enters_value_into_text_box_username_as(String username) throws InterruptedException {
		login.enterUsername(username);
	}

	@When("User enters value into text box password as {string}")
	public void user_enters_value_into_text_box_password_as(String password) {
	    login.enterPassword(password);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		driver= login.clickButton();
	}
	
	@Then("verify we can see {string}")
	public void verify_page_title_as(String expectedText) {
		String actualText= home.getTextFromStudentRegistrationFormText();
		Assert.assertEquals(actualText, expectedText);
	}

	



	
}

