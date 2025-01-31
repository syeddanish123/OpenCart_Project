package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.Basepage;

public class LoginPage extends Basepage {

	public LoginPage(WebDriver driver) {
		
		super(driver);	
		
	}
	
@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmailAddress;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@value='Login']")
WebElement lnkLogin;

public void setEmailAddress(String username) {
	
	txtEmailAddress.sendKeys(username);
}

public void setPassword(String password)
{
	txtPassword.sendKeys(password);
}

public void clickLogin() {
	
	lnkLogin.click();
}
}
