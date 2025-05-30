package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AccountCreationPage;
import pageobjects.Homepage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    Homepage homePage;
    AccountCreationPage accountCreationPage;

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
    public void verifyCreateAccountPageTest() throws Throwable {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        AccountCreationPage accountCreationPage = loginPage.createNewAccount("admin@gmail.com");
        boolean result = accountCreationPage.validateAccountcreatepage();
        Assert.assertTrue(result);
    }

}
