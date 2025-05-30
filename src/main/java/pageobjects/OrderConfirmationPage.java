package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {
    @FindBy(xpath = "//p[contains(text(),'Your order on My Shop is complete.')]")
    WebElement confirmMsg;
    public OrderConfirmationPage(){
        PageFactory.initElements(driver, this);
    }

    public String setConfirmMsg() {
        this.confirmMsg=confirmMsg;

        return null;
    }
}

