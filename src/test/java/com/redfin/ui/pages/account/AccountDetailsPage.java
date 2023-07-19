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
    public String requiredFieldErrorMessageText = "Required";
    private String validationPasswordErrorText = "Your password must be at least 6 characters long";
    private String passwordsDoNotMatchErrorText = "Password entries do not match";
    private String requiredOldPasswordLocator = "//span[@class='field text Text required error currentPasswordField']/span[@data-rf-test-id='validationFeedback']";
    private String requiredNewPasswordLocator = "//span[@class='field text Text required error newPasswordField']/span[@data-rf-test-id='validationFeedback']";

    private String requiredReEnterPasswordLocator = "//span[@class='field text Text required error confirmPasswordField']/span[@data-rf-test-id='validationFeedback']";
    private String changePasswordButtonPrimaryLocator = "//button[@type='submit']";

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

    public AccountDetailsPage keyOldPassword(String str) {
        WebElement oldPasswordField = driver.findElement(By.xpath(oldPasswordInputFieldLocator));
        oldPasswordField.sendKeys(str);
        return this;
    }

    public AccountDetailsPage keyNewPassword(String str) {
        WebElement newPasswordField = driver.findElement(By.xpath(newPasswordInputLocator));
        newPasswordField.sendKeys(str);
        return this;
    }

    public AccountDetailsPage keyConfirmNewPassword(String str) {
        WebElement confirmNewPassword = driver.findElement(By.xpath(confirmPasswordInputLocator));
        confirmNewPassword.sendKeys(str);
        return this;
    }

    public AccountDetailsPage clickChangePasswordButtonPrimary() {
        WebElement changePasswordPrimaryButton = driver.findElement(By.xpath(changePasswordButtonPrimaryLocator));
        changePasswordPrimaryButton.click();
        return this;
    }

    public AccountDetailsPage clickChangePasswordButton() {
        WebElement changePasswordButton = driver.findElement(By.xpath(changePasswordButtonLocator));
        changePasswordButton.click();
        return this;
    }

    public String getrequiredOldPasswordError() {
        WebElement requiredOldPasswordError = driver.findElement(By.xpath(requiredOldPasswordLocator));
        return requiredOldPasswordError.getText();
    }

    public String getRequiredNewPasswordError() {
        WebElement requiredNewPasswordError = driver.findElement(By.xpath(requiredNewPasswordLocator));
        return requiredNewPasswordError.getText();
    }

    public String getRequiredReEnterNewPasswordError() {
        WebElement requiredReEnterNewPasswordError = driver.findElement(By.xpath(requiredReEnterPasswordLocator));
        return requiredReEnterNewPasswordError.getText();
    }

}
