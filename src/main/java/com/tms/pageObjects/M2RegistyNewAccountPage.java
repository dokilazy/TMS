package com.tms.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Key;

import com.tms.helper.AbstractPage;
import com.tms.helper.AutomationControl;
import com.tms.helper.Constants;
import com.tms.helper.WaitHelper;
import com.tms.interfaces.I_M2Page;

//import jline.internal.Log;

public class M2RegistyNewAccountPage extends AbstractPage {
	private WebDriver driver;

	@FindBy(id = "firstname")
	public WebElement firstname;

	@FindBy(id = "lastname")
	public WebElement lastname;

	@FindBy(id = "email_address")
	public WebElement emailAddress;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "password-confirmation")
	public WebElement passwordConfirm;

	@FindBy(id = "remember_meOGsbnv6e6o")
	public WebElement remembermeCheckbox;

	@FindBy(id = "organization_name")
	public WebElement organizationName;

	@FindBy(id = "subDomain")
	public WebElement subDomain;

	@FindBy(id = "inbox_field")
	public WebElement emailSearchTxt;

	@FindBy(xpath = "//div[@class='wrapper-primary-input medium-w100']/button")
	public WebElement goBtn;

	@FindBy(xpath = "//*[@id='form-validate']/div/div[1]/button")
	public WebElement createAccountBtn;

	@FindBy(xpath = "//div[@class='message-success success message']/div[contains(text(), 'You must confirm your account. Please check your email for the confirmation link or ')]")
	public WebElement registerSuccessMsg;

	@FindBy(xpath = "//body/p/a[contains(text(), 'https')]")
	public WebElement activeLink;

	WaitHelper waitHelper;

	public M2RegistyNewAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.WaitForElement(userName, 60);
	}

	public void enterFirstname(String firstname) {
		waitHelper.WaitForElement(this.firstname, 3);
		this.firstname.sendKeys(firstname);
	}

	public void enterLastname(String lastname) {
		waitHelper.WaitForElement(this.lastname, 3);
		this.lastname.sendKeys(lastname);
	}

	public void enterRandomName() {
		waitHelper.WaitForElement(this.firstname, 3);
		Constants.firstName = randomText(5);
		Constants.lastName = randomText(5);
		this.firstname.sendKeys(Constants.firstName);
		this.lastname.sendKeys(Constants.lastName);
	}

	public void enterEmail(String email) {
		waitHelper.WaitForElement(this.emailAddress, 3);
		this.emailAddress.sendKeys(email);
	}

	public void enterRandomEmail() {
		waitHelper.WaitForElement(this.emailAddress, 3);
		//Constants.email = randomText(6).toLowerCase() + "@mailinator.com";
		Constants.email = "testUser" + randomNumberString(4).toLowerCase() + "@mailinator.com";
		
		System.out.println(Constants.email);
		//Log.info(Constants.email);
		this.emailAddress.sendKeys(Constants.email);
	}

	public void enterPassword(String password) {
		waitHelper.WaitForElement(this.password, 3);
		this.password.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		// waitHelper.WaitForElement(this.passwordConfirm, 3);
		this.passwordConfirm.sendKeys(password);
	}

	public void enterPasswordAndConfirmPassword() {
		waitHelper.WaitForElement(this.password, 3);
		this.password.sendKeys(Constants.password);
		this.passwordConfirm.sendKeys(Constants.password);
//		enterPassword(Constants.password);
//		enterConfirmPassword(Constants.password);
	}

	public void enterOrganizationName(String organizationName) {
		// waitHelper.WaitForElement(this.organizationName, 3);
		this.organizationName.sendKeys(organizationName);
	}

	public void enterRandomOrganizationName() {
		Constants.organizationName = randomText(6);
		enterOrganizationName(Constants.organizationName);
	}

	public void enterSubdomain(String subdomain) {
		// waitHelper.WaitForElement(this.subDomain, 3);
		this.subDomain.sendKeys(subdomain);
	}

	public void enterRandomSubdomain() {
		// waitHelper.WaitForElement(this.subDomain, 3);
		Constants.subdomain = randomText(6);
		this.subDomain.sendKeys(Constants.subdomain);
	}

	public void clickCreateAccount() {
		this.createAccountBtn.click();
		sleep(4);
	}

	public boolean isRegisterSuccessMsg() {
		waitHelper.WaitForElement(this.registerSuccessMsg, 8);
		return this.registerSuccessMsg.isDisplayed();
	}

	public void openMailinatorMailBox(String email) {
		driver.get(Constants.mailinatorInboxURL);
		this.emailSearchTxt.sendKeys(email);
		goBtn.click();
		sleep(4);
	}

	public void openEmail(String subject) {

		WebElement email = getElement(driver, I_M2Page.MAIL_SUBJECT, subject);
		waitHelper.WaitForElement(email, 3);
		email.click();
	}

	public void clickActiveLink() {
		

	//	String activateUrl = "Sikuli_Objects/activateUrl.png";
	//	clickBySikuli(activateUrl);
		
	//	doubleClickBySikuli(activateUrl);
		
		waitHelper.WaitForElement(driver.findElement(By.xpath("//iframe[@id='html_msg_body']")), 3);
		switchToIframe(driver, "//iframe[@id='html_msg_body']");
		this.activeLink.click();
		
		sleep(2);
	}

	public boolean isMailVerificationSuccessMsgDisplayed() {
		String VerifiedMailmessage = "Sikuli_Objects/YourMailHasBeenVerifiedMsg.png";
		return checkExistBySikuli(VerifiedMailmessage);
	}

	public void switchToMailBoxtab() {
		switchToWindowHasTitle(driver, "Mailinator");
	}

	public void closeCurrentTab() {
		sendDouleKeyBySikuli("w", Key.CTRL);
	}

}
