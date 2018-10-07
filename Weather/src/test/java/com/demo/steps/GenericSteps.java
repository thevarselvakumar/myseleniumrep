//picoconatiner
package com.demo.steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.demo.webdriver.WebConnector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class GenericSteps {

	WebDriver driver;
	Properties prop;
	WebConnector con;

	public GenericSteps(WebConnector con) {
		this.con = con;
	}

	@Before
	public void before(Scenario s) {
		System.out.println("***Bef**" + s.getName());

		con.initReports(s.getName());

	}

	@After
	public void after() {
		System.out.println("***Aft***");
		con.quit();
	}

	@Given("^I open (.*)$")
	public void openBrowser(String BrowserName) {
		// System.out.println("Opening Browser"+con.name);
		//System.out.println("Opening Browser" +BrowserName );
		
		con.infologs("Opening Browser"+BrowserName);
		con.openBrowser(BrowserName);

	}

	/*
	 * @And("^I navigate to (.*)$") public void navigate(String url ){
	 * System.out.println("Navigating to"+con.name); }
	 */

	@And("^I navigate to (.*)$")
	public void navigate(String url) {
		// System.out.println("Navigating to" + con.name);

		//System.out.println("Navigating to" + url);
		con.infologs("Navigating to"+url);
		con.navigate(url);

	}

	@And("^I type (.*) in (.*) field$")
	public void type(String data, String locatorkey) {
		con.infologs("Typing in " + locatorkey + "Data" + data);
		con.type(locatorkey, data);
	}

	@And("^I click on (.*)$")
	public void click(String locatorkey) {
		con.infologs("Clicking on " + locatorkey);
		con.click(locatorkey);

		// driver.findElement(By.xpath(locatorkey));
	}
	
	@And("^I verify the Title should be (.*)$")
	public void i_verify_the_Title_should_be(String ExpectedTitle) {
	 
	/*	String title=driver.getTitle();
		System.out.println(title);*/
		
		con.title(ExpectedTitle);
		
	}
	

	
	

}
