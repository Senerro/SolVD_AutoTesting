package com.solvd.demoautotesting.web.catalog_onliner;

import com.solvd.demoautotesting.web.catalog_onliner.components.UserBarComponent;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.UserValidationDataType;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.isValidEnum;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.User;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.LoginService;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.UserService;
import com.solvd.demoautotesting.web.catalog_onliner.pages.HomePage;
import com.solvd.demoautotesting.web.catalog_onliner.pages.MainLoginPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {
    private final LoginService loginService = new LoginService();

    @Test
    private void validateLoginButtonsPresence() {
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
    public void verifyMyselfValidLogin() {
        SoftAssert sa = new SoftAssert();
        UserService userService = new UserService();
        User validMyselfUser = userService.createUser(UserValidationDataType.Myself, isValidEnum.VALID);
        HomePage page = getHomePage();
        MainLoginPage loginPage = page.clickToLoginButton();

        Assert.assertTrue(loginPage.getLoginInput().isElementPresent(1), "login input isn't present");
        Assert.assertTrue(loginPage.getPassInput().isElementPresent(1), "pass input isn't present");
        Assert.assertTrue(loginPage.getSubmitButton().isElementPresent(1), "submit button isn't present");

        loginService.login(validMyselfUser, loginPage);

        sa.assertTrue(page.getHeader().getUserBarComponent().getProfileComponent().getProfileImage().isElementPresent(1), "logout button isn't present, login wasn't completed");
        sa.assertAll();
    }

    @Test
    public void verifyMyselfInvalidLogin() {
        SoftAssert sa = new SoftAssert();
        UserService userService = new UserService();
        User validMyselfUser = userService.createUser(UserValidationDataType.Myself, isValidEnum.INVALID);
        HomePage page = getHomePage();
        MainLoginPage loginPage = page.clickToLoginButton();

        Assert.assertTrue(loginPage.getLoginInput().isElementPresent(1), "login input isn't present");
        Assert.assertTrue(loginPage.getPassInput().isElementPresent(1), "pass input isn't present");
        Assert.assertTrue(loginPage.getSubmitButton().isElementPresent(1), "submit button isn't present");

        loginService.login(validMyselfUser, loginPage);

        sa.assertFalse(page.getHeader().getUserBarComponent().getProfileComponent().getProfileImage().isElementPresent(1), "logout button isn't present, login wasn't completed");
        sa.assertAll();
    }

    @Test
    public void verifyLogout() {
        SoftAssert sa = new SoftAssert();

        UserService userService = new UserService();
        User validMyselfUser = userService.createUser(UserValidationDataType.Myself, isValidEnum.VALID);
        HomePage page = getHomePage();
        loginService.login(validMyselfUser, page.clickToLoginButton());

        page.clickOnProfileImage();
        Assert.assertTrue(page.getHeader().getUserBarComponent().getProfileComponent().getLogoutButton().isElementPresent(1), "logout button isn't presented, login wasn't completed");
        page.logout();
        sa.assertFalse(page.getHeader().getUserBarComponent().getProfileComponent().getLogoutButton().isElementPresent(1), "logout button is presented, logout wasn't completed");
    }



    private HomePage getHomePage() {
        HomePage page = new HomePage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened());
        return page;
    }
}
