package com.redfin.ui.pages;

import com.redfin.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    public String baseUrl = "https://www.redfin.com/";
    private String loginButtonLocator = "//button[@data-rf-test-name='SignInLink']";
    private String signUpButtonLocator = "//button[@data-rf-test-name='JoinLink']";
    private String emailInputLocator = "//input[@name='emailInput']";
    private String continueWithEmailbutton = "//button[@data-rf-test-name='submitButton']";
    private String passwordInputLocator = "//input[@name='passwordInput']";
    private String searchPartnerDialogBoxLocator = "//h3[@data-rf-test-name='title']";
    public String searchPartnerText = "Add your search partner";
    public String displayNameLocator = "//a[@data-rf-test-name='displayName']";
    public String getDisplayNameText = "TestUser ▾";

    public HomePage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public HomePage getUrl() {
        driver.get(baseUrl);
        return this;
    }

    public HomePage clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath(loginButtonLocator));
        loginButton.click();
        return this;
    }

    public HomePage keyEmail(String str) {
        WebElement emailInput = driver.findElement(By.xpath(emailInputLocator));
        emailInput.sendKeys(str);
        return this;
    }

    public HomePage clickContinueWithEmailbutton() {
        WebElement continueWithEmailButton = driver.findElement(By.xpath(continueWithEmailbutton));
        continueWithEmailButton.click();
        return this;
    }

    public HomePage keyPassword(String str) {
        WebElement passwordInput = driver.findElement(By.xpath(passwordInputLocator));
        passwordInput.sendKeys(str);
        return this;
    }

    public String getSearchPartnerText() {
        WebElement searchPartnerDialogBox = driver.findElement(By.xpath(searchPartnerDialogBoxLocator));
        return searchPartnerDialogBox.getText();
    }

    public String getDisplayNameText() {
        WebElement displayName = driver.findElement(By.xpath(displayNameLocator));
        return displayName.getText();
    }
}
