package com.mypractice.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	
	// Objects
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailFieldLogin;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordFieldLogin;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginbutton;
	
	@FindBy(xpath ="//p[contains(text(),'Your email or password is incorrect!')]")
	private WebElement warnMessageForInvalidEmail;

	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//Actions
	public void enterEmail(String emailText) {
		emailFieldLogin.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordFieldLogin.sendKeys(passwordText);
	}
	
	public void clickOnLogin() {
		loginbutton.click();
	}
	
	public String getWarningMessage() {
		return warnMessageForInvalidEmail.getText();
	}

}
