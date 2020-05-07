package com.automationAssignment.Pages.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationAssignment.Pages.HelperPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends HelperPage {
	
	@FindBy(id = "sign_in_button")
	protected WebElement LoginButton;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='ap_email_login']")
	protected WebElement emailTextField;
	
	@FindBy(xpath = "//android.widget.Button[@text='Continue']")
	protected WebElement continueButton;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='ap_password']")
	protected WebElement enterPassword;
	
	@FindBy(xpath  = "//android.widget.Button[@resource-id='signInSubmit']")
	protected WebElement signInSubmitButton;

	public LoginPage(AppiumDriver<MobileElement> driver) throws Exception {
		super(driver);
	}
	
	@Step("Verify login page")
	public void CheckLoginPageForExceptions() {
		LoginButton.isDisplayed();
	}
	
	@Step("Clicking on login button")
	public void clickLoginButton() {
		LoginButton.click();
		takeScreenshotAs("login2");
	}
	
	@Step("Enter valid username")
	public void enterUsername(String username) {
		takeScreenshotAs("enterUsername");
		HelperPage.sleep(5);
		emailTextField.sendKeys(username);
		takeScreenshotAs("enterUsername2");
	}
	
	@Step("Entering on empty input to username textbox")
	public void enterEmptyUsername() {
		takeScreenshotAs("enterEmptyUsername");
		emailTextField.sendKeys("");
		takeScreenshotAs("enterEmptyUsername2");
	}
	
	@Step("Entering on invalid input to username textbox")
	public void enterInvalidUsername(String invalidnumber) {
		takeScreenshotAs("enterInvalidUsername");
		HelperPage.sleep(5);
		emailTextField.clear();
		emailTextField.sendKeys(invalidnumber);
		takeScreenshotAs("enterInvalidUsername2");
	}
	
	@Step("Clicking on continue button")
	public void clickContinueButton() {
		takeScreenshotAs("continueButton");
		continueButton.click();
		takeScreenshotAs("continueButton2");
	}
	
	@Step("Entering on valid input to password textbox")
	public void enterPassword(String password) {
		takeScreenshotAs("enterPassword");
		HelperPage.sleep(5);
		enterPassword.sendKeys(password);
		takeScreenshotAs("enterPassword2");
	}
	
	@Step("Passing empty input to password textbox")
	public void enterEmptyPassword() {
		takeScreenshotAs("enterEmptyPassword");
		HelperPage.sleep(5);
		enterPassword.sendKeys("");
		takeScreenshotAs("enterEmptyPassword2");
	}
	
	@Step("Passing invlalid input to password textbox")
	public void enterInvalidPassword(String InvalidPassword) {
		takeScreenshotAs("enterInvalidPassword");
		HelperPage.sleep(5);
		enterPassword.sendKeys(InvalidPassword);
		takeScreenshotAs("enterInvalidPassword2");
	}

	@Step("Clicking on Submit Button")
	public void signInSubmitButton() {
		takeScreenshotAs("signInSubmitButton");
		signInSubmitButton.click();
		takeScreenshotAs("signInSubmitButton2");
	}
}
