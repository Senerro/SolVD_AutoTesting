package com.solvd.demoautotesting.web.catalog_onliner.pages;

import com.solvd.demoautotesting.web.catalog_onliner.components.Header;
import com.solvd.demoautotesting.web.catalog_onliner.components.ProductPagesAreaComponent;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.ProductPageButtonsRuEnum;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//header")
    private Header header;
    @FindBy(xpath = "//div[contains(@class, 'catalog-content')]")
    private ProductPagesAreaComponent productPagesAreaComponent;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public MainLoginPage clickToLoginButton() {
        header.clickToLoginMyselfButton();
        return new MainLoginPage(driver);
    }

    public Header clickOnProfileImage() {
        header.clickOnProfileImage();
        return header;
    }

    public void logout() {
        header.logout();
    }

    public boolean isProfileImagePresent() {
        return header.isProfileImagePresent();
    }

    public boolean isLogByMyselfElementPresent() {
        return header.isLogByMyselfElementPresent();
    }

    public boolean isLogByFacebookElementPresent() {
        return header.isLogByFacebookElementPresent();
    }

    public boolean isLogByVKElementPresent() {
        return header.isLogByVKElementPresent();
    }

    public boolean isLogByGoogleElementPresent() {
        return header.isLogByGoogleElementPresent();
    }

    public ProductsCatalogPage selectProductCategory(ProductPageButtonsRuEnum ruEnum) {
        return productPagesAreaComponent.clickButtonByEnum(ruEnum);
    }

    public static HomePage getHomePage(WebDriver driver) {
        HomePage page = new HomePage(driver);
        page.open();
        return page;
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("catalog_onliner_home_url"));
    }
}
