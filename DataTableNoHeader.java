
                                            //Data Table No Header.feature  Feature file

Feature: This is the login feature for OrangeHRM with No Header
Scenario: This is the Login with No Header scenario
Given  user is in the login page
When user enters the below credential 
|Admin | admin123|
And The user clicks Login button

**********************************************************************************************************************************************************************

                                              //Data Table No Header.java Runner Class
                                              
   package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
 @CucumberOptions(features = "feature/DataTableNoHeader.feature",
 				  glue = "stepDefinations",
 				  plugin = {"html:report/WebReport","json:report/jsonreport.json"})
public class DataNoHeaderRun {

}

*********************************************************************************************************************************************************************

                                                   //Data Table No Header.java Step Define Class 
                                                   
  package stepDefinations;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DataTableNoHeaderDef {

	WebDriver driver;
	
	@Given("^user is in the login page$")
	public void user_is_in_the_login_page() throws Throwable {
		driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("^user enters the below credential$")
	public void user_enters_the_below_credential(DataTable dataTable) throws Throwable {
	   List<String> credentials = dataTable.asList(String.class);
	   String username = credentials.get(0);
	   String password = credentials.get(1);
	   driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
	   driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
	}

	@When("^The user clicks Login button$")
	public void the_user_clicks_Login_button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}

	
}
