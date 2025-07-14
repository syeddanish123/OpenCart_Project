package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.Registrationpage;
import testBase.BaseClass;
import utilities.RandomStringUtility;

public class TC001_RegistrationCheck extends BaseClass {

	@Test(groups={"sanity","master"})
	public void verify_account_registration(){
		
	    logger.info("Test Case Started.......");
		Homepage homepage=new Homepage(driver);
		homepage.clickMyAccount();
		homepage.clickMyRegister();

		logger.info("Registration begin.......");
		
		Registrationpage regpage=new Registrationpage(driver);
		regpage.setFirstname(RandomStringUtility.getalphabetic());
		regpage.setLastname(RandomStringUtility.getalphabetic());
		regpage.setEmail(RandomStringUtility.getalphabetic()+"@gmail.com");
		regpage.setTelephone(RandomStringUtility.getnumeric());
		    
		String password=RandomStringUtility.getnumericalphabetic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.clickPrivacyPolicy();
		regpage.clickContinue();
    
		logger.info("Regoistration End.......");
		
		
		String message=regpage.getConfirmationMessage();
		
		if(message.equalsIgnoreCase("Your Account Has Been Created!"))
		{
			logger.info("Validation Success Tc-verify_account_registration passed");
		    logger.warn("Completed/..");
			Assert.assertTrue(true);
		}
		else {
			logger.debug("Test Case Failed...");
			logger.trace("Failed Test Case....");
			logger.error("Failed...");
			 Assert.assertTrue(false);
		}
		
	}

}
