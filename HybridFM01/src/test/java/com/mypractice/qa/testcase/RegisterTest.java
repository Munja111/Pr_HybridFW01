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
	public void testUserOneRegistration() {
		
		
		RegisterPage registerPage = new RegisterPage(driver);
		
		System.out.println("Registering User 1 with: " + testdataProperties.getProperty("usernameOne"));
		registerPage.enterUserName(testdataProperties.getProperty("usernameOne"));
		registerPage.enterEmail(Utilities.genEmailWithTimestamp());
		registerPage.clickSignupButton();
		registerPage.selectGenderM();
		registerPage.enterPassword(testdataProperties.getProperty("pwdOne"));
		registerPage.selectCheckbox();
		registerPage.enterFirstName(testdataProperties.getProperty("firstname_O"));
		registerPage.enterLastName(testdataProperties.getProperty("lastname_O"));
		registerPage.enterAddress1(testdataProperties.getProperty("Address1_O"));
		registerPage.enterAddress2(testdataProperties.getProperty("Address2_O"));
		registerPage.enterState(testdataProperties.getProperty("state_O"));
		registerPage.enterCity(testdataProperties.getProperty("city_O"));
		registerPage.enterZipcode(testdataProperties.getProperty("zipcode_O"));
		registerPage.enterMobileNumber(testdataProperties.getProperty("mobilenumber_O"));
		registerPage.clcikOnCreateAccountButton();

		RegisterSuccessPage success = new RegisterSuccessPage(driver);
		success.testRegistrationSuccessMessage();
		success.clickOnContiniueButton();
	}

	@Test(priority = 2)
	public void testUserTwoRegistration() {

		RegisterPage registerPage = new RegisterPage(driver);
		System.out.println("Registering User 2 with: " + testdataProperties.getProperty("usernameTwo"));
		registerPage.enterUserName(testdataProperties.getProperty("usernameTwo"));
		registerPage.enterEmail(Utilities.genEmailWithTimestamp());
		registerPage.clickSignupButton();
		registerPage.selectGenderF();
		registerPage.enterPassword(testdataProperties.getProperty("pwdTwo"));
		registerPage.selectCheckbox();
		registerPage.enterFirstName(testdataProperties.getProperty("firstname_T"));
		registerPage.enterLastName(testdataProperties.getProperty("lastname_T"));
		registerPage.enterAddress1(testdataProperties.getProperty("Address1_T"));
		registerPage.enterAddress2(testdataProperties.getProperty("Address2_T"));
		registerPage.enterState(testdataProperties.getProperty("state_T"));
		registerPage.enterCity(testdataProperties.getProperty("city_T"));
		registerPage.enterZipcode(testdataProperties.getProperty("zipcode_T"));
		registerPage.enterMobileNumber(testdataProperties.getProperty("mobilenumber_T"));
		registerPage.clcikOnCreateAccountButton();

		RegisterSuccessPage success = new RegisterSuccessPage(driver);
		success.testRegistrationSuccessMessage();
		success.clickOnContiniueButton();

		
/*
		driver.findElement(By.xpath("//input[@data-qa='signup-name']"))
				.sendKeys(testdataProperties.getProperty("usernameTwo"));
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(Utilities.genEmailWithTimestamp());

		// driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ypmtest8@yp.com");

		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(testdataProperties.getProperty("pwdTwo"));

		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		driver.findElement(By.xpath("//input[@id='first_name']"))
				.sendKeys(testdataProperties.getProperty("firstname_T"));
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(testdataProperties.getProperty("lastname_T"));
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(testdataProperties.getProperty("Address1_T"));
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(testdataProperties.getProperty("Address2_T"));

		driver.findElement(By.xpath("//input[@id='state']")).sendKeys(testdataProperties.getProperty("state_T"));
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(testdataProperties.getProperty("city_T"));
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(testdataProperties.getProperty("zipcode_T"));
		driver.findElement(By.xpath("//input[@id='mobile_number']"))
				.sendKeys(testdataProperties.getProperty("mobilenumber_T"));

		driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String actualText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(),'Congratulations! Your new account has been successfully')]")))
				.getText();
		Assert.assertEquals(actualText, "Congratulations! Your new account has been successfully created!",
				"Registration failed");

		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();*/

	}

}
