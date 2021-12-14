                                       // Feature File for opengoogle.feature

Feature: open google.com feature
Scenario: open google website and search
 Given user is entering google.com
 When user clicks the search box 
 And types the search term as "Gmail login"
 Then the user click the return button
 Then the user see the search result
  **********************************************************************************************************************************
                                        // Runner class for OpenGoogleRunnerClass.java
  
package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = "feature/OpenGoogle.feature",glue = "stepDefinations")

public class OpenGoogleRunnerClass {

}

****************************************************************************************************************************************
                                        // Step Defination class for OpenGoogleStepDefClass.java

package stepDefinations;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenGoogleDefination {

	WebDriver driver;
	
	 @Given("^user is entering google\\.com$")
	 public void user_is_entering_google_com(){
	 
	  driver= new ChromeDriver();
	  driver.get("http://www.google.com");
	  driver.manage().window().maximize();
	 }
	
	 @When("^user clicks the search box$")
	 public void user_clicks_the_search_box() throws Throwable {
	  // Write code here that turns the phrase above into concrete actions
	  driver.findElement(By.name("q")).click();
	 }

	 @When("^types the search term as \"([^\"]*)\"$")
	 public void types_the_search_term_as(String searchTerm) throws Throwable {
	  // Write code here that turns the phrase above into concrete actions
	  driver.findElement(By.name("q")).sendKeys(searchTerm);
	 }


	 @Then("^the user click the return button$") public void
	 the_user_click_the_return_button() throws Throwable {
		 // Write code here that turns the phrase above into concrete actions
	 driver.findElement(By.name("q")).sendKeys(Keys.ENTER); }
	 
	 @Then("^the user see the search result$")
	 public void the_user_see_the_search_result() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 boolean result=driver.findElement(By.partialLinkText("Gmail")).isDisplayed();
		  if(true==result){
		   System.out.println("search results came");
		  }else{
		   System.out.println("Some error");
		  }
		 }
	 }

