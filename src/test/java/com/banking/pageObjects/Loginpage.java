package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
		WebDriver driver;
		
		public Loginpage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
		
	@FindBy(xpath = "//input[@onkeyup=\"validateuserid();\"]")
	private WebElement userid;
	@FindBy(xpath = "//input[@onkeyup=\"validatepassword();\"]")
	private WebElement password;
	@FindBy(xpath = "//input[@value=\"LOGIN\"]")
	private WebElement loginbutton;
	
	
	public void Enterusername(String Username) {
		userid.sendKeys(Username);
	}
	
	public void EnteruserPassword(String Passwor) {
		password.sendKeys(Passwor);
	}
	public void ClickOnLogin() {
		loginbutton.click();
	}
	
	public void SwitchToFrame() {
		driver.switchTo().frame(0);
	}
}
