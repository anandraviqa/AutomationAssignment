package com.automationAssignment.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/* This is a class which have all helper methods
 * for code reusabilty
*/
public abstract class HelperPage {
	
	@FindBy(xpath = "//android.view.View[@text='close']")
	protected static WebElement closeButton;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/loc_ux_update_current_pin_code']")
	protected static WebElement useCurrentLocationClick;
	
	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	protected static WebElement allowLocationButton;

	public static WebDriverWait wait;

	protected static Dimension size;

	protected static AppiumDriver<MobileElement> driver;
	
	public HelperPage(AppiumDriver<MobileElement> driver) throws Exception {
		HelperPage.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 	
	}

	//This is global method which can be used to takescreen shots within in Project
	public static boolean takeScreenshotAs(final String name) {
		String screenshotDirectory = System.getProperty("appium.screenshots.dir",
				System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}

	//Sleep method to be used Project wide 
	public static void sleep(int sleeptime) {
		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//When displayed language pop up
	public static void closeButton() {
		takeScreenshotAs("closeButton");
		try {
			closeButton.click();
		} catch (Exception e) {
			System.err.println("Language Pop up not displayed");
		}
		takeScreenshotAs("closeButton");
	}
	
	//When displayed Current Location pop up
	public static void useCurrentLocationClick() {
		takeScreenshotAs("useMyCurrentLocationClick");
		try {
			useCurrentLocationClick.click();
		} catch (Exception e) {
			System.err.println("use My Current Location button not present");
		}
		takeScreenshotAs("useMyCurrentLocationClick2");
		
		takeScreenshotAs("allowLocationButton");
		try {
			allowLocationButton.click();
		} catch (Exception e) {
			System.err.println("allow Location Button  not present");
		}
		takeScreenshotAs("allowLocationButton2");
	}
	
	//Dynamic device orientation changing method 
	public static void deviceOrientationChangeTest(Integer zvalue) {
		driver.rotate(new DeviceRotation(0, 0, zvalue));
		takeScreenshotAs("deviceOrientationChangeTest");
		HelperPage.sleep(2);
	}
}
