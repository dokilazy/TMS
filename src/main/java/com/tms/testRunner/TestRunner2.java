package com.tms.testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import io.cucumber.junit.CucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		
		features = {"src/test/resources/features/Settings/emailSetup.feature"}  , 
		glue = { "com/tms/stepdefinitions" }, 
		plugin = {"pretty",
		 "html:target/cucumber-reports/cucumber2.html", "json:target/cucumber-reports/CucumberTestReport2.json" },
		monochrome = true, //display the console output in a proper readable format
		dryRun = false ,  //to check the mapping is proper between feature file and step def file
		tags = ("@SmokeTest, @RegressionTest"))


 public class TestRunner2 { //extends AbstractTestNGCucumberTests {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	   
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Runs cucmber Features", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void testDownClass() {
		testNGCucumberRunner.finish();
	}

}
