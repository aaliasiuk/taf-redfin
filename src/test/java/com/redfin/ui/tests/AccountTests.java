package com.redfin.ui.tests;

import com.redfin.ui.pages.account.AccountDetailsPage;
import com.redfin.ui.steps.StepUi;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTests extends BaseTest {
    @Test
    public void updateAccountDetailsTest() {
        StepUi stepUi = new StepUi();
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
        stepUi.loginStep();
        accountDetailsPage.clickAccountSetting();
        accountDetailsPage.keyNewLastName();
        accountDetailsPage.clickSaveUpdatesAndRefresh();
        Assert.assertEquals(accountDetailsPage.getLastNameValue(), accountDetailsPage.newLastName);
    }
}
