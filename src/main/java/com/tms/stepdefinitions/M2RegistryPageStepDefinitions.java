package com.tms.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.sikuli.script.Key;

import com.tms.helper.Constants;
import com.tms.helper.WaitHelper;
import com.tms.pageObjects.M2HomePage;
import com.tms.pageObjects.M2LoginPage;
import com.tms.pageObjects.M2ProfilePage;
import com.tms.pageObjects.M2RegistyNewAccountPage;
import com.tms.testBase.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import jline.internal.Log;

public class M2RegistryPageStepDefinitions extends TestBase {

	M2HomePage m2homepage = new M2HomePage(driver);
	M2LoginPage m2loginpage = new M2LoginPage(driver);
	M2RegistyNewAccountPage m2registry = new M2RegistyNewAccountPage(driver);
	M2ProfilePage m2profile = new M2ProfilePage(driver);

	WaitHelper waitHelper = new WaitHelper(driver);

	@Then("^I click Create an account in Sign in page$")
	public void i_click_Create_an_account_in_Sign_in_page() throws Throwable {
		m2loginpage.clickCreateAccount();
	}

	@Then("^I see the Registry page displayed$")
	public void i_see_the_registry_page() throws Throwable {
		m2registry.firstname.isDisplayed();
	}

	@And("^I enter random first name and lastname$")
	public void i_enter_random_firtname_lastname() throws Throwable {
		m2registry.enterRandomName();
	}

	@And("^I enter random email$")
	public void i_enter_random_email() throws Throwable {
		m2registry.enterRandomEmail();
	}

	@When("^I enter firstname as (.+)$")
	public void i_enter_firtname(String firstname) throws Throwable {
		m2registry.enterFirstname(firstname);
	}

	@When("^I enter lastname as (.+)$")
	public void i_enter_lastname(String lastname) throws Throwable {
		m2registry.enterLastname(lastname);
	}

	@When("^I enter password for registry as (.+)$")
	public void i_enter_password(String password) throws Throwable {
		m2registry.enterPassword(password);
	}

	@When("^I enter password confirm as (.+)$")
	public void i_enter_password_confirm(String password) throws Throwable {
		m2registry.enterConfirmPassword(password);
	}

	@And("^I enter password and confirm password$")
	public void i_enter_random_password() throws Throwable {
		m2registry.enterPasswordAndConfirmPassword();
	}

	@When("^I enter orginazationName as (.+)$")
	public void i_enter_orginazaionName(String organizationName) throws Throwable {
		m2registry.enterOrganizationName(organizationName);
	}

	@When("^I enter orginazation Name$")
	public void i_enter_random_orginazaionName() throws Throwable {
		m2registry.enterRandomOrganizationName();
	}

	@When("^I enter subdomain as (.+)$")
	public void i_enter_subdomain(String arg1) throws Throwable {
		m2registry.enterSubdomain(arg1);
	}

	@When("^I click Create an account in Registry page$")
	public void i_click_Create_an_account_in_Registry_page() throws Throwable {
		m2registry.clickCreateAccount();
	}

	@Then("^I see a message for asking active account$")
	public void i_see_an_message_asking_active_account() {
		assertTrue(m2registry.isRegisterSuccessMsg());
	}

	@When("^I active account in mail box by open mail subject as \"([^\"]*)\"$")
	public void i_active_account(String subject) throws Throwable {
		m2registry.openMailinatorMailBox(Constants.email);
		m2registry.openEmail(subject);
		
		m2registry.clickActiveLink();
	}

	@Then("^I should see mail has been verified success message$")
	public void i_should_see_verified_success_message() throws Throwable {
		m2registry.isMailVerificationSuccessMsgDisplayed();
	}

	@Then("^I can login by the registry account$")
	public void i_can_login_by_the_registed_account() throws Throwable {
		m2registry.closeCurrentTab();
		m2registry.switchToMailBoxtab();
		m2homepage.openURL(driver, Constants.M2_URL);
		m2homepage.clicksignIn();
		m2loginpage.enterEmail(Constants.email);
		m2loginpage.enterPassword(Constants.password);
		m2loginpage.clickSignIn();
		assertTrue(m2homepage.isFullNameDisplay(Constants.firstName + " " + Constants.lastName));
	}

	@And("^I see correct account information in my profile$")
	public void I_see_correct_account_info_in_my_profile() throws Throwable {
		m2homepage.clickMyAccount();
		m2profile.clickEdit();
		//check first name and last name and Email 
		assertTrue(m2profile.isCorrectFirstName(Constants.firstName));
		assertTrue(m2profile.isCorrectLastName(Constants.lastName));
		assertTrue(m2profile.isCorrectEmail(Constants.email));
		assertTrue(m2profile.isCorrectOrgName(Constants.organizationName));
	}

	
	@When("^I Registy multi Users (.+)$")
	public void Registy_multi_User(int n) throws Throwable {
		for (int i =0; i <n ; i++) {
		driver.get(Constants.M2_URL);
		m2homepage.clicksignIn();
		this.i_click_Create_an_account_in_Sign_in_page();
		i_see_the_registry_page();
		this.i_enter_random_firtname_lastname();
		this.i_enter_random_email();
		this.i_enter_random_password();
		this.i_enter_random_orginazaionName();
		this.i_click_Create_an_account_in_Registry_page();
		i_active_account("Verify your email for");
		i_should_see_verified_success_message();
		m2registry.closeCurrentTab();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
