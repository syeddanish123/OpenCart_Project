package testCases;

import org.testng.annotations.Test;

import pageObject.MacPage;
import pageObject.NavigationPage;
import testBase.BaseClass;

public class TC004_VerifyMacProductSuccess_AddToCart extends BaseClass{

	@Test(groups="sanity")
	public void verifyMacAddToCart() throws InterruptedException {
		
		NavigationPage np=new NavigationPage(driver);
//		Thread.sleep(3000);
		np.clickDesktop();
	//	Thread.sleep(3000);
		np.clickOnMac();
		
		//Thread.sleep(3000);
		
		MacPage mp=new MacPage(driver);
		mp.clickAddToCart();
	//	Thread.sleep(3000);
		Boolean msg=mp.verifyText();
		
		System.out.println(msg);
	//	Thread.sleep(2000);
	}
	
}
