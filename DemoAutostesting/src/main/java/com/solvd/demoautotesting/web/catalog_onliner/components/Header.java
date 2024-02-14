package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(xpath = ".//input[@class='fast-search__input']")
    private SearchLineComponent searchLine;
    @FindBy(xpath = ".//div[@id='userbar']")
    private UserBarComponent userBarComponent;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLogoutButtonPresence() {
        return userBarComponent.isLogoutButtonPresence();
    }

    public boolean isProfileImagePresent() {
        return userBarComponent.isProfileImagePresent();
    }

    public boolean isLogByMyselfElementPresent() {
        return userBarComponent.isLogByMyselfElementPresent();
    }

    public boolean isLogByFacebookElementPresent() {
        return userBarComponent.isLogByFacebookElementPresent();
    }

    public boolean isLogByVKElementPresent() {
        return userBarComponent.isLogByVKElementPresent();
    }

    public boolean isLogByGoogleElementPresent() {
        return userBarComponent.isLogByGoogleElementPresent();
    }

    public void clickToLoginMyselfButton() {
        userBarComponent.clickToLoginMyselfButton();
    }

    public void clickOnProfileImage() {
        userBarComponent.clickOnProfileImage();
    }

    public void logout() {
        userBarComponent.logout();
    }
}
