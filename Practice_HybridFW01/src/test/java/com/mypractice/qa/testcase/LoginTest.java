package com.mypractice.qa.testcase;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mypractice.qa.base.BaseClass;
import com.mypractice.qa.pages.HomePage;
import com.mypractice.qa.pages.LandingPage;
import com.mypractice.qa.pages.LoginPage;
import com.mypractice.qa.utils.Utilities;

public class LoginTest extends BaseClass {

	public LoginTest() { // using constructor to load prop file
		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		// loadPropertiesFile(); // this is the one way to load properties file or you
		// can call it through constructor

		driver = initializeBrowser(configProperties.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginSignupMenu();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	/*
	 * // SIMPLE APPROACH TO VLAIDATE LOGIN SUCCESS // Verify if the login was
	 * successful by checking if the text contains the username "qauser" String
	 * expectedText = "qauser"; String actualText = loggedInUser.getText(); if
	 * (actualText.equals(expectedText)) {
	 * System.out.println("Login successful: User logged in as " + actualText); }
	 * else { System.out.println("Login failed: Expected 'qauser' but found " +
	 * actualText); }
	 */

	

	@Test(priority = 1, dataProvider ="validCredentialSupplier") // here we can use dataProvider as method(dataSupply) name or name(validCredentialSupplier) provide to dataprovider
	public void verifyLoginWithValidCredential(String email, String  password) {
		
		// Validate login functionality
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		
		
		LandingPage landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.getUserName(), "AryanK");
		
		
		
		

		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String actualText = wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-user']/following-sibling::b")))
				.getText();*/
		
	}
	
	
	@DataProvider(name="validCredentialSupplier") 
	
	public Object[][] dataSupply() {
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	/*
	// USED HARD CODED DATA
	@DataProvider(name="validCredentialSupplier") 
	
	public Object[][] dataSupply() {
		
		Object[][] data = { { "ypmtest1@yp.com", "Asdf@111" }, { "ypmtest3@yp.com", "Asdf@111" }};
		
		return data;
	}
	*/
	
	/*
	Object[][] testData = Utilities.getTestDataFromExcel("D:\\AIM\\Selenium_Automation_Practice\\HybridFM01\\testdata\\DDT_For_LoginPage.xlsx", "Login");

	*/

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredential() {
		
		// Login process with invalid credentials
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(Utilities.genEmailWithTimestamp());
		loginPage.enterPassword(testdataProperties.getProperty("invalidpassword"));
		loginPage.clickOnLogin();
		
		String actualMessage = loginPage.getWarningMessage();
		String expectedMessage = testdataProperties.getProperty("warnMessageForInvalidCredential");

		Assert.assertEquals(actualMessage, expectedMessage, "Expected error message was not found");
		
		
		/*
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(Utilities.genEmailWithTimestamp());
		driver.findElement(By.xpath("//input[@data-qa='login-password']"))
				.sendKeys(testdataProperties.getProperty("invalidpassword"));
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String actualMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")))
				.getText();
		String expectedMessage = testdataProperties.getProperty("warnMessageForInvalidCredential");

		Assert.assertEquals(actualMessage, expectedMessage, "Expected error message was not found");
		
		*/

		// Alternatively, you could use if-else to validate:
		/*
		 * if (actualMessage.equals(expectedMessage)) {
		 * System.out.println("Login failed as expected: " + actualMessage); } else {
		 * System.out.println("Unexpected message found: " + actualMessage); }
		 */
	}
	
	

}
