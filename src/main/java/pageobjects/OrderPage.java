package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {
    @FindBy(xpath = "//td[@class='cart_unit']/ul/li")
    WebElement unitPrice;
    @FindBy(xpath = "//span[@id='total_price']")
    WebElement totalprice;
    @FindBy(xpath = "//a[@title='Proceed to checkout'][@class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedtocheckout;

    public OrderPage() {
        PageFactory.initElements(driver, this);
    }

    public double getUnitPrice() {
        String unitPrice1 = unitPrice.getText();
        String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
        double finalUnitPrice = Double.parseDouble(unit);
        return finalUnitPrice / 100;
    }

    public double getTotalPrice() {
        String totalPrice1 = unitPrice.getText();
        String tot = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
        double finalTotalPrice = Double.parseDouble(tot);
        return finalTotalPrice / 100;
    }
    public LoginPage setProceedtocheckout() throws Throwable{
        proceedtocheckout.click();
        return new LoginPage();
    }


}
