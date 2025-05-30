package pageobjects;

import actiondriver.newAction;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class Homepage extends BaseClass {

    @FindBy(xpath = "//span[text()='Order history and details']")
    WebElement orderhistory;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }


    public boolean validateorderhistory() throws Throwable {
        return orderhistory.isDisplayed();
    }
    public String getCurrURL() {
        String homePageURL= driver.getCurrentUrl();
        return homePageURL;
    }

    }


