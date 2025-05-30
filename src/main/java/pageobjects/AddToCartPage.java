package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    WebElement quantity;
    @FindBy(xpath = "//*[@id=\"group_1\"]")
    WebElement size;
    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    WebElement AddToCartBtn;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]//h2/i")
    WebElement AddToCartMsg;
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout)']")
    WebElement ProceedToCheckOutBtn;


    public AddToCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterQuantity(String s) throws Throwable {
        quantity.click();
    }

    public void setSize(String size) throws Throwable {
        setSize(size);


    }

    public void setAddToCartBtn() throws Throwable {
        setAddToCartBtn();
    }

    public boolean validateAddToCart() throws Throwable {
        Thread.sleep(3000);
        return AddToCartBtn.isDisplayed();
    }

    public OrderPage clickOnCheckOut() throws Throwable {
        Thread.sleep(5000);
        ProceedToCheckOutBtn.click();
        return new OrderPage();
    }


}


