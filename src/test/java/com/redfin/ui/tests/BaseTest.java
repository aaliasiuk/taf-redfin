package com.redfin.ui.tests;


import com.redfin.ui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void warmUp() {
  /*      ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        //driver.get(homePage.baseUrl);*/
    }

    /*@AfterMethod
    public void tearDown(){
        driver.quit();
    }*/
}
