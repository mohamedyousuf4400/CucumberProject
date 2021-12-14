                                                    //Data Table With Header.feature  Feature File

Feature: The login feature for OrangeHRM with Header
Scenario: The Login with Header scenario
Given  user in login page
When user send the below credential 
|Username|Password|
|Admin   |admin123|
And user click Login button

************************************************************************************************************************************************************************

                                                     //Data Table With Header.Java Runner Class
                                                     
  package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature/HeaderDataTable.feature",glue = "stepDefinations")
public class DataWithHeaderRun {

}

**************************************************************************************************************************************************************************

                                                       //Data Table With Header.Java Step Define Class
                                                       
  package stepDefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DataTableHeaderDef {
	
	WebDriver driver;
	
	@Given("^user in login page$")
	public void user_in_login_page() throws Throwable {
		driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/");    
	}

	@When("^user send the below credential$")
	public void user_send_the_below_credential(DataTable dataTable) throws Throwable {
		 List<Map<String, String>> data =dataTable.asMaps(String.class,String.class);
		 String username =data.get(0).get("Username");
		 String password=data.get(0).get("Password");
		 driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
	}

	@When("^user click Login button$")
	public void user_click_Login_button() throws Throwable {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}


}
