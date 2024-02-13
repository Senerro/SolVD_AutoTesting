package com.solvd.demoautotesting.web.components.amazon;

import com.solvd.demoautotesting.web.pages.amazon.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {
    @FindBy(xpath = ".//*[@class = 'nav-search-facade']")
    private ExtendedWebElement productTypeSelect;
    @FindBy(xpath = ".//input[@id = 'twotabsearchtextbox']")
    private ExtendedWebElement searchInput;
    @FindBy(xpath = ".//*[@id = 'nav-search-submit-button']")
    private ExtendedWebElement searchButton;

    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductTypeSelect() {
        return productTypeSelect;
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public void typeSearchInputValue(String value) {
        searchInput.type(value);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public String getSearchInputPlaceholder() {
        return searchInput.getAttribute("placeholder");
    }
}
