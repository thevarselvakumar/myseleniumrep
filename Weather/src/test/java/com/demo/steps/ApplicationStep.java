package com.demo.steps;

//pass object of webconnector in both classes. Same Object
import java.util.Map;

import com.demo.webdriver.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ApplicationStep {

	WebConnector con;

	public ApplicationStep(WebConnector con) {

		this.con = con;
		// TODO Auto-generated constructor stub
	}

	@Then("^login should be (.*)$")
	public void validateLogin(String ExpectedResult) {
		con.validateLogin(ExpectedResult);
	}

	@And("^I login inside application$")
	public void login(Map<String, String> data) {

		System.out.println(data.get("Username"));
		System.out.println(data.get("Password"));
		
		con.login(data.get("Username"),data.get("Password"));

	}

	@And("^I verify the (.*)$")
	public void verify(String locatorkey)
	{
		boolean result=con.isElementPresent(locatorkey);
		if(result)
		{
				con.infologs("Weather is visible for city");
		}
		else
		{
			con.reportFailure("weather is not visible for city");
		}
	}

}
