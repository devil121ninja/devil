package com.banking.testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Logger logger;
	 

	@BeforeTest
	public void setup() throws Exception {
		if (driver == null) {
			File propertiefile = new File(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			FileInputStream file = new FileInputStream(propertiefile);
			prop.load(file);
		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("baseUrl"));
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("baseUrl"));
		}
			
			  logger =LogManager.getLogger("OrangeHRM");
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
		
	@AfterTest
	public void teardown() {
		driver.close();
		System.out.println("driver is close");
	}
	
	
	
	public void capturescreenshot(WebDriver driver , String testname) throws Exception {
		
	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png");
	
	FileUtils.copyFile(scr, dest);
		
	}


	
	
	
}
