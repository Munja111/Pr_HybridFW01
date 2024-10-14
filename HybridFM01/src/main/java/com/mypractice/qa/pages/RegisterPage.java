package com.mypractice.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	@FindBy (xpath="//input[@data-qa='signup-name']")
	private WebElement nameFieldSignup;
	
	@FindBy (xpath="//input[@data-qa='signup-email']")
	private WebElement emailFieldSignup;
	
	@FindBy (xpath="//button[@data-qa='signup-button']")
	private WebElement clickOnSignUp;
	
	@FindBy (xpath="//input[@id='id_gender1']")
	private WebElement genderSelectionMale;
	
	@FindBy (xpath="//input[@id='id_gender2']")
	private WebElement genderSelectionFemale;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy (xpath="//input[@id='newsletter']")
	private WebElement checkboxSelection;
	
	@FindBy (xpath="//input[@id='first_name']")
	private WebElement firstNameField;
	
	@FindBy (xpath="//input[@id='last_name']")
	private WebElement lastNameField;
	
	@FindBy (xpath="//input[@id='address1']")
	private WebElement address1Field;
	
	@FindBy (xpath="//input[@id='address2']")
	private WebElement address2Field;
	
	@FindBy (xpath="//input[@id='state']")
	private WebElement stateField;
	
	@FindBy (xpath="//input[@id='city']")
	private WebElement cityField;
	
	@FindBy (xpath="//input[@id='zipcode']")
	private WebElement zipcodeField;
	
	@FindBy (xpath="//input[@id='mobile_number']")
	private WebElement mobileNumerField;
	
	@FindBy (xpath="//button[contains(text(),'Create Account')]")
	private WebElement clickOnCreateButton;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // or you can write (driver, HomePage.class)
	}
	
	//Actions
	public void enterUserName(String userNameText) {
		nameFieldSignup.sendKeys(userNameText);
	}
	
	public void enterEmail(String emailText) {
		emailFieldSignup.sendKeys(emailText);
	}
	
	public void clickSignupButton() {
		clickOnSignUp.click();
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void selectGenderM() {
		genderSelectionMale.click();
	}
	
	public void selectGenderF() {
		genderSelectionFemale.click();
	}
	
	public void selectCheckbox() {
		checkboxSelection.click();
	}
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterAddress1(String address1Text) {
		address1Field.sendKeys(address1Text);
	}
	
	public void enterAddress2(String address2Text) {
		address2Field.sendKeys(address2Text);
	}
	
	public void enterState(String stateNameText) {
		stateField.sendKeys(stateNameText);
	}
	
	public void enterCity(String cityNameText) {
		cityField.sendKeys(cityNameText);
	}
	
	public void enterZipcode(String zipNumber) {
		zipcodeField.sendKeys(zipNumber);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		mobileNumerField.sendKeys(mobileNumber);
	}
	
	public void clcikOnCreateAccountButton() {
		clickOnCreateButton.click();
	}
	
	

}
