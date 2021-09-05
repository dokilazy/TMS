package com.tms.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.helper.AbstractPage;
import com.tms.helper.WaitHelper;
import com.tms.interfaces.I_M2Page;

public class M2HomePage extends AbstractPage { 

	private WebDriver driver;

	@FindBy(xpath = "//h1[contains(text(),'Choose your apps')]")
	public WebElement chooseAppsLbl;

	@FindBy(xpath = "//li/a[contains(text(),'Sign In')]")
	public WebElement signInBtn;

	@FindBy(xpath = "//button[@data-action='customer-menu-toggle']")
	public WebElement customerMenuDD;

	@FindBy(xpath = "//div[@class='customer-menu']//li/a[contains(text(),'Sign Out')]")
	public WebElement signOutBtn;

	@FindBy(xpath = "//div[@class='customer-menu']//li/a[contains(text(),'My Account')]")
	public WebElement myAccountBtn;

	@FindBy(xpath = "//a[contains(text(),'Discover') and contains(@href, 'alert')]")
	public WebElement discoverAlertFlow;

	@FindBy(xpath = "//a[contains(text(),'Discover') and contains(@href, 'aims')]")
	public WebElement discoverAIM;

	@FindBy(xpath = "//a[contains(text(),'Discover') and contains(@href, 'count')]")
	public WebElement discoverCD;

	@FindBy(xpath = "//form[@data-product-sku='Recorder Alarm']/button[contains(@class, 'tocart')]")
	public WebElement addToCartAlertFlow;

	@FindBy(xpath = "//form[@data-product-sku='AIM']/button[contains(@class, 'tocart')]")
	public WebElement addToCartAIM;

	@FindBy(xpath = "//form[@data-product-sku='Count & Detect']/button[contains(@class, 'tocart')]")
	public WebElement addToCartCD;

	@FindBy(xpath = "//span[contains(text(), 'You are signed out')]")
	public WebElement singOutMsg;
	
	@FindBy(xpath = "//li/span[@class='logged-in' and contains(text(), 'Welcome')]")
	public WebElement welcomeTxt;
	
	@FindBy(xpath = "//div[@class='panel header']//li[@class='greet welcome']")
	public WebElement greetWelcomeLbl;
	
	WaitHelper waitHelper;

	public M2HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.WaitForElement(userName, 60);
	}
	
	public boolean isSignInSuccess() {
		waitHelper.WaitForElement(this.welcomeTxt, 5);
	  return this.welcomeTxt.isDisplayed() ;
	
	}

	public void clicksignIn() {
		waitHelper.WaitForElement(this.signInBtn, 3);
		// this.signInBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signInBtn);
	}

	public void clicksignOut() {
		this.customerMenuDD.click();
		waitHelper.WaitForElement(this.signOutBtn, 3);
		this.signOutBtn.click();
	}

	public void clickMyAccount() {
		waitHelper.WaitForElement(this.customerMenuDD, 3);
		this.customerMenuDD.click();
		waitHelper.WaitForElement(this.myAccountBtn, 3);
		this.myAccountBtn.click();
	}

	public boolean isSignOutSuccess() {
		waitHelper.WaitForElement(this.singOutMsg, 3);
		return singOutMsg.isDisplayed();
	}

	public boolean isHomePage() {
		if (this.signInBtn.isDisplayed() && this.chooseAppsLbl.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickdiscoverAlertFlow() {
		this.discoverAlertFlow.click();
	}

	public void clickdiscoverAIM() {
		discoverAIM.click();
	}

	public void clickdiscoverCD() {
		discoverCD.click();
	}

	public void clickaddToCartAlertFlow() {
		addToCartAlertFlow.click();
	}

	public void clickaddToCartAIM() {
		addToCartAIM.click();
	}

	public void clickaddToCartCD() {
		addToCartCD.click();
	}

	public boolean isFullNameDisplay(String fullName) {
		waitHelper.WaitForElement(this.greetWelcomeLbl, 4);
		return isControlDisplayed(driver, I_M2Page.WELCOME_TEXT, fullName);
	}
	
	
	
}
