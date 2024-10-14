package com.mypractice.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;

	// Objects
	@FindBy(xpath = "//i[@class='fa fa-user']/following-sibling::b")
	private WebElement userName;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // or you can write (driver, HomePage.class)
	}

	// Actions
	public boolean getUserName() {
		return userName.isDisplayed();
		
		}

}
