package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProfileComponent extends AbstractUIObject {
    @FindBy(xpath = ".//div[contains(@class, 'profile__image')]")
    private ExtendedWebElement profileImage;
    @FindBy(xpath = ".//div[contains(@class,'logout')]//a")
    private ExtendedWebElement logoutButton;

    public ProfileComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLogoutButtonPresence() {
        return logoutButton.isElementPresent(1);
    }

    public boolean isProfileImagePresent() {
        return profileImage.isElementPresent(1);
    }

    public void clickOnProfileImage() {
        profileImage.click();
    }

    public void logout() {
        logoutButton.click();
    }
}
