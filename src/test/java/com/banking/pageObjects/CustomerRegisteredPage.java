package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRegisteredPage {

	WebDriver driver;

	public CustomerRegisteredPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement customerregistername;
	@FindBy(xpath = "//*[contains(text(),'Welcome To Manager')]")
	private WebElement verify;

	public void ClickOnContinueButton() {
		customerregistername.click();
	}

	public String VerifyLastName() {
		String text = verify.getText();
		return text;

	}

}
