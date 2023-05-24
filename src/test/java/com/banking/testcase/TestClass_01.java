package com.banking.testcase;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.banking.pageObjects.CustomerRegisteredPage;
import com.banking.pageObjects.Homepage;
import com.banking.pageObjects.Loginpage;
import com.banking.testData.Baseclass;

public class TestClass_01 extends Baseclass{
	
	@Test
	public void verifyRegistrationAndlogin() throws Exception {
		
	
		logger.info("maximaze window");
		driver.manage().window().maximize();
		
		Loginpage pg = new Loginpage(driver);
		pg.Enterusername("mngr453674");
		pg.EnteruserPassword("AnAhUsY");
		pg.ClickOnLogin();
		logger.info("Entering credential");
		
//		
//		if (driver.getTitle().equals(" Guru99 Bank Manager HomePage ")) {
//			
//			
//			Assert.assertTrue(true);
//		}else {
//			capturescreenshot(driver, "verifyRegistrationAndlogin");
//			Assert.assertFalse(false);	
//			}
//			pg.SwitchToFrame();
		
		
		Homepage pg1 = new Homepage(driver);
		
		pg1.ClickOnNewCustomer();
		pg1.EnteruserCustomerName("Sanju");
		pg1.ClickOnCheckBox();
		pg1.ClickOnCalander("05/12/1998");
		pg1.EnterAddres("House no 156 pune");
		pg1.EnterCity("pune");
		pg1.EnterState("Maharashra");
		pg1.EnterPin("123456");
		pg1.EnterMoblieNumber("9371827946");
		pg1.EnterEmailAddres("sanjuh416511j354664241@gmail.com");
		pg1.EnterPassWord("S123@");
		pg1.ClickOnSubmit();
		
		
		CustomerRegisteredPage pg2 = new CustomerRegisteredPage(driver);
		pg2.ClickOnContinueButton();
		String text = pg2.VerifyLastName();
		
		if (text.equals("Welcome To Manager's Page of Guru99 Bank12")) {
			
		assertTrue(true);
		}else {
			assertFalse(false);
			capturescreenshot(driver, "verifyRegistrationAndlogin");
		}
	}
}
