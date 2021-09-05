package com.tms.helper;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


import com.tms.helper.AutomationControl;
//import com.tms.testBase.TestBase;

//import libraries.generalFunctions.Functions;


public class AbstractPage {
	
	//WebDriver driver = TestBase.getDriver();
	
	// wait to click
		public void click(WebDriver driver, String controlName) {
			waitForControl(driver, controlName, timeWait);
			element = control.findElement(driver, controlName);
			element.click();
		}
		// wait in time to click 
		public void click(WebDriver driver, String controlName, String value) {
			waitForControl(driver, controlName, value, timeWait);
			element = control.findElement(driver, controlName, value);
			element.click();
		}

		// Unicode Character 'BACKSPACE' (U0008)
		public void type(WebDriver driver, String controlName, String value) {
			waitForControl(driver, controlName, timeWait);
			element = control.findElement(driver, controlName);
			element.clear();
			element.sendKeys("\u0008" + value);
		}

		public void selectItemCombobox(WebDriver driver, String controlName, String item) {
			element = control.findElement(driver, controlName);
			Select select = new Select(element);
			select.selectByVisibleText(item);
		}

		public void selectItemCombobox(WebDriver driver, String controlName, String value, String item) {
			element = control.findElement(driver, controlName, value);
			Select select = new Select(element);
			select.selectByVisibleText(item);
		}

		public String getItemSelectedCombobox(WebDriver driver, String controlName) {
			element = control.findElement(driver, controlName);
			Select select = new Select(element);
			String itemSelected = select.getFirstSelectedOption().getText();
			return itemSelected;
		}

		public String getItemSelectedCombobox(WebDriver driver, String controlName, String value) {
			element = control.findElement(driver, controlName, value);
			Select select = new Select(element);
			String itemSelected = select.getFirstSelectedOption().getText();
			return itemSelected;
		}

		public void refresh(WebDriver driver) {
			driver.navigate().refresh();
			sleep(2);
		}

		public void back(WebDriver driver) {
			driver.navigate().back();
		}

		public void forward(WebDriver driver) {
			driver.navigate().forward();
		}

