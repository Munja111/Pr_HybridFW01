package com.mypractice.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	// Objects
	@FindBy(xpath = "//i[@class='fa fa-lock']")
	private WebElement loginAndSignup;
	
	@FindBy(xpath = "//i[@class='material-icons card_travel']")
	private WebElement findProductSearchPage;
	
	@FindBy(xpath = "//input[@id='search_product']")
	private WebElement searchProduct;
	
	@FindBy(xpath = "//button[@id='submit_search']")
	private WebElement searchIcon;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // or you can write (driver, HomePage.class)
	}
	
	//Actions
	public void clickOnLoginSignupMenu() {
		loginAndSignup.click();
	}
	
	public void findProductSearchOption() {
		findProductSearchPage.click();
	}
	
	public void searchWithValidProduct(String productText) {
		searchProduct.sendKeys(productText);
	}

	public void clickOnSearchButton() {
		searchIcon.click();
		
	}

}
