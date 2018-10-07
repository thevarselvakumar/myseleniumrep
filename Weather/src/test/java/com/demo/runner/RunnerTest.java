package com.demo.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// runner class

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, strict = false, monochrome = false, features = { "src/test/resources/" }, glue = { "com.demo.steps" }, plugin = {
		"html:target/site/cucuber-html", "json:target/cucumber1.json" }, tags={"@Login"}

)
public class RunnerTest {

}
