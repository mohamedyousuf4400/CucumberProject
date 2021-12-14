                          
                                      //Login.feature Feature file

Feature: This is the login feature for OrangeHRM
Scenario: This is the Login scenario
Given The user is on the login page
When The user enters the valid username and password
And The user click the Login button
Then The user should be navigate to dashboard page

***************************************************************************************************************************************************

                                       //LoginRunnerClass.java Runner clas
                                       
  package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature/LogIn.feature",glue = "stepDefinations")
public class LogInRunnerClass {

}

*******************************************************************************************************************************************************

                                        //LoginStepDef.java Step Defination class
                                        
  package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageDefination {
	
	WebDriver driver;

	@Given("^The user is on the login page$")
	public void the_user_is_on_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("^The user enters the valid username and password$")
	public void the_user_enters_the_valid_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
	}

	@When("^The user click the Login button$")
	public void the_user_click_the_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}

	@Then("^The user should be navigate to dashboard page$")
	public void the_user_should_be_navigate_to_dashboard_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Boolean Result = driver.findElement(By.partialLinkText("Dashboard")).isDisplayed();
		Assert.assertTrue(Result);
	}

}
