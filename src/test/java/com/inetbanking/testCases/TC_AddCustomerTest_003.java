package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("user name is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Providing customer details...");
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		addcust.custName("Santosh");
		addcust.custgender("male");
		addcust.custdob("14","06","1995");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("PUN");
		addcust.custstate("MH");
		addcust.custpinno("600252");
		addcust.custtelephoneno("6532869523");
		
		String email = randomeString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validations started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	    if(res == true)
	    {
	    	Assert.assertTrue(true);
	    	logger.info("test case passed...");
	    }
	    else
	    {
	    	logger.info("test case failed...");
	    	captureScreen(driver,"addNewCustomer");
	    	Assert.assertTrue(false);
	    }
		
	}
	
	
	

}
