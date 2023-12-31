package com.redfin.ui.tests;

import com.redfin.ui.pages.HomePage;
import com.redfin.ui.steps.StepUiCommon;
import com.redfin.utils.EmailUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    //StepUi stepUi;
    @Test
    public void signUpViaLoginTest(){
        HomePage homePage = new HomePage();
        EmailUtils emailUtils = new EmailUtils();
        homePage.clickLoginButton().keyEmail(emailUtils.generateEmail())/*.clickContinueWithEmailbutton().
                keyPassword(dataUtils.generatePassword())*/.clickContinueWithEmailbutton();
        Assert.assertEquals(homePage.getSearchPartnerText(),homePage.searchPartnerText);
    }
    @Test
    public void loginWithValidCredsTest(){
      /*  HomePage homePage = new HomePage();
        EmailUtils emailUtils = new EmailUtils();
        homePage.getUrl().clickLoginButton().keyEmail(emailUtils.emailProtonAddress).clickContinueWithEmailbutton().keyPassword(emailUtils.emailProtonPassword).clickContinueWithEmailbutton();*/
        StepUiCommon stepUiCommon = new StepUiCommon();
        HomePage homePage = new HomePage();
        stepUiCommon.loginStep();
        Assert.assertEquals(homePage.getDisplayNameText(),homePage.getDisplayNameText);

    }
    @Test
    public void emailInboxTest(){
        EmailUtils emailUtils = new EmailUtils();
        emailUtils.goToProtonInbox(emailUtils.emailProtonAddress, emailUtils.emailProtonPassword);


    }


}
