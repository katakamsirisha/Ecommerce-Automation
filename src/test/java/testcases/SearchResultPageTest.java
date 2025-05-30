package testcases;

import base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AddToCartPage;
import pageobjects.IndexPage;
import pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
    IndexPage index;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;

    @BeforeMethod
    public void setup() throws Throwable {
        launchApp();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    @Test
    public void productAvailabilityTest() throws Throwable {
        IndexPage index = new IndexPage();
        searchResultPage = index.SearchProduct(prop.getProperty("searchproduct"));
        boolean result = searchResultPage.clickOnProduct().validateAddToCart();
        Assert.assertTrue(result);
    }
}
