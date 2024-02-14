package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserBarComponent extends AbstractUIObject {
    @FindBy(xpath = ".//div[@class='b-top-profile__list']")
    private ProfileComponent profileComponent;
    @FindBy(xpath = ".//div[contains(@class, '--text')]")
    private ExtendedWebElement logByMyself;
    @FindBy(xpath = ".//div[contains(@class, '--gg')]")

    private ExtendedWebElement logByGoogle;
    @FindBy(xpath = ".//div[contains(@class, '--fb')]")

    private ExtendedWebElement logByFacebook;
    @FindBy(xpath = ".//div[contains(@class, '--vk')]")
    private ExtendedWebElement logByVK;

    public UserBarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLogoutButtonPresence() {
        return profileComponent.isLogoutButtonPresence();
    }

    public boolean isProfileImagePresent() {
        return profileComponent.isProfileImagePresent();
    }

    public boolean isLogByMyselfElementPresent() {
        return logByMyself.isElementPresent(1);
    }

    public boolean isLogByFacebookElementPresent() {
        return logByFacebook.isElementPresent(1);
    }

    public boolean isLogByVKElementPresent() {
        return logByVK.isElementPresent(1);
    }

    public boolean isLogByGoogleElementPresent() {
        return logByGoogle.isElementPresent(1);
    }

    public void clickToLoginMyselfButton() {
        logByMyself.click();
    }

    public void clickOnProfileImage() {
        profileComponent.clickOnProfileImage();
    }

    public void logout() {
        profileComponent.logout();
    }
}
