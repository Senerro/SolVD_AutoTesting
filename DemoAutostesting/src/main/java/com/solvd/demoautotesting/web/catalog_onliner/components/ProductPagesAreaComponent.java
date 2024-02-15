package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.ProductPageButtonsRuEnum;
import com.solvd.demoautotesting.web.catalog_onliner.pages.ProductsCatalogPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPagesAreaComponent extends AbstractUIObject {
    @FindBy(xpath = ".//a[text()= '%s']")
    private ExtendedWebElement button;

    public ProductPagesAreaComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductsCatalogPage clickButtonByEnum(ProductPageButtonsRuEnum buttonsEnum) {
        button.format(buttonsEnum.getButtonName()).click();
        if (driver.getCurrentUrl().contains(buttonsEnum.getName()))
            return new ProductsCatalogPage(driver);
        throw new RuntimeException(String.format("Uncurrect catalog opened. Expected %s, but found %s", driver.getCurrentUrl(), buttonsEnum.getName()));
    }

}
