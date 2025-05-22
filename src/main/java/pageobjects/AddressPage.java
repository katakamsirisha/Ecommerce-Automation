package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {
    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement proceedToCheckOut;

    public AddressPage(){
        PageFactory.initElements(driver, this);

    }
    public ShippingPage setProceedToCheckOut() throws Throwable {
        proceedToCheckOut.click();
        return new ShippingPage();

    }

}
