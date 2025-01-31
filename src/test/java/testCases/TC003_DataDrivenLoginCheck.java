package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviderss;

public class TC003_DataDrivenLoginCheck extends BaseClass {

	@Test(dataProvider="dp",dataProviderClass=DataProviderss.class,groups= {"datadriven","master"})
	public void loginCheck(String username,String password,String result) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		Homepage page=new Homepage(driver);
		page.clickMyAccount();
		page.clickLogin();


		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(username);
		lp.setPassword(password);
		lp.clickLogin();

		MyAccountPage mp=new MyAccountPage(driver);


		// Data is valid --- login Success --- Passed TC
		//                            --- login Failed ---Failed TC Bug.


		if (result.equalsIgnoreCase("valid")) {
			if (mp.isMyAccounttextdisplayed()) {
				mp.clickLogout();
				System.out.println("TestCase Passed");
				Assert.assertTrue(true);
			} else {
				System.out.println("Login Not Happened Report Bug!!!");
				Assert.fail("Valid credentials failed to log in.");
			}
		} 
		else if (result.equalsIgnoreCase("invalid"))
		{
			if (mp.isMyAccounttextdisplayed()) {
				mp.clickLogout();
				System.out.println("TestCase Failed Report Bug!!!");
				Assert.fail("Invalid credentials logged in.");
			} else {
				System.out.println("TestCase Passed");
				Assert.assertTrue(true);
			}
		} else {
			System.out.println("Unexpected result parameter: " + result);
			Assert.fail("Invalid test data result parameter: " + result);
		}


	}

}
