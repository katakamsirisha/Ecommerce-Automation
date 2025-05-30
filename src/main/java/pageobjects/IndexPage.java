package pageobjects;

import actiondriver.newAction;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicReference;

public class IndexPage extends BaseClass {

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInBtn;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement myStoreLogoElement;

    @FindBy(id = "search_query_top")
    WebElement Searchtextbox;

    @FindBy(name = "submit_search")
    WebElement searchbutton;

    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickOnSignIn() throws Throwable {
        signInBtn.click();
        return new LoginPage();
    }
    public boolean validateLogo() throws Throwable {
        return myStoreLogoElement.isDisplayed();
    }
    public String getMyStoreTitle() {
        String myStoreTitle = driver.getTitle();
        return myStoreTitle;
    }
    public SearchResultPage SearchProduct(String productName) throws Throwable {
        Searchtextbox.sendKeys(productName);
        searchbutton.click();
        return new SearchResultPage();
    }



}
