package com.redfin.ui.pages.account;

import com.redfin.driver.WebDriverSingleton;
import com.redfin.ui.pages.HomePage;
import com.redfin.utils.EmailUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AccountDetailsPage {
    WebDriver driver;
    HomePage homePage = new HomePage();
    EmailUtils emailUtils = new EmailUtils();
    private String firstNameInputFieldLocator = "//input[@name='firstName']";
    private String lastNameInputFieldLocator = "//input[@name='lastName']";
    private String changePasswordButtonLocator = "//a[@href='/change-password']";
    private String oldPasswordInputFieldLocator = "//input[@name='currentPasswordField']";
    private String newPasswordInputLocator = "//input[@name='newPasswordField']";
    private String confirmPasswordInputLocator = "//input[@name='confirmPasswordField']";
    private String changePasswordSubmitButtonLocator = "//button[@type='submit']";
    private String saveUpdatesButtonLocator = "//form[@data-rf-form-name]//button[@type='submit']";
    private String accountSettingsMenuItemLocator = "//div[@class='flyoutColumn']//a[@href='/myredfin/settings']";
    public String newLastName;

    public AccountDetailsPage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public AccountDetailsPage clickAccountSetting() {
        WebElement displayName = driver.findElement(By.xpath(homePage.displayNameLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(displayName).perform();
        WebElement accountSettingsMenuItem = driver.findElement(By.xpath(accountSettingsMenuItemLocator));
        accountSettingsMenuItem.click();
        return this;
    }

    public String getLastNameValue() {
        WebElement lastName = driver.findElement(By.xpath(lastNameInputFieldLocator));
        return lastName.getAttribute("value");
    }

    public AccountDetailsPage keyNewLastName() {
        WebElement lastName = driver.findElement(By.xpath(lastNameInputFieldLocator));
        lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        newLastName = emailUtils.generateLastName();
        lastName.sendKeys(newLastName);
        return this;
    }

    public AccountDetailsPage clickSaveUpdatesAndRefresh() {
        WebElement saveUpdatesButton = driver.findElement(By.xpath(saveUpdatesButtonLocator));
        saveUpdatesButton.click();
        driver.navigate().refresh();
        return this;
    }


}
