                                  
                                        //Loginwithdata.feature Feature File

Feature: This is the login feature for OrangeHRM with Data
Scenario: This is the Login with data scenario
Given  user is on  login page
When user enters the valid credential "Admin" and "admin123"
And  user clicks Login button
Then user is navigate to dashboard page

*******************************************************************************************************************************************************************

                                        //loginwithdata runner class.java Runner Class
                                        
  package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature/LogInWithData.feature",glue = "stepDefinations")
public class LoginDataRunner {

}

*************************************************************************************************************************************************************************

                                        //loginwithdata step def class.java Step Defination Class
                                        
  package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LogInWithDataDef {
	
	WebDriver driver;
	
	@Given("^user is on  login page$")
	public void user_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("^user enters the valid credential \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_valid_credential_and(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
	}

	@When("^user clicks Login button$")
	public void user_clicks_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}

	@Then("^user is navigate to dashboard page$")
	public void user_is_navigate_to_dashboard_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Boolean Result = driver.findElement(By.partialLinkText("Dashboard")).isDisplayed();
		Assert.assertTrue(Result);
	}


}
