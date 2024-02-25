package  com.SFDC.Cucumber.Runnerfiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/SalesForceLogin.feature"},
		glue= {"com.SFDC.Cucumber.Stepdefns"},
		monochrome = true,
		dryRun = false,
				plugin = {"pretty","html:target/cucumber-pom-selenium.html"}
		
		
		)
public class SFDCLoginRunner extends AbstractTestNGCucumberTests{
	
	

}
	


	

