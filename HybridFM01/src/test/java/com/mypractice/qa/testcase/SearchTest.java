package com.mypractice.qa.testcase;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mypractice.qa.base.BaseClass;
import com.mypractice.qa.pages.HomePage;
import com.mypractice.qa.pages.SearchPage;

public class SearchTest extends BaseClass {
	
	public SearchTest() {
		super();
	}
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(configProperties.getProperty("browserName"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.findProductSearchOption();
		homePage.searchWithValidProduct(testdataProperties.getProperty("validSearchItem"));
		homePage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		searchPage.searchValidProduct();
		
		/*
		driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();
		driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(testdataProperties.getProperty("validSearchItem"));
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("((//h2[text()='Rs. 400'])[1]")).isDisplayed());
	*/
	}
	
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		HomePage homePage = new HomePage(driver);
		homePage.findProductSearchOption();
		homePage.searchWithValidProduct(testdataProperties.getProperty("invalidSearchItem"));
		homePage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		searchPage.searchInvalidProduct();
		
		/*
		driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();
		driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(testdataProperties.getProperty("invalidSearchItem"));
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());*/
		
	}
	
	

}
