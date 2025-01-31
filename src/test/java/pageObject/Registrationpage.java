package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.Basepage;

public class Registrationpage extends Basepage {

	
	public Registrationpage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmpassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkPrivacypolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement txtConfirmationmessage;

public void setFirstname(String fname) {
	
	txtFirstname.sendKeys(fname);
}

public void setLastname(String lname) {
	
	txtLastname.sendKeys(lname);
}

public void setEmail(String email) {
	
	txtEmail.sendKeys(email);
}

public void setTelephone(String tel) {
	
	txtTelephone.sendKeys(tel);
}

public void setPassword(String pwd) {
	
	txtPassword.sendKeys(pwd);
}

public void setConfirmPassword(String cnfpwd) {
	
	txtConfirmpassword.sendKeys(cnfpwd);
}

public void clickPrivacyPolicy() {
	
	chkPrivacypolicy.click();;
}

public void clickContinue() {
	
	btnContinue.click();
}

public String getConfirmationMessage() {
	
	try {
		
		 return (txtConfirmationmessage.getText());	
	}
	catch(Exception e) 
	{
		
		return (e.getMessage());
	}

}
}
