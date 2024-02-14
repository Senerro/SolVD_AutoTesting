package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {
    @FindBy(xpath = ".//input")
    private ExtendedWebElement searchLineInput;
    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void insertRequest(String productName){
        searchLineInput.type(productName);
        searchLineInput.getElement().submit();
    }
}
