package com.redfin.ui.tests;


import com.redfin.driver.WebDriverSingleton;
import com.redfin.ui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void warmUp() {
    }

    @AfterMethod
    public void tearDown(){
        WebDriverSingleton.quit();
    }
}
