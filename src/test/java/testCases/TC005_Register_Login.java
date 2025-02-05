package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import pageObject.Registrationpage;
import testBase.BaseClass;

public class TC005_Register_Login extends BaseClass {

	@Test(groups= {"sanity","master"})
	public void testcaseRegister_login() throws InterruptedException {
//Homepage		
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickMyRegister();

//Regostration Page
		Registrationpage page=new Registrationpage(driver);
		
		page.setFirstname(getalphabetic());
		page.setLastname(getalphabetic());
	String email=getnumericalphabetic()+"@gmail.com";
		page.setEmail(email);
		page.setTelephone(getnumeric());
	String pass=getnumericalphabetic();
		
		page.setPassword(pass);
		page.setConfirmPassword(pass);
		page.clickPrivacyPolicy();
		
		page.clickContinue();
		
		page.clicklogout();
 
//MyAccountpage
		hp.clickMyAccount();
		MyAccountPage mp=new MyAccountPage(driver);
		mp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassword(pass);
		lp.clickLogin();
		
		Boolean msg=mp.isMyAccounttextdisplayed();
		if(msg)
		{
			Assert.assertTrue(true);
		}
		else Assert.fail();
		

	}
	
}
