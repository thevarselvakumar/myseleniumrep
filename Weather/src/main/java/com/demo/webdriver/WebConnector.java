package com.demo.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demo.reports.*;



public class WebConnector {

	WebDriver driver;

	public String name;

	public Properties prop;
	public ExtentReports rep;
	public ExtentTest scenario;

	public WebConnector() {
		// name = "A";
		if (prop == null) {
			try {
				prop = new Properties();

				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir")
								+ "\\src\\test\\resources\\project.properties");

				prop.load(fs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// report
			}
		}

	}

	public void openBrowser(String BrowserName) {
		
		if (BrowserName.equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserName.equals("IE")) {
			driver = new InternetExplorerDriver();
		}
	//	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		infologs("Opened Browser");
	}

	public void navigate(String urlkey) {

		System.out.println("urlkey" + prop.getProperty(urlkey));

		driver.get(prop.getProperty(urlkey));
	}

	public void click(String objectKey) {
		// driver.findElement(By.xpath(prop.getProperty(objectKey))).click();
		getObject(objectKey).click();

	}

	public void type(String objectKey, String data) {
		// driver.findElement(By.xpath(prop.getProperty(objectKey).sendKeys(data);

		getObject(objectKey).sendKeys(data);

	}

	public void validateLogin(String expectedResult) {
		boolean result = isElementPresent("profile_id");
		String actualResult = "";
		if (result) {
			actualResult = "sucess";
		} else {
			actualResult = "failure";
		}

		infologs("Expected  Result was" + expectedResult);
		infologs("Got actual Result as" + actualResult);
		if (!expectedResult.equals(expectedResult)) {
			//System.out.println("Scenario Failure");// reporting failure
			
			reportFailure("scenario failure");
		}
	}

	public boolean isElementPresent(String objectKey) {
		List<WebElement> e = null;
		if (objectKey.endsWith("_id")) {
			e = driver.findElements(By.id(prop.getProperty(objectKey)));// present
		} else if (objectKey.endsWith("_xpath")) {
			e = driver.findElements(By.xpath(prop.getProperty(objectKey)));// present

		}
		if (e.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	// Central function to extract object
	public WebElement getObject(String objectKey) {
		WebElement e = null;
		WebDriverWait wait = new WebDriverWait(driver, 0);
		try {

			if (objectKey.endsWith("_id")) {
			
				e = driver.findElement(By.id(prop.getProperty(objectKey)));// present
			/*	wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy((By.id(prop
								.getProperty(objectKey)))));
				*/
			}

			else if (objectKey.endsWith("_xpath")) {
				e = driver.findElement(By.xpath(prop.getProperty(objectKey)));// present
			/*	wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy((By.xpath(prop
								.getProperty(objectKey)))));*/
			}

		} catch (Exception ex) {
			// report failure
			ex.printStackTrace();
			reportFailure("unable to extract object"+objectKey);
			//ex.printStackTrace();
		}
		return e;
	}

	public void acceptAlertIfPresent() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			// not present
		}
	}

	public void login(String username, String password) {
		// TODO Auto-generated method stub
		type("username_xpath", username);
		type("password_id", password);
		click("submit_xpath");
		
	}

	/****** logging ******/
	public void infologs(String msg) {
		scenario.log(Status.INFO, msg);
	}


	/****** Reporting *******/
	public void quit() {
		if (rep != null) {
			rep.flush();
			
			if(driver!=null)
			{
				//driver.quit();
			}
		}

	}

	public void initReports(String scenarioName) {
		rep = ExtentManager.getInstance(prop.getProperty("reportPath"));
		System.out.println(prop.getProperty("reportPath"));
		scenario = rep.createTest(scenarioName);
		scenario.log(Status.INFO, "starting " + scenarioName);
	}
	

	public void reportFailure(String msg) {
		scenario.log(Status.FAIL, msg);
		
		takeScreenShot();
		//Fail in extent report
		//take screenshot and put in reports
		//fail in cucumber as well
		
		//assertThat(isElementPresent("X")).isTrue();
		
		//assertThat(false);
		
		
	}

	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(ExtentManager.screenshotFoldherPath+screenshotFile));
			
			scenario.log(Status.FAIL, "screenshot->"+scenario.addScreenCaptureFromPath(ExtentManager.screenshotFoldherPath+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	public void title(String expectedTitle) {
		
		String actualtitle=driver.getTitle();
		infologs("Title of the page"+actualtitle);
		Assert.assertEquals(actualtitle, expectedTitle);
		//assertThat(false);
		
		
		
	}

}
