package com.redfin.ui.tests;

import com.redfin.ui.pages.account.AccountDetailsPage;
import com.redfin.ui.steps.StepUiCommon;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTests extends BaseTest {
    @Test
    public void updateAccountDetailsTest() {
        StepUiCommon stepUiCommon = new StepUiCommon();
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
        stepUiCommon.loginStep();
        accountDetailsPage.clickAccountSetting();
        accountDetailsPage.keyNewLastName();
        accountDetailsPage.clickSaveUpdatesAndRefresh();
        Assert.assertEquals(accountDetailsPage.getLastNameValue(), accountDetailsPage.newLastName);
    }

    @Test
    public void changePasswordRequiredFieldsTest() {
        StepUiCommon stepUiCommon = new StepUiCommon();
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
        stepUiCommon.loginStep();
        accountDetailsPage.clickAccountSetting().clickChangePasswordButton().clickChangePasswordButtonPrimary();
        Assert.assertEquals(accountDetailsPage.getrequiredOldPasswordError(), accountDetailsPage.requiredFieldErrorMessageText);
        Assert.assertEquals(accountDetailsPage.getRequiredNewPasswordError(), accountDetailsPage.requiredFieldErrorMessageText);
        Assert.assertEquals(accountDetailsPage.getRequiredReEnterNewPasswordError(), accountDetailsPage.requiredFieldErrorMessageText);
    }
}
