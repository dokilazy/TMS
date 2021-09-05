package com.tms.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.helper.AbstractPage;
import com.tms.helper.WaitHelper;
import com.tms.interfaces.I_M2Page;
import com.tms.interfaces.I_Settings;

public class M2LoginPage extends AbstractPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id='email']")
	public WebElement email;
	
	@FindBy(id="pass")
	public WebElement password;
	
	@FindBy(id="send2")
	public WebElement signInBtn;
	
	@FindBy(id="remember-me-box")
	public WebElement remembermeCheckbox;
		
	@FindBy(xpath = "//*[@id='login-form']/fieldset/div[5]/div[2]/a")
	public WebElement forgotPassword;
	
	@FindBy(xpath = "//*[@id='maincontent']/div[3]/div/div[2]/div[2]/div[2]/div/div/a")
	public WebElement createAccountBtn;
	
	
	@FindBy(xpath = "//div[@class='message-error error message']")
	public WebElement warningMessage;
	

	
	
//	@FindBy(xpath = "//div[@class='message-error error message']/div[contains(text(), 'EMAIL_NOT_FOUND')]")
//	public WebElement emailNotFoundErrorMsg;
//	
//	@FindBy(xpath = "//div[@class='message-error error message']/div[contains(text(), 'INVALID_PASSWORD')]")
//	public WebElement invalidPassErrorMsg;
	
	WaitHelper waitHelper;
	
	public M2LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		///waitHelper.WaitForElement(userName, 60);
	}
	
	public void enterEmail(String email) {
		waitHelper.WaitForElement(this.email, 3);
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void enterPassword(String password) {
		waitHelper.WaitForElement(this.password, 3);
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickSignIn() {
		waitHelper.WaitForElement(this.signInBtn, 3);
		this.signInBtn.click();
		waitHelper.WaitForElementInvisible(this.signInBtn, 3);
		sleep(1);
	}
	
	public void clickCreateAccount() {
		this.createAccountBtn.click();
	}
	
	public void clickForgotPassword() {
		this.forgotPassword.click();
	}
	
	public boolean isErrorSuccessMessageDisplay(String msg) {
		waitHelper.WaitForElement(this.warningMessage, 4);
		return isControlDisplayed(driver, I_M2Page.LOGIN_ERROR_MESSAGE, msg);
	}
	
	

	

}
