package com.solvd.demoautotesting.web.catalog_onliner;

import com.solvd.demoautotesting.web.catalog_onliner.components.UserBarComponent;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.UserValidationDataType;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.isValidEnum;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.UserService;
import com.solvd.demoautotesting.web.catalog_onliner.pages.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {
    @Test
    private void validateLoginButtonsPresence(){
        SoftAssert sa = new SoftAssert();
        WebDriver webDriver = getDriver();

        HomePage page = new HomePage(webDriver);
        page.open();

        UserBarComponent userBar = page.getHeader().getUserBarComponent();
        sa.assertTrue(userBar.getLogByMyself().isElementPresent(1), "Button for login by myself isn't present");
        sa.assertTrue(userBar.getLogByFacebook().isElementPresent(1), "Button for login by facebook isn't present");
        sa.assertTrue(userBar.getLogByVK().isElementPresent(1), "Button for login by VK isn't present");
        sa.assertTrue(userBar.getLogByGoogle().isElementPresent(1), "Button for login by Goggle isn't present");

        sa.assertAll();
    }

    @Test
    public void verifyMyselfLogin(){
        UserService us = new UserService();
        var a = us.createUser(UserValidationDataType.VK, isValidEnum.VALID);
        System.out.println();
    }
}
