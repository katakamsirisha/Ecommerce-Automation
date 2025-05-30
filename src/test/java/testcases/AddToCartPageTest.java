package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AddToCartPage;
import pageobjects.IndexPage;
import pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
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
    public void addToCartTest() throws Throwable {
        index = new IndexPage();
        searchResultPage = index.SearchProduct("t-shirt");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.setSize("M");
        addToCartPage.setAddToCartBtn();
        boolean result = addToCartPage.validateAddToCart();
        Assert.assertTrue(result);

    }
}
