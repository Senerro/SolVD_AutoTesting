package com.solvd.demoautotesting.web.catalog_onliner.pages;

import com.solvd.demoautotesting.web.catalog_onliner.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//header")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public Header getHeader() {
        return header;
    }

    public MainLoginPage clickToLoginButton(){
        getHeader().getUserBarComponent().getLogByMyself().click();
        return new MainLoginPage(getDriver());
    }

    public void clickOnProfileImage(){
        getHeader().getUserBarComponent().getProfileComponent().getProfileImage().click();
    }

    @Override
    public void open(){
        openURL(Configuration.getRequired("catalog_onliner_home_url"));
    }

    public void logout() {
        getHeader().getUserBarComponent().getProfileComponent().getLogoutButton().click();
    }
}
