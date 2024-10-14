package com.mypractice.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.mypractice.qa.utils.Utilities;

public class BaseClass {

	WebDriver driver;
	public Properties configProperties;
	public Properties testdataProperties;

	public BaseClass() {
		configProperties = new Properties();
		testdataProperties = new Properties();
		
	    File configFile = new File(System.getProperty("user.dir") + "\\config\\config.properties");
	    try {
	        FileInputStream fis_configFile = new FileInputStream(configFile);
	        configProperties.load(fis_configFile);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    File testdataFile = new File(System.getProperty("user.dir") + "\\testdata\\testdata.properties");
	    try {
	        FileInputStream fis_testdataFile = new FileInputStream(testdataFile);
	        testdataProperties.load(fis_testdataFile); // Use testdataProperties instead
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

	public WebDriver initializeBrowser(String browserName) {
	    if (browserName.equals("chrome")) {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");
	        driver = new ChromeDriver(options);  
	    } else if (browserName.equals("firefox")) {	        
	        FirefoxOptions options = new FirefoxOptions();
	        options.addArguments("-private");  
	        driver = new FirefoxDriver(options);  
	    } else if (browserName.equals("edge")) {	        
	        EdgeOptions options = new EdgeOptions();
	        options.addArguments("-inprivate");  
	        driver = new EdgeDriver(options);  
	    }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
	    driver.get(configProperties.getProperty("url"));

	    return driver;
	}
}
