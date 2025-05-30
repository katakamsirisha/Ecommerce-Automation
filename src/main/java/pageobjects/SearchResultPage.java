package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class SearchResultPage extends BaseClass {
    @FindBy(xpath ="//*[@class='replace-2x img-responsive']")
     WebElement productresult;

    @FindBy(id = "color_8")
    WebElement whtbtn;

    public SearchResultPage() {

        PageFactory.initElements(driver, this);
    }

    public void setProductresult(WebElement productresult) throws Throwable{
        this.productresult = productresult;
    }
    public AddToCartPage clickOnProduct() throws Throwable{
        productresult.click();
        Thread.sleep(2000);
        whtbtn.click();
        return new AddToCartPage();
    }
}
