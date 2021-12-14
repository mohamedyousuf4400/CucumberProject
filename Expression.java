                                            //Expression.feature Feature File

Feature: This is the feature file for Expression
Scenario: This is Expression scenario
Given I have 1 Moile & 1 Laptop
Given My CGPA is 8.08
Given I am "Mohamed Yousuf"
  
  ********************************************************************************************************************************************************************
  
                                           //ExpressionRunner.java Runner class

  package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature/Expression.feature",glue = "stepDefinations")
public class ExpressionRunner {

}

  
  ******************************************************************************************************************************************************************
  
                                          //Expression Step Defination.java  Step Define
  
  package stepDefinations;

import cucumber.api.java.en.Given;

public class ExpressionDefination {

	@Given("^I have (\\d+) Moile & (\\d+) Laptop$")
	public void i_have_Moile_Laptop(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Mobile count "+ arg1 +" Laptop count "+arg2);
	}

	@Given("^My CGPA is (\\d+\\.\\d+)$")
	public void my_CGPA_is(Float CGPA) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("My CGPA is"+CGPA);
	}

	@Given("^I am \"(.*?)\"$")
	public void i_am(String name) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("My name is"+name);
	}

	
}