		public void openURL(WebDriver driver, String url) {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		public String getPageTitle(WebDriver driver) {
			return driver.getTitle();
		}

		public void waitForAlert(WebDriver driver) {
			new WebDriverWait(driver, 60).ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
		}

		public void acceptJavascriptAlert(WebDriver driver) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

		public void dismissJavascriptAlert(WebDriver driver) {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}

		public String getTextJavascriptAlert(WebDriver driver) {
			String message;
			try {
				Alert alert = driver.switchTo().alert();
				message = alert.getText();
				alert.accept();
			} catch (final WebDriverException e) {
				message = null;
			}
			return message;
		}

		public void acceptJavascriptPrompt(WebDriver driver, String value) {
			Alert alert = driver.switchTo().alert();
			driver.switchTo().alert().sendKeys(value);
			alert.accept();
		}

		public void waitForAjaxDone(WebDriver driver) {
			while (true) {
				Boolean ajaxIsComplete = (Boolean) executeJavaScript(driver, "return jQuery.active == 0");
				if (ajaxIsComplete)
					break;
				sleep(5);
			}
		}

		public static void waitForAjax(WebDriver driver) {
			new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					return (Boolean) js.executeScript("return jQuery.active == 0");
				}
			});
		}

		public void waitUntilAjaxRequestCompletes(WebDriver driver) {
			new FluentWait<WebDriver>(driver).withTimeout(45, TimeUnit.SECONDS).pollingEvery(15, TimeUnit.SECONDS).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					JavascriptExecutor jsExec = (JavascriptExecutor) d;
					return (Boolean) jsExec.executeScript("return jQuery.active == 0");
				}
			});
		}

		public void waitForControlNotDisplayed(WebDriver driver, final String controlName, long timeout) {
			try {
				By by = control.getBy(driver, controlName);
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public String getAttributeValue(WebDriver driver, String controlName, String attribute) {
			waitForControl(driver, controlName, timeWait);
			element = control.findElement(driver, controlName);
			return element.getAttribute(attribute);
		}

		public void doubleClick(WebDriver driver, String controlName) {
			waitForControl(driver, controlName, timeWait);
			Actions action = new Actions(driver);
			element = control.findElement(driver, controlName);
			action.doubleClick(element).perform();
		}

		public int countElement(WebDriver driver, String controlName) {
			waitForControl(driver, controlName, timeWait);
			return control.findElements(driver, controlName).size();
		}

		public void moveMouseToElement(WebDriver driver, String controlName) {
			waitForControl(driver, controlName, timeWait);
			Actions action = new Actions(driver);
			action.moveToElement(getElement(driver, controlName), 156, 20);
			action.build().perform();
		}

		public WebElement getElement(WebDriver driver, String controlName) {
			element = control.findElement(driver, controlName);
			return element;
		}
		
		public WebElement getElement(WebDriver driver, String specialControl, String value) {
			element = control.findElement(driver, specialControl, value);
			return element;
		}

		public Object executeJavaScript(WebDriver driver, String javaSript) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return js.executeScript(javaSript);
			} catch (Exception e) {
				e.getMessage();
				return null;
			}
		}

		public Object executeJavaScript(WebDriver driver, String javaSript, String controlName) {
			try {
				element = control.findElement(driver, controlName);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return js.executeScript(javaSript, element);
			} catch (Exception e) {
				e.getMessage();
				return null;
			}
		}

		public String getCurrentUrl(WebDriver driver) {
			return driver.getCurrentUrl();
		}

		public void scrollToBottomPage(WebDriver driver) {
			executeJavaScript(driver, "window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		}

		public void scrollPageToElement(WebDriver driver, String controlName) {
			waitForControl(driver, controlName, 5);
			element = control.findElement(driver, controlName);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			sleep(2);
		}

		public String randomNumberString() {
			Random rand = new Random();
			int number = rand.nextInt(9000) + 1;
			String numberString = Integer.toString(number);
			return numberString;
		}

		public void uncheckTheCheckbox(WebDriver driver, String controlName) {
			element = control.findElement(driver, controlName);
			if (element.isSelected()) {
				click(driver, controlName);
			}
		}

		public boolean isCheckboxChecked(WebDriver driver, String controlName) {
			element = control.findElement(driver, controlName);
			return element.isSelected();
		}

		public void dragAndDrop(WebDriver driver, String sourceControl, String targetControl) {
			WebElement source = control.findElement(driver, sourceControl);
			WebElement target = control.findElement(driver, targetControl);
			Actions action = new Actions(driver);
			action.dragAndDrop(source, target);
			action.perform();
		}

		public boolean isControlDisplayed(WebDriver driver, String controlName) {
			try {
				element = control.findElement(driver, controlName);
				return element.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}

		public boolean isControlDisplayed(WebDriver driver, String controlName, String value) {
			try {
				element = control.findElement(driver, controlName, value);
				return element.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}

		public boolean isControlSelected(WebDriver driver, String controlName) {
			try {
				element = control.findElement(driver, controlName);
				return element.isSelected();
			} catch (Exception e) {
				return false;
			}
		}

		public boolean isControlEnabled(WebDriver driver, String controlName) {
			try {
				element = control.findElement(driver, controlName);
				return element.isEnabled();
			} catch (Exception e) {
				return false;
			}
		}

		public void waitForControl(WebDriver driver, final String controlName, long timeout) {
			try {
				By by = control.getBy(driver, controlName);
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void waitForControl(WebDriver driver, final String controlName, String value, long timeout) {
			try {
				By by = control.getBy(driver, controlName, value);
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public String getText(WebDriver driver, String controlName) {
			try {
				waitForControl(driver, controlName, timeWait);
				WebElement element = control.findElement(driver, controlName);
				return element.getText();
			} catch (Exception e) {
				return null;
			}
		}

		public void sleep(long timeout) {
			try {
				Thread.sleep(timeout * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void checkTheCheckbox(WebDriver driver, String controlName) {
			element = control.findElement(driver, controlName);
			if (!element.isSelected()) {
				click(driver, controlName);
			}
		}

		public void checkTheCheckbox(WebDriver driver, String controlName, String value) {
			element = control.findElement(driver, controlName, value);
			if (!element.isSelected()) {
				click(driver, controlName, value);
			}
		}
	
		
		/**
		 * Randomize a string and return as a string
		 * 
		 * @param length
		 * @return Return a String
		 */
		public String randomText(int length) {

			String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

			Random rand = new Random();

			// consider using a Map<String,Boolean> to say whether the identifier is being
			// used or not
			Set<String> identifiers = new HashSet<String>();

			StringBuilder builder = new StringBuilder();
			while (builder.toString().length() == 0) {
				for (int i = 0; i < length; i++) {
					builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
				}
				if (identifiers.contains(builder.toString())) {
					builder = new StringBuilder();
				}
			}
			return builder.toString();
		}

		/**
		 * Randomize a string and return as a string
		 * 
		 * @param length
		 * @return Return a Number by String
		 */
		public String randomNumberString(int length) {

			String lexicon = "0123456789";

			Random rand = new Random();

			// consider using a Map<String,Boolean> to say whether the identifier is being
			// used or not
			Set<String> identifiers = new HashSet<String>();

			StringBuilder builder = new StringBuilder();
			while (builder.toString().length() == 0) {
			
				for (int i = 0; i < length; i++) {
					builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
				}
				if (identifiers.contains(builder.toString())) {
					builder = new StringBuilder();
				}
			}
			return builder.toString();
		}
		
	
		public int convertStringToInteger(String input) {
			return Integer.parseInt(input);
		}

		public static String convertIntegerToString(int input) {
			return String.valueOf(input);
		}
		
		public int randomInterger(int min, int max) {
			return ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		
		/**
		 * Get today's date MM/dd/yyyy or dd/MM/yyyy
		 * input:  format String
		 */
		public String getCurrentDate(String dateformat) {
			DateFormat mDateFormat = new SimpleDateFormat(dateformat);
			Date mDate = new Date();
			return mDateFormat.format(mDate);
		}
		
		/**
		 * Get current time
		 */
		public String getCurrentTime() {
			DateFormat mDateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");
			Date mDate = new Date();
			return mDateFormat.format(mDate);
		}
		
		/**
		 * get current time in long type
		 */
		public Long getCurrentTimeinLong() {
			Long millis = 12345678910L;
			SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
			dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT+7"));
			Date mDate = new Date();

			// now = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
			// //ofHours(+7)
			// now =
			// LocalDateTime.now().atZone(ZoneId.of("Europe/London")).toInstant().toEpochMilli();
			// //ofHours(+7)
			String a = dateFormatGmt.format(mDate);

			try {
				millis = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss").parse(a).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return millis;
		}

		public static boolean checkExistBySikuli(String data) {
			Screen screen = new Screen();
			// Create object of Pattern class and specify the images path
			Pattern image = new Pattern(data);
			if (screen.exists(data) != null)
				return true;
			else
				return false;
		}

		/**
		 * Click by using SikuliX
		 * 
		 * @return Return a number as a String
		 */

		public void clickBySikuli(String data) {

			Screen screen = new Screen();
			// Create object of Pattern class and specify the images path
			Pattern image = new Pattern(data);

			try {
				screen.click(image);

			} catch (FindFailed e) {
				e.printStackTrace();
			}

		}
		
		public void doubleClickBySikuli(String data) {

			Screen screen = new Screen();
			// Create object of Pattern class and specify the images path
			Pattern image = new Pattern(data);

			try {
				screen.doubleClick(image);

			} catch (FindFailed e) {
				e.printStackTrace();
			}

		}
		
		

		public void sendSingleKeyBySikuli(String key) {
			Screen screen = new Screen();
			screen.type(key);
		}
		
		public void sendDouleKeyBySikuli(String key, String k) {
			Screen screen = new Screen();
			screen.type(key, k);
		}

		public void sendKeyBySikuli(String data, String input) {

			Screen screen = new Screen();
			// Create object of Pattern class and specify the images path
			Pattern image = new Pattern(data);

			try {
				screen.doubleClick(image);
				screen.type("a", Key.CTRL);
				screen.type(Key.DELETE);

				if (input.length() < 30)
					screen.type(input);
				else {
					setValueToclipboard(input);
					screen.type("v", Key.CTRL);
				}

			} catch (FindFailed e) {
				e.printStackTrace();
			}
		}

		public void sendKeyBySikuliWithoutClean(String input) {

			Screen screen = new Screen();
			if (input.length() < 30)
				screen.type(input);
			else {
				setValueToclipboard(input);
				screen.type("v", Key.CTRL);
			}
		}

		public void pasteValueBySikuli(String data, String input) {

			setValueToclipboard(input);
			Screen screen = new Screen();

			Pattern image = new Pattern(data);

			try {
				// screen.doubleClick(940,560);
				screen.doubleClick(image);
				screen.type("a", Key.CTRL);
				screen.type(Key.DELETE);
				// screen.type(input);
				screen.type("v", Key.CTRL);

			} catch (FindFailed e) {
				e.printStackTrace();
			}
		}

		public static void pasteValueBySikuli(String input, int x, int y) {

			setValueToclipboard(input);
			Screen screen = new Screen();

			try {
				screen.mouseMove(x, y);
				// screen.doubleClick(940,560);
				screen.doubleClick(x, y);
				screen.delayClick(500);

				// region.rightClick(Location(x+1150, y+200))
				screen.doubleClick(x, y);
				screen.type("a", Key.CTRL);
				screen.type(Key.DELETE);
				// screen.type(input);
				screen.type("v", Key.CTRL);

			} catch (FindFailed e) {
				e.printStackTrace();
			}
		}
		
		public static void setValueToclipboard(String intput) {

			StringSelection stringSelection = new StringSelection(intput);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
		}

		/**
		 * Get duration between 2 times
		 * 
		 * @param eventTime1
		 * @param eventTime2
		 * @return duration as format d:hh:mm
		 */

		public String getDuration(Date eventTime1, Date eventTime2) {

			Calendar c1 = Calendar.getInstance();
			c1.setTime(eventTime1);
			Calendar c2 = Calendar.getInstance();
			c2.setTime(eventTime2);
			long l = c2.getTimeInMillis() - c1.getTimeInMillis();
			long s = l / 1000;
			long hour = s / 3600;
			long min = s / 60;
			long sec = s - (min * 60) - (hour * 3600);

			String strHour = placeZeroIfNeede(hour);
			if (strHour == "00")
				strHour = "0";

			String strMin = placeZeroIfNeede(min);
			String strSec = placeZeroIfNeede(sec);
			String duration = String.format("%s:%s:%s", strHour, strMin, strSec);
			return duration;
		}

		public static String placeZeroIfNeede(long number) {
			return (number >= 10) ? Long.toString(number) : String.format("0%s", Long.toString(number));
		}

		/**
		 * Copy String to Clipboard
		 * 
		 * @param intput
		 */
		
		
		/**
		 * Switch to window has Title
		 */
		public void switchToWindowHasTitle(WebDriver driver, String ptitle) {
			String currentWindow = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				if (driver.switchTo().window(winHandle).getTitle().equals(ptitle)) {
					break;
				} else {
					driver.switchTo().window(currentWindow);
				}
			}
		}
		
		
		/**
		 * Switch to Iframe has controlName (xpath)
		 */
		public void switchToIframe(WebDriver driver, String controlName) {
				driver.switchTo().frame(control.findElement(driver, controlName));
			}
	
	protected AutomationControl control = new AutomationControl();
	protected int timeWait = 30;
	protected int timeSleep = 2;
	protected WebElement element;
}
