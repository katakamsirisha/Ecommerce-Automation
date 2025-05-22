package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {
    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
    WebElement bankWireMethod;

    @FindBy(xpath = "//a[contains(text(),'Pay by check ')]")
    WebElement payByCheckMethod;

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    public void setBankWireMethod(WebElement bankWireMethod) {
        this.bankWireMethod = bankWireMethod;
    }

    public OrderSummaryPage setPayByCheckMethod(WebElement payByCheckMethod) {
        this.payByCheckMethod = payByCheckMethod;
        return new OrderSummaryPage();
    }
}
