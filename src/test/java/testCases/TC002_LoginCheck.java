package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginCheck extends BaseClass {

	@Test(groups={"master","regression"})
	public void loginCheck() throws InterruptedException {
		
		logger.info("----------TC002_LoginCheck_TestCAse_Started---------");
		Homepage page=new Homepage(driver);
		page.clickMyAccount();
		page.clickLogin();
		
		logger.info("Login Page opened.........");
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(pro.getProperty("username"));
		lp.setPassword(pro.getProperty("password"));
		lp.clickLogin();
		logger.info("Login Successfull..........");
		MyAccountPage mp=new MyAccountPage(driver);
		
		Thread.sleep(10000);
		if(mp.isMyAccounttextdisplayed())
		{
			Assert.assertTrue(true);
			logger.info("Validation of Myaccount Successfull.....");
		}
		else
		{
			logger.debug("TestCAse Failed.......");
			Assert.fail();
		}
	}
	
}
