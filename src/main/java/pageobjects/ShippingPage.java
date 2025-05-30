package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {
    @FindBy(id = "cgv")
    WebElement terms;
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOutBtn;

    public ShippingPage() {
        PageFactory.initElements(driver, this);
    }

    public void setTerms() throws Throwable{
        this.terms = terms;
    }

    public PaymentPage setProceedToCheckOutBtn() throws Throwable {
        this.proceedToCheckOutBtn = proceedToCheckOutBtn;
        return new PaymentPage();
    }
}
