package com.tms.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.helper.WaitHelper;

public class TMSLoginPage {
	private WebDriver driver;
	
	@FindBy(id="username")
	public WebElement userName;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="button")
	WebElement loginButton;
	
	WaitHelper waitHelper;
	
	public TMSLoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
		
	public void enterUserName(String userName){
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton(){
		loginButton.click();
	}

	
	// --- Forgot password ---
	
	@FindBy(id="email_address")
	public WebElement emailAddress;
	
	@FindBy(xpath="//*[@id='form-validate']/div/div[1]/button")
	WebElement resetPasswordBtn;
	
	public void enteremailAddress(String emailAddress){
		this.emailAddress.sendKeys(emailAddress);
	}
	public void clickResetPassword(){
		resetPasswordBtn.click();
	}
	
	
}
