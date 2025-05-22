package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
    IndexPage indexPage;
    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApp();
    }
    @AfterMethod
    public void close() {
        driver.quit();
    }
    @Test
    public void verifyLogo() throws Throwable {
        indexPage= new IndexPage();
        boolean result=indexPage.validateLogo() ;
        Assert.assertTrue(result);
    }
    public void verifyTitle() throws Throwable{
        String actTitle=indexPage.getMyStoreTitle();
//        Assert.assertEquals(actTitle, );

    }
}
