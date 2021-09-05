package com.tms.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.helper.AbstractPage;
import com.tms.helper.WaitHelper;


public class M2ProfilePage  extends AbstractPage {
	
	private WebDriver driver;

	@FindBy(xpath = "//div[@class='box box-information']//a/span[contains(text(),'Edit')]")
	public WebElement editMyAccBtn;
	
	@FindBy(xpath = "//div[@class='box box-information']//a[contains(text(),'Change Password')]")
	public WebElement changePasswordBtn;
	
	@FindBy(xpath = "//input[@id='firstname']")
	public WebElement firstNametxt;
	
	@FindBy(xpath = "//input[@id='lastname']")
	public WebElement lastNametxt;

	@FindBy(xpath = "//input[@id='change-email']")
	public WebElement changeEmailChbx;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement changeEmailTxt;
	
	@FindBy(xpath = "//input[@id='change-password']")
	public WebElement changePassChbx;
	
	@FindBy(xpath = "//input[@id='organization_name']")
	public WebElement orgNameTxt;
	
	@FindBy(xpath = "//input[@id='subdomain']")
	public WebElement subdomainTxt;
	
	@FindBy(xpath = "//button[@type='submit' and @title='Save']")
	public WebElement saveBtn;
		
	WaitHelper waitHelper;
	

	public M2ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	public void clickEdit() {
		waitHelper.WaitForElement(this.editMyAccBtn, 3);
		this.editMyAccBtn.click();
	}
	
	public String getFirstName() {
		waitHelper.WaitForElement(this.firstNametxt, 3);
		return firstNametxt.getAttribute("value");
	}
	
	public String getLastName() {
		waitHelper.WaitForElement(this.lastNametxt, 3);
		return lastNametxt.getAttribute("value");
	}
	
	public String getEmail() {
		return changeEmailTxt.getAttribute("value");
	}
	
	public String getorgName() {
		return orgNameTxt.getAttribute("value");
	}
	
	public boolean isCorrectFirstName(String firstName) {
		if(getFirstName().contains(firstName))
			return true;
			else 
				return false;
	}
	
	public boolean isCorrectLastName(String name) {
		if(getLastName().contains(name))
			return true;
			else 
				return false;
	}
	
	public boolean isCorrectEmail(String mail) {
		if(getEmail().contains(mail))
			return true;
			else 
				return false;
	}
	
	public boolean isCorrectOrgName(String name) {
		if(getorgName().contains(name))
			return true;
			else 
				return false;
	}
	

}
