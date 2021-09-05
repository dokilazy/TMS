package com.tms.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.helper.AbstractPage;
import com.tms.helper.WaitHelper;

public class M2PaymentPage extends AbstractPage{
     
	private WebDriver driver;
	WaitHelper waitHelper;

	@FindBy(xpath = "")
	public WebElement xxx;
	
	@FindBy(xpath = "")
	public WebElement x2;
	
	@FindBy(xpath = "")
	public WebElement x3;
	
	public M2PaymentPage(WebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
