package com.redfin.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver(/*chromeOptions*/);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        return driver;
    }

    private WebDriverSingleton() {/**/

    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}