package com.redfin.utils;

import com.github.javafaker.Faker;
import com.redfin.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailUtils {
    WebDriver driver;
    public String emailProtonSite = "https://mail.proton.me/";
    public String emailProtonAddress = "redfin_test_user@proton.me";
    public String emailProtonPassword = "Pass123!";

    private String emailProtonInputFieldLocator = "//input[@id='username']";
    private String passwordProtonInputFieldLocator = "//input[@id='password']";
    private String inboxProtonSubmitButtonLocator = "//form/button";

    public EmailUtils() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public String generatePassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

    public EmailUtils goToProtonInbox(String emailProtonAddress, String emailProtonPassword) {
        driver.get(emailProtonSite);
        WebElement emailInputField = driver.findElement(By.xpath(emailProtonInputFieldLocator));
        emailInputField.sendKeys(emailProtonAddress);
        WebElement passwordInputField = driver.findElement(By.xpath(passwordProtonInputFieldLocator));
        passwordInputField.sendKeys(emailProtonPassword);
        WebElement submitButton = driver.findElement(By.xpath(inboxProtonSubmitButtonLocator));
        submitButton.click();
        return this;

    }
}
