package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductBookmarksComponent extends AbstractUIObject {
    @FindBy(xpath = ".//a[contains(@class, 'primary-additional')]/parent::div[contains(@class, 'description_base')]")
    private ExtendedWebElement productNameByIndex;
    @FindBy(xpath = ".//a[contains(@class, 'primary-additional')]/parent::div[contains(@class, 'description_huge')]")
    private ExtendedWebElement productPriceByIndex;
    public ProductBookmarksComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName(){
        return productNameByIndex.getText();
    }

    public String getProductPrice(){
        return productPriceByIndex.getText();
    }
}
