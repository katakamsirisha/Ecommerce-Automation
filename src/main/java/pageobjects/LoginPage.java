package pageobjects;

import actiondriver.newAction;
import actiondriver.newAction;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;
import java.time.Duration;

public class LoginPage extends BaseClass {
    @FindBy(id = "email")
    WebElement userName;
    @FindBy(name = "passwd")
    WebElement passwordElement;
    @FindBy(id = "SubmitLogin")
    WebElement signInBtn;
    @FindBy(name="email_create")
    WebElement emailForNewAccount;
    @FindBy(name = "SubmitCreate")
    WebElement createNewAccountBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public Homepage login(String uname, String pswd) throws Throwable{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        userName.sendKeys(uname);
        passwordElement.sendKeys(pswd);
        signInBtn.click();
        return new Homepage();
    }
    public AddressPage loginAs(String uname, String pswd) throws Throwable {
        userName.sendKeys(uname);
        passwordElement.sendKeys(pswd);
        signInBtn.click();
        return new AddressPage();

    }
    public AccountCreationPage createNewAccount(String newEmail) throws Throwable{
        emailForNewAccount.sendKeys(newEmail);
        createNewAccountBtn.click();
        return new AccountCreationPage();

    }
}
