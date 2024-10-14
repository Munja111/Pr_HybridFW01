package Experiment;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite  \n");
	}
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest  \n");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass \n");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}

	
	@Test(priority = 1)
	public void test1() {
		System.out.println("Test1");
	}
	@Test(priority = 2)
	public void test2() {
		System.out.println("Test2");
	}
	@Test(priority = 3)
	public void test3() {
		System.out.println("Test3");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod \n");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass \n");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest \n");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite  \n");
	}
	
	
}
