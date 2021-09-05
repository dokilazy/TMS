package com.tms.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.tms.helper.Constants;
import com.tms.helper.WaitHelper;
import com.tms.pageObjects.TMSLoginPage;
import com.tms.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TMSLoginPageStepDefinitions extends TestBase {

	TMSLoginPage loginPage = new TMSLoginPage(driver);

	WaitHelper waitHelper = new WaitHelper(driver);

	// Go to Login page
	@Given("^I am on the Login page$")
	public void i_am_on_the_Login_page() throws Throwable {
		driver.get(Constants.base_URL);
		// waitHelper = new WaitHelper(driver);
	}

	@Then("^I should see Sign In of TMS Page$")
	public void i_should_see_Sign_In_Page() throws Throwable {
		loginPage.userName.isDisplayed();
	}

	@When("^I enter username of TMS admin$")
	public void i_enter_username_as(String arg1) throws Throwable {
		loginPage.enterUserName(Constants.getUsername());
	}

	@When("^I enter password of TMS admin$")
	public void i_enter_password_as(String arg1) throws Throwable {
		loginPage.enterPassword(Constants.getPassword());
	}

	@When("^I click on login button$")
	public void click_on_login_button() throws Throwable {
		
		loginPage.clickLoginButton();
	}

	@When("^I am logged in TMS$")
	public void i_am_already_logged_in() throws Throwable {
		Thread.sleep(2000);
		// loginPage.logoutBtn.isDisplayed();
	}
	
	@Given("^I login success$")
	public void i_am_on_the_Home_page() throws Throwable {
		driver.get(Constants.base_URL);
		// waitHelper = new WaitHelper(driver);
		loginPage.enterUserName(Constants.getUsername());
		loginPage.enterPassword(Constants.getPassword());
		loginPage.clickLoginButton();
		Thread.sleep(2000);
		driver.get(Constants.TMS_URL);
		Thread.sleep(3000);
	}
	

}
