package com.tms.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tms.helper.AbstractPage;
import com.tms.helper.WaitHelper;
import com.tms.interfaces.I_Settings;


public class SettingsPage extends AbstractPage {
	private WebDriver driver;

	@FindBy(xpath = "//a[contains(@href,'/ui/settings')]")
	public WebElement settingTab;

	@FindBy(xpath = "//a[contains(@href,'/ui/settings/system')]")
	public WebElement systemTab;

	@FindBy(xpath = "//a[contains(@href,'/ui/settings/module')]")
	public WebElement moduleTab;

	// --- System ---//
	@FindBy(xpath = "//div[@class='global-bar']//div[contains(text(),'Save')]")
	public WebElement saveEmailSettingBtn;

	@FindBy(xpath = "//div[@class='row form-row']/label[contains(text(), 'Host')]/following-sibling::input")
	public WebElement host;

	@FindBy(xpath = "//div[@class='row form-row']/label[contains(text(), 'Password')]/following-sibling::button")
	public WebElement changepasswordBtn;

	@FindBy(xpath = "//div[@class='row form-row']/label[contains(text(), 'Password')]/following-sibling::div/input")
	public WebElement changepasswordInput;

	@FindBy(xpath = "//div[@class='row form-row']/label[contains(text(), 'Port')]/following-sibling::input")
	public WebElement port;

	@FindBy(xpath = "//div[@class='row form-row']/label[contains(text(), 'SMTP SSL Trust')]/following-sibling::input")
	public WebElement sslTrust;

	@FindBy(xpath = "//div[@class='row form-row']/label[contains(text(), 'User')]/following-sibling::input")
	public WebElement user;

	@FindBy(xpath = "//div[@class='settingsItem']/div/div[3]/div[last()]/button")
	public WebElement checkconnectionBtn;

	// --- Module ---//
	@FindBy(xpath = "//div[@class='global-bar']//div[contains(text(),'New')]")
	public WebElement newBtn;

	@FindBy(xpath = "//div[@class='global-bar']//div[contains(text(),'Edit')]")
	public WebElement editBtn;

	@FindBy(xpath = "//div[@class='global-bar']//div[contains(text(),'Delete')]")
	public WebElement deleteBtn;
	
	@FindBy(xpath = "//app-module-create/app-module-detail/app-container/div/div[2]/div[1]/div/div[1]/div/form/div[2]/div/input")
	public WebElement skuTxt;
	
	@FindBy(xpath = "//div[contains(@class,'snotify snotify-rightBottom')]/ng-snotify-toast")
	public WebElement notification;
	
	@FindBy(xpath="//app-module-list/app-list/table/thead/tr/th[contains(text(),'Module Version')]")
	public WebElement moduleTable;
	
	WaitHelper waitHelper;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.WaitForElement(userName, 60);
	}

	public void gotoSettingPage() {
		waitHelper.WaitForElement(this.settingTab, 4);
		this.settingTab.click();
	}

	public void clickSystemTab() {
		waitHelper.WaitForElement(this.systemTab, 3);
		this.systemTab.click();
	}

	public void clickModuleTab() {
		waitHelper.WaitForElement(this.moduleTab, 3);
		this.moduleTab.click();
	}

	public void enterHost(String host) {
		waitHelper.WaitForElement(this.host, 3);
		this.host.clear();
		this.host.sendKeys(host);
	}

	public void clickChangePassword() {
		this.changepasswordBtn.click();
	}

	public void enterPassword(String password) {
		waitHelper.WaitForElement(this.changepasswordInput, 3);
		this.changepasswordInput.sendKeys(password);
	}

	public void enterPort(String port) {
		waitHelper.WaitForElement(this.port, 3);
		this.port.clear();
		this.port.sendKeys(port);
	}
	public void enterSSLTrust(String sslTrust) {
		waitHelper.WaitForElement(this.host, 3);
		this.sslTrust.clear();
		this.sslTrust.sendKeys(sslTrust);
	}

	public void enterUser(String user) {
		this.user.clear();
		this.user.sendKeys(user);
	}

	public void clickSave() {
		this.saveEmailSettingBtn.click();
	}

	public void clickCheckConnection() {
	//	this.checkconnectionBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", checkconnectionBtn);
	}

	public void clickAddNewModule() {
		waitHelper.WaitForElement(this.newBtn, 3);
		this.newBtn.click();
	}

	public void clickEditModule() {
		this.editBtn.click();
	}

	public void clickDeleteModule() {
		this.deleteBtn.click();
	}
	public void enterMagentoSKU(String sku) {
		this.skuTxt.clear();
		this.skuTxt.sendKeys(sku);
	}
	
	
	public boolean isSuccessMessageDisplay(String msg) {
		waitHelper.WaitForElement(this.notification, 4);
		return isControlDisplayed(driver, I_Settings.SUCCESS_MESSAGE, msg);
	}
	
	public void waitSettingPopupDisappear() {
		waitForControlNotDisplayed(driver, "//div[contains(@class,'snotify snotify-rightBottom')]/ng-snotify-toast", 10000);
	}
	

}
