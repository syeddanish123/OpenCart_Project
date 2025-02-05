package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.Basepage;

public class MyAccountPage extends Basepage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

@FindBy(xpath="//h2[normalize-space()='My Account']")
WebElement txtMyAccount;

@FindBy(linkText="Logout")
WebElement lnkLogout;

@FindBy(linkText="Login")
WebElement lnkLogin;

public Boolean isMyAccounttextdisplayed() {
	
	try {
		return (txtMyAccount.isDisplayed());
		
	}catch(Exception e)
	{
		return (txtMyAccount.isDisplayed());
	}
}

public void clickLogout() {
	
	lnkLogout.click();
}

public void clickLogin() {
	
	lnkLogin.click();
}
}
