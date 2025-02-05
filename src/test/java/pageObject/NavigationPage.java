package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Basepage;

public class NavigationPage extends Basepage {

	Actions ac;
	
	public NavigationPage(WebDriver driver) {
		
		super(driver);
	
	}

@FindBy(xpath="//a[@class='dropdown-toggle'][normalize-space()='Desktops']")
WebElement lnkDesktop;
	
@FindBy(xpath="//a[normalize-space()='Mac (1)']")
WebElement lnkMac;	


	
	public void clickDesktop() {
		
		lnkDesktop.click();
	}
	
	public void clickOnMac() {
		
		lnkMac.click();
	}
}
