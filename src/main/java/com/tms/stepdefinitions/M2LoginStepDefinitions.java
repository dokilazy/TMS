package com.tms.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.tms.helper.Constants;
import com.tms.helper.WaitHelper;
import com.tms.pageObjects.M2HomePage;
import com.tms.pageObjects.M2LoginPage;
import com.tms.testBase.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class M2LoginStepDefinitions extends TestBase {

	M2HomePage m2homepage = new M2HomePage(driver);
	M2LoginPage m2loginpage = new M2LoginPage(driver);

	WaitHelper waitHelper = new WaitHelper(driver);

	@Given("^I am on the M2 Homepage$")
	public void i_am_on_the_M2_Homepage() throws Throwable {
		driver.get(Constants.M2_URL);
		}

	@When("^I go to M2 sign in page$")
	public void i_go_to_sign_in_page() throws Throwable {
		m2homepage.clicksignIn();
	}

	@When("^I enter email as (.+)$")
	public void i_enter_email(String email) throws Throwable {
		m2loginpage.enterEmail(email);
	}

	@And("^I enter password for login as (.+)$")
	public void i_enter_password(String password) throws Throwable {
		m2loginpage.enterPassword(password);
	}

	@And("^I click on Sign In$")
	public void i_click_on_SignIn() throws Throwable {
		m2loginpage.clickSignIn();
	}
	
	@When("^I click on Sign out$")
	public void i_click_on_SignOut() throws Throwable {
		m2homepage.clicksignOut();
	}
	
	@Then("^I see an error message as (.+)$")
	public void i_see_Error_message(String msg) throws Throwable {
		assertTrue(m2loginpage.isErrorSuccessMessageDisplay(msg));
	}
	
	@Then("^I see the Home page with name displayed as (.+)$")
	public void I_see_logged_in_page_as(String fullName) throws Throwable {
		//String fullName = Constants.firstName + " " + Constants.lastName;
		System.out.println(fullName);
		assertTrue(m2homepage.isSignInSuccess());
		assertTrue(m2homepage.isFullNameDisplay(fullName));
	}
	
	@Then("^I see signed-out page$")
	public void I_see_signed_out_page() throws Throwable {
		assertTrue(m2homepage.isSignOutSuccess());
	}

	@And("^I see home page after 5s$")
	public void i_see_homepage_after_5s() throws Throwable {
		Thread.sleep(6000);
		assertTrue(m2homepage.isHomePage());
	}

	@When("^I sign in the page by email as (.+) and password as(.+)$")
	public void I_sign_in_page(String email, String password) throws Throwable {
		m2homepage.clicksignIn();
		m2loginpage.enterEmail(email);
		m2loginpage.enterPassword(password);
		m2loginpage.clickSignIn();
		
	}

}
