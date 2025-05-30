package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

public class EndToEndTest extends BaseClass {
    IndexPage index;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;
    LoginPage loginPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderSummaryPage orderSummary;
    OrderConfirmationPage orderConfirmationPage;

    @BeforeMethod
    public void setup() throws Throwable {
        launchApp();
    }

    @AfterMethod
    public void close() {

        driver.quit();
    }
    @Test
    public void endToEndTest() throws Throwable {
       index=new IndexPage();
        searchResultPage = index.SearchProduct("t-shirt");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.setSize("M");
        addToCartPage.setAddToCartBtn();
        orderPage = addToCartPage.clickOnCheckOut();
        loginPage=orderPage.setProceedtocheckout();
        addressPage=loginPage.loginAs(prop.getProperty("username"), prop.getProperty("password"));
        shippingPage=addressPage.setProceedToCheckOut();
        shippingPage=addressPage.setProceedToCheckOut();
        shippingPage.setTerms();
        shippingPage.setProceedToCheckOutBtn();
        paymentPage=shippingPage.setProceedToCheckOutBtn();
        orderSummary= paymentPage.setPayByCheckMethod();
        orderConfirmationPage=orderSummary.setConfirmOrderBtn();
        String actualMessage=orderConfirmationPage.setConfirmMsg();
        String expectedMessage="Your order on My Store is complete";
        Assert.assertEquals(actualMessage,expectedMessage);



    }
}
