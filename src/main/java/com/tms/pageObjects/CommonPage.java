package com.tms.pageObjects;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CommonPage {

	@FindBy(xpath = "//div[contains(@class,'snotify snotify-rightBottom')]/ng-snotify-toast")
	public WebElement notification;
	

		
	}



