package com.automationAssignment.Tests.TestDemonstrationEcommerceSite;

import org.testng.annotations.Test;

import com.automationAssignment.Pages.HelperPage;
import com.automationAssignment.Pages.Login.LoginPage;
import com.automationAssignment.Pages.ProductSearch.ProductSearchPage;
import com.automationAssignment.Tests.TestBase;

import org.testng.annotations.BeforeTest;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class TestDemonstrationEcommerceSite extends TestBase {

	public TestDemonstrationEcommerceSite() throws Exception {
		super();
	}

	private LoginPage loginPage;
	private ProductSearchPage searchProductPage;
	
	String number = testDataReading.getCellData("Assignment", "Mobile Number", 2);
	String password = testDataReading.getCellData("Assignment", "Password", 2);
	String productName = testDataReading.getCellData("Assignment", "ProductSearch", 2);
	String ItemFromDropdown = testDataReading.getCellData("Assignment", "ItemFromDropdown", 2);
	String ItemSelection = testDataReading.getCellData("Assignment", "ItemSelection", 2);
	String InvalidNumber = testDataReading.getCellData("Assignment", "InvalidNumber", 2);
	String InvalidPassword = testDataReading.getCellData("Assignment", "InvalidPassword", 2);

	@BeforeTest
	public void setUpPage() throws Exception {
		loginPage = new LoginPage(driver);
		searchProductPage = new ProductSearchPage(driver);
	}

	/* This is a assginment test to add a 
	*  essential item to cart
	*/
	@Severity(SeverityLevel.CRITICAL)
	@Test
	@Description("This is coding demonstration test")
	public void automationAssignment() {
		loginPage.CheckLoginPageForExceptions();
		loginPage.clickLoginButton();
	
		HelperPage.deviceOrientationChangeTest(90);
		HelperPage.sleep(5);
		loginPage.enterEmptyUsername();
		loginPage.clickContinueButton();
		
		loginPage.enterInvalidUsername(InvalidNumber);
		loginPage.clickContinueButton();
		
		loginPage.enterUsername(number);
		loginPage.clickContinueButton();
		
		HelperPage.sleep(5);
		loginPage.enterEmptyPassword();
		loginPage.signInSubmitButton();
		
		loginPage.enterInvalidPassword(InvalidPassword);
		loginPage.signInSubmitButton();
		
		loginPage.enterPassword(password);
		loginPage.signInSubmitButton();
		
		HelperPage.closeButton();
		searchProductPage.clickSearchTextbox(productName);
		searchProductPage.clickFirstSuggestionFromSearchBox(ItemFromDropdown, ItemSelection);
		
		HelperPage.deviceOrientationChangeTest(0);
		HelperPage.sleep(5);
		
		HelperPage.closeButton();
		searchProductPage.selectItemAfterScroll();
		
		HelperPage.sleep(5);
		HelperPage.deviceOrientationChangeTest(270);
	}
}
