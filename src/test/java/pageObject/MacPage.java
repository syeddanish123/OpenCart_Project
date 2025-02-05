package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Basepage;

public class MacPage extends Basepage {

	
	public MacPage(WebDriver driver) {
		super(driver);
		
	}

@FindBy(xpath="//span[normalize-space()='Add to Cart']")
WebElement lnkAddtoCart;
	
@FindBy(xpath="(//a[normalize-space()='shopping cart'])[1]")
WebElement txtSuccessMessage;

public void clickAddToCart() {
	
	lnkAddtoCart.click();
}

public boolean verifyText() {
	
	System.out.println(txtSuccessMessage.getText());
	return (txtSuccessMessage.isDisplayed());
}

}
