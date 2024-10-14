package com.mypractice.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
WebDriver driver;
	
	// Objects
	@FindBy(xpath = "((//h2[text()='Rs. 400'])[1]")
	private WebElement validProduct;
	
	@FindBy(xpath = "//h2[@class='title text-center']")
	private WebElement InvalidProduct;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//Actions
	public boolean searchValidProduct() {
		return validProduct.isDisplayed();
	}
	
	public boolean searchInvalidProduct() {
		return InvalidProduct.isDisplayed();
	}

}
