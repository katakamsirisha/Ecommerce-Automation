package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {

    @FindBy(xpath = "//h3[text()='Create an account']")
    WebElement formTitle;

    public AccountCreationPage() {
        PageFactory.initElements(driver, this);
    }
    public boolean validateAccountcreatepage() throws Throwable {
        return formTitle.isDisplayed();
    }
}