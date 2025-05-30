package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BaseClass {
    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    WebElement confirmOrderBtn;

    public OrderSummaryPage() {
        PageFactory.initElements(driver, this);
    }

    public OrderConfirmationPage setConfirmOrderBtn() {
        this.confirmOrderBtn = confirmOrderBtn;
        return new OrderConfirmationPage();
    }
}
