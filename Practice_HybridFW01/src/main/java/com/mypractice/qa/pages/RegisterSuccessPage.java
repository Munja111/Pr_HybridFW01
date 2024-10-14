package com.mypractice.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccessPage {
	
WebDriver driver;
	
	@FindBy (xpath="//p[contains(text(),'Congratulations! Your new account has been successfully')]")
	private WebElement successText;
	
	@FindBy (xpath="//a[@class='btn btn-primary']")
	private WebElement clickContinue;
	
	
	public RegisterSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//Actions
	public String testRegistrationSuccessMessage() {
		return successText.getText();
	}
	
	public void clickOnContiniueButton() {
		clickContinue.click();
	}

}
