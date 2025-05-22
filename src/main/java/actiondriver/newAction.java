package actiondriver;

import base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class newAction extends BaseClass {


    public static void scrollByVisibilityOfElement(WebDriver driver, WebElement element) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public static void click(WebDriver ldriver, WebElement locatorName) throws Exception {
        Actions act = new Actions(ldriver);
        act.moveToElement(locatorName).click().build().perform();
    }

    public static void type(WebElement userName, String uname) {
    }

    public static boolean findElement(WebDriver ldriver, WebElement element) {
        boolean flag = false;
        try {
            element.isDisplayed();
            flag = true;
        } catch (Exception e) {
            //System.out.println("Location not found:  "+locatorName);
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully Found element at");

            } else {
                System.out.println("Unable to locate element at");

            }
            return flag;
        }

    }

    public static boolean isDisplayed(WebDriver ldriver, WebElement element) {
        boolean flag = false;
        flag = findElement(ldriver, element);
        if (flag) {
            flag = element.isDisplayed();
            if (flag) {
                System.out.println("The element is Displayed");

            } else {
                System.out.println("The element is not displayed");
            }
        } else {
            System.out.println("Not displayed");
        }
        return flag;
    }



    public boolean isSelected(WebDriver ldriver, WebElement element) throws Exception {
        boolean flag = false;
        flag = findElement(ldriver, element);
        if (flag) {
            flag = element.isSelected();
            if (flag) {
                System.out.println("The element is selected");
            } else {
                System.out.println("The element is not selected");
            }
        } else {
            System.out.println("Not selected");
        }
        return flag;
    }

    public boolean isenabled(WebDriver pdriver, WebElement element) {
        boolean flag = false;
        flag = findElement(pdriver, element);
        if (flag == true) {
            System.out.println("The element is enabled");
        } else {
            System.out.println("The element is not enabled");
        }
        return flag;
    }

}
