package com.solvd.demoautotesting.web.catalog_onliner;

import com.solvd.demoautotesting.web.catalog_onliner.components.Header;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.UserValidationDataType;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.isValidEnum;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.User;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.LoginService;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.UserService;
import com.solvd.demoautotesting.web.catalog_onliner.pages.HomePage;
import com.solvd.demoautotesting.web.catalog_onliner.pages.MainLoginPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

    @Test
    public void validateLoginButtonsPresence() {
        SoftAssert sa = new SoftAssert();
        HomePage page = getHomePage();

        sa.assertTrue(page.isLogByMyselfElementPresent(), "Button for login by myself isn't present");
        sa.assertTrue(page.isLogByFacebookElementPresent(), "Button for login by facebook isn't present");
        sa.assertTrue(page.isLogByVKElementPresent(), "Button for login by VK isn't present");
        sa.assertTrue(page.isLogByGoogleElementPresent(), "Button for login by Goggle isn't present");

        sa.assertAll();
    }

    @Test(description = "login page require solve capcha to pass")
    public void verifyMyselfValidLogin() {
        HomePage page = getHomePage();
        loginActions(page, new UserService().createUser(UserValidationDataType.Myself, isValidEnum.VALID));
        Assert.assertTrue(page.isProfileImagePresent(), "logout button isn't present, login wasn't completed");
    }

    @Test
    public void verifyMyselfInvalidLogin() {
        HomePage page = getHomePage();
        loginActions(page, new UserService().createUser(UserValidationDataType.Myself, isValidEnum.INVALID));
        Assert.assertFalse(page.isProfileImagePresent(), "logout button isn't present, login wasn't completed");
    }

    @Test
    public void verifyLogout() {
        HomePage page = getHomePage();
        loginActions(page, new UserService().createUser(UserValidationDataType.Myself, isValidEnum.VALID));
        Header header = page.clickOnProfileImage();

        Assert.assertTrue(header.isLogoutButtonPresence(), "logout button isn't presented, login wasn't completed");
        page.logout();
        Assert.assertFalse(header.isLogoutButtonPresence(), "logout button is presented, logout wasn't completed");
    }

    private HomePage getHomePage() {
        HomePage page = new HomePage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(5));
        return page;
    }

    private void loginActions(HomePage page, User user){
        SoftAssert sa = new SoftAssert();
        MainLoginPage loginPage = page.clickToLoginButton();

        sa.assertTrue(loginPage.isLoginInputPresent(), "login input isn't present");
        sa.assertTrue(loginPage.isPassInputPresent(), "pass input isn't present");
        sa.assertTrue(loginPage.isSubmitButtonPresent(), "submit button isn't present");
        sa.assertAll();

        new LoginService().login(user, loginPage);
    }
}
