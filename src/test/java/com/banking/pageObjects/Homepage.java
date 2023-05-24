package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	private WebElement newcustomer;
	@FindBy(xpath = "//input[@name=\"name\"]")
	private WebElement customername;
	@FindBy(xpath = "//input[@value='m']")
	private WebElement checkbox;
	@FindBy(xpath = "//input[@name=\"dob\"]")
	private WebElement calander;
	@FindBy(xpath = "//*[@name=\"addr\"]")
	private WebElement addres;
	@FindBy(xpath = "//input[@name=\"city\"]")
	private WebElement city;
	@FindBy(xpath = "//input[@name=\"state\"]")
	private WebElement state;
	@FindBy(xpath = "//input[@name=\"pinno\"]")
	private WebElement pin;
	@FindBy(xpath = "//input[@name=\"telephoneno\"]")
	private WebElement mobile;
	@FindBy(xpath = "//input[@name=\"emailid\"]")
	private WebElement email;
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement password;
	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement submit;


	public void ClickOnNewCustomer() {
		newcustomer.click();
	}

	public void EnteruserCustomerName(String Customer) {
		customername.sendKeys(Customer);
	}

	public void ClickOnCheckBox() {
		checkbox.click();
	}

	public void ClickOnCalander(String Data) {
		calander.sendKeys(Data);

	}

	public void EnterAddres(String Addres) {
		addres.sendKeys(Addres);

	}

	public void EnterCity(String City) {
		city.sendKeys(City);

	}

	public void EnterState(String State) {
		state.sendKeys(State);

	}

	public void EnterPin(String Pin) {
		pin.sendKeys(Pin);

	}

	public void EnterMoblieNumber(String Moblie) {
		mobile.sendKeys(Moblie);

	}

	public void EnterEmailAddres(String Email) {
		email.sendKeys(Email);

	}

	public void EnterPassWord(String Password) {
		password.sendKeys(Password);

	}

	public void ClickOnSubmit() {
		submit.click();

	}
	
}
