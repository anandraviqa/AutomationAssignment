package com.automationAssignment.Pages.ProductSearch;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automationAssignment.Pages.HelperPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import ru.yandex.qatools.allure.annotations.Step;

public class ProductSearchPage extends HelperPage {
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")
	protected WebElement searchTextBox;
	
	@FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[3]")
	protected WebElement selectItem;
	
	@FindBy(xpath = "//android.view.View[@resource-id='add-to-wishlist-button-submit'][@text='ADD TO WISH LIST']")
	protected WebElement wishlistButtonStack;
	
	@FindBy(xpath = "//android.widget.Button[@class='android.widget.Button']")
	protected MobileElement sizeButtons;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='add-to-cart-button']")
	protected MobileElement addToCartButton;

	public ProductSearchPage(AppiumDriver<MobileElement> driver) throws Exception {
		super(driver);
	}
	
	public void validateSearchPage() {
		searchTextBox.isDisplayed();
	}
	
	/*
	 * This methods performs following:
	 * Enters item to be searched from search box
	 */
	@Step("Click on search textbox and enter a product name to search")
	public void clickSearchTextbox(String productName) {
		takeScreenshotAs("searchTextBox");
		searchTextBox.click();
		HelperPage.sleep(5);
		searchTextBox.sendKeys(productName);
		driver.hideKeyboard();
		takeScreenshotAs("searchTextBox2");
	}
	
	/*
	 * This methods performs following:
	 * Clicks on first suggested option from search box
	 */
	@Step("Click on first suggested product from listing")
	public void clickFirstSuggestionFromSearchBox(String ItemFromDropdown, String ItemSelection) {
		takeScreenshotAs("firstSuggestedSearchClick");
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+ItemFromDropdown+"']")).click();
		takeScreenshotAs("firstSuggestedSearchClick2");
		
		/*Verify first Item*/
		String actualText = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ItemSelection+"']")).getText();
		assertEquals(actualText, ItemSelection);
		
	}
	
	/*
	 * This methods performs following:
	 * Select item which is needed to be added to wishlist
	 * Scrolling to Add the product to wishlist
	 */
	@Step("Click on Add to Cart button")
	public void selectItemAfterScroll() {
		takeScreenshotAs("selectItem");
		selectItem.click();
		HelperPage.sleep(5);
		HelperPage.closeButton();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
				+ "instance(0)).scrollIntoView(new UiSelector()."
				+ "textContains(\""+"Add to Cart"+"\").instance(0))"));
		addToCartButton.click();
		HelperPage.sleep(5);
		takeScreenshotAs("selectItem2");
	}

}
