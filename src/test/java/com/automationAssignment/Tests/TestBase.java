package com.automationAssignment.Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import ru.yandex.qatools.allure.annotations.Step;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.automationAssignment.Pages.TestDataReading;
import com.automationAssignment.platform.Android;

public abstract class TestBase {

	private final static String URL_STRING = "http://127.0.0.1:4723/wd/hub";

	public static AppiumDriver<MobileElement> driver;
	static WebDriverWait wait;

	public static final String File_TestData = "AutomationAssignment.xlsx";
	
	protected TestDataReading testDataReading = new TestDataReading(File_TestData);

	public TestBase() throws Exception {
	
	}

	@BeforeTest
	public abstract void setUpPage() throws Exception;

	/* This is to select which Platform against this testcase
	 * is going to run.
	 */
	@Parameters("platform")
	@BeforeSuite
	public static void initAppium(String platform) throws MalformedURLException {

		URL url = new URL(URL_STRING);
		
		String appDir = System.getProperty("user.dir"); 
		
		if(platform.equalsIgnoreCase("Android")) {
			DesiredCapabilities capabilitiesAndroid = new DesiredCapabilities();
			capabilitiesAndroid.setCapability(MobileCapabilityType.PLATFORM_NAME, Android.platformName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.DEVICE_NAME, Android.deviceName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.AUTOMATION_NAME, Android.automationName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.APP, appDir + "/TestingApps/" + Android.appName);
			capabilitiesAndroid.setCapability("appPackage", Android.appPackage);
			capabilitiesAndroid.setCapability(MobileCapabilityType.NO_RESET, false);

			driver = new AppiumDriver<MobileElement>(url, capabilitiesAndroid);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if(platform.equalsIgnoreCase("iOS")) {
			System.out.println("ABC"+Thread.currentThread().getId());
		}
	}

	@Step("Closing the test")
	@AfterSuite
	public void tearDownAppium() {
		if (driver != null) {
			driver.quit();
		}
	}
}