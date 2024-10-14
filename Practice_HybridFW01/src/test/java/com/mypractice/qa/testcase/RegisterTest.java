package com.mypractice.qa.testcase;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mypractice.qa.base.BaseClass;
import com.mypractice.qa.pages.HomePage;
import com.mypractice.qa.pages.RegisterPage;
import com.mypractice.qa.pages.RegisterSuccessPage;
import com.mypractice.qa.utils.Utilities;

public class RegisterTest extends BaseClass {
	WebDriver driver;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(configProperties.getProperty("browserName"));

		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginSignupMenu();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void firstUserRegistration() {
		
		
		RegisterPage registerPage = new RegisterPage(driver);
		
		System.out.println("Registering User 1 with: " + testdataProperties.getProperty("usernameOne"));
		registerPage.enterUserName(testdataProperties.getProperty("usernameOne"));
		registerPage.enterEmail(Utilities.genEmailWithTimestamp());
		registerPage.clickSignupButton();
		registerPage.selectGenderM();
		registerPage.enterPassword(testdataProperties.getProperty("pwdOne"));
		registerPage.selectCheckbox();
		registerPage.enterFirstName(testdataProperties.getProperty("firstname_User1"));
		registerPage.enterLastName(testdataProperties.getProperty("lastname_User1"));
		registerPage.enterAddress1(testdataProperties.getProperty("Address1_User1"));
		registerPage.enterAddress2(testdataProperties.getProperty("Address2_User1"));
		registerPage.enterState(testdataProperties.getProperty("state_User1"));
		registerPage.enterCity(testdataProperties.getProperty("city_User1"));
		registerPage.enterZipcode(testdataProperties.getProperty("zipcode_User1"));
		registerPage.enterMobileNumber(testdataProperties.getProperty("mobilenumber_User1"));
		registerPage.clcikOnCreateAccountButton();

		RegisterSuccessPage success = new RegisterSuccessPage(driver);
		success.testRegistrationSuccessMessage();
		success.clickOnContiniueButton();
	}

	@Test(priority = 2)
	public void secondUserRegistration() {

		RegisterPage registerPage = new RegisterPage(driver);
		System.out.println("Registering User 2 with: " + testdataProperties.getProperty("usernameTwo"));
		registerPage.enterUserName(testdataProperties.getProperty("usernameTwo"));
		registerPage.enterEmail(Utilities.genEmailWithTimestamp());
		registerPage.clickSignupButton();
		registerPage.selectGenderF();
		registerPage.enterPassword(testdataProperties.getProperty("pwdTwo"));
		registerPage.selectCheckbox();
		registerPage.enterFirstName(testdataProperties.getProperty("firstname_User2"));
		registerPage.enterLastName(testdataProperties.getProperty("lastname_User2"));
		registerPage.enterAddress1(testdataProperties.getProperty("Address1_User2"));
		registerPage.enterAddress2(testdataProperties.getProperty("Address2_User2"));
		registerPage.enterState(testdataProperties.getProperty("state_User2"));
		registerPage.enterCity(testdataProperties.getProperty("city_User2"));
		registerPage.enterZipcode(testdataProperties.getProperty("zipcode_User2"));
		registerPage.enterMobileNumber(testdataProperties.getProperty("mobilenumber_User2"));
		registerPage.clcikOnCreateAccountButton();

		RegisterSuccessPage success = new RegisterSuccessPage(driver);
		success.testRegistrationSuccessMessage();
		success.clickOnContiniueButton();

	}

}
