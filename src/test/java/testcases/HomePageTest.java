package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Homepage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    Homepage homePage;
    @BeforeMethod
    public void setup() throws Throwable {
        launchApp();
        indexPage = new IndexPage();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
    @Test
    public void validateOrderHistory() throws Throwable {
        indexPage= new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        boolean result= homePage.validateorderhistory();
        Assert.assertTrue(result);
        System.out.println("My test case is passed");
    }
}
