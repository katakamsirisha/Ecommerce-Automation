package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AddToCartPage;
import pageobjects.IndexPage;
import pageobjects.OrderPage;
import pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
    IndexPage index;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;

    @BeforeMethod
    public void setup() throws Throwable {
        launchApp();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    @Test
    public void verifyTotalPrice() throws Throwable {
        index = new IndexPage();
        searchResultPage = index.SearchProduct("t-shirt");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.setSize("M");
        addToCartPage.setAddToCartBtn();
        orderPage = addToCartPage.clickOnCheckOut();
        Double unitPrice = orderPage.getUnitPrice();
        Double totalPrice = orderPage.getTotalPrice();
        Double totalExpectedPrice = (unitPrice * 2) + 2;
        Assert.assertEquals(totalPrice, totalExpectedPrice);
    }
}
