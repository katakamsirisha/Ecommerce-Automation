package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Homepage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;

import java.time.Duration;

public class LoginPageTest extends BaseClass {
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
    public void loginTest() throws Throwable {
        loginPage = indexPage.clickOnSignIn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String actualURL = homePage.getCurrURL();
        String expectedURL1 = "http://www.automationpractice.pl/index.php?controller=my-account";
        String expectedURL2 = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
        if (actualURL.equals(expectedURL1)) {
            System.out.println("we got expectedurl1 in website");
        } else if (actualURL.equals(expectedURL2)) {
            System.out.println("we got expectedurl2 in website");
        } else {
            System.out.println("new expected result has been came");
            System.out.println(actualURL);
        }
    }
}
