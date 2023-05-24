package com.banking.testData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass1 {
	public String baseurl="//demo.guru99.com/v4/";
	public String username="san";
	public String password="ddsdf";
	public static WebDriver driver;
			
			@BeforeClass
			public void setup() {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
			}
			@AfterTest
			public void teardown() {
				driver.quit();
			}

}
