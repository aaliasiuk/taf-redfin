package com.redfin.ui.steps;

import com.redfin.driver.WebDriverSingleton;
import com.redfin.ui.pages.HomePage;
import com.redfin.utils.EmailUtils;
import org.openqa.selenium.WebDriver;

public class StepUiCommon {
    WebDriver driver;

    public StepUiCommon() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public void loginStep() {
        HomePage homePage = new HomePage();
        EmailUtils emailUtils = new EmailUtils();
        homePage.getUrl().closeCookieBanner().clickLoginButton().keyEmail(emailUtils.emailProtonAddress).clickContinueWithEmailbutton().keyPassword(emailUtils.emailProtonPassword).clickContinueWithEmailbutton();
    }
}
