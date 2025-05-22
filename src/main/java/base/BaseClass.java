package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public void loadConfig() {
        try {
            prop = new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
            prop.load(ip);
            System.out.println("driver: " + driver);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void launchApp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if (browserName.contains("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.contains("Firefox")) {
            driver = new FirefoxDriver();

        } else if (browserName.contains("IE")) {
            driver = new InternetExplorerDriver();

        }
//        ActionClass.implicitwait(driver, 10);
//        ActionClass.PageLoadTimeOut(driver, 30);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get(prop.getProperty("url"));

    }

}
