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

    public SearchLineComponent getSearchLine() {
        return searchLine;
    }

    public UserBarComponent getUserBarComponent() {
        return userBarComponent;
    }
}
