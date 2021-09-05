package com.tms.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.testng.Assert.assertTrue;

import java.lang.System;
import com.tms.helper.Constants;
import com.tms.helper.WaitHelper;
import com.tms.interfaces.I_Settings;
import com.tms.pageObjects.SettingsPage;
import com.tms.pageObjects.TMSLoginPage;
import com.tms.testBase.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SettingsPageStepDefinitions extends TestBase {

	SettingsPage settingPage = new SettingsPage(driver);
	TMSLoginPage loginPage = new TMSLoginPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);

	
	@Given("^I am on the Settings page of TMS$")
	public void i_am_on_the_Setting_page() throws Throwable {
		driver.get(Constants.base_URL + "auth/login/");
		Thread.sleep(1000);
		// waitHelper = new WaitHelper(driver);
		loginPage.enterUserName(Constants.getUsername());
		loginPage.enterPassword(Constants.getPassword());
		loginPage.clickLoginButton();
		Thread.sleep(1000);
//		driver.get(Constants.base_URL);
//		Thread.sleep(1000);
		driver.get(Constants.TMS_URL);
		settingPage.gotoSettingPage();
	}

	@When("^I go to the system page$")
	public void i_go_to_the_system_page() throws Throwable {
		settingPage.clickSystemTab();
	}

	@Then("^I see the system page$")
	public void i_see_the_system_page() throws Throwable {
		settingPage.host.isDisplayed();
	}

	@When("^I enter host as (.+)$")
	public void i_enter_host(String arg1) throws Throwable {
		settingPage.enterHost(arg1);
	}

	@And("^I enter email password as \"([^\"]*)\"$")
	public void i_enter_password(String arg1) throws Throwable {
		settingPage.clickChangePassword();
		Thread.sleep(2000);
		settingPage.enterPassword(arg1);
	}

	@And("^I enter port as \"([^\"]*)\"$")
	public void i_enter_port(String arg1) throws Throwable {
		settingPage.enterPort(arg1);
	}

	@And("^I enter SSL Trust as \"([^\"]*)\"$")
	public void i_enter_SSLTrust(String arg1) throws Throwable {
		settingPage.enterSSLTrust(arg1);
	}

	@And("^I enter user as \"([^\"]*)\"$")
	public void i_enter_user(String arg1) throws Throwable {
		settingPage.enterUser(arg1);
	}

	@When("^I click Save$")
	public void i_click_Save() throws Throwable {
		settingPage.clickSave();
		Thread.sleep(200);
	}
	
	@Then("^I should see success saving popup having text as \"([^\"]*)\"$")
	public void Success_message_display_with_fixed_msg(String arg1) throws Throwable {
		// System.out.print("Message Value= "+ arg1);
		 assertTrue(settingPage.isSuccessMessageDisplay(arg1));
		 
		 // Wait for pop up disappears
		 settingPage.waitSettingPopupDisappear();
		 Thread.sleep(1000);
	}
	
	@When("^I click on Check Connection button$")
	public void i_click_on_Check_Connection_button() throws Throwable {
		settingPage.clickCheckConnection();
		
		Thread.sleep(500);
	}
	
	@Then("^I should see a popup having text as (.+)$")
	public void Success_message_display(String arg1) throws Throwable {
		 System.out.print("Message Value= "+ arg1);
		 assertTrue(settingPage.isSuccessMessageDisplay(arg1));
		 Thread.sleep(1000);
	}
	
	//----------------------------- MODULE PAGE -------------------
	
	@When("^I go to the module page$")
	public void i_go_to_the_module_page() throws Throwable {
		settingPage.clickModuleTab();
		Thread.sleep(1000);
	}
	@Then("^I see the module page$")
	public void i_see_the_module_page() throws Throwable {
		
		settingPage.moduleTable.isDisplayed();
	}
	@When("^I click add new module$")
	public void i_click_add_new_module() throws Throwable {
		settingPage.clickAddNewModule();
	}
	
	@When("^I select module name$")
	public void i_select_module_name() throws Throwable {
		
		settingPage.selectItemCombobox(driver, I_Settings.DROPDOWN, "AIMS2");
	}
	
	@When("^I enter SKU$")
	public void i_enter_SKU() throws Throwable {
		settingPage.enterMagentoSKU("AIMS");
	}
	
	
	

}
