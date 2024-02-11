package com.solvd.demoautotesting.web.vek21.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SaleProductsComponent extends AbstractUIObject {
    @FindBy(xpath = "./div[%d]//p[contains(@class, 'CardInfo')]/a")
    private ExtendedWebElement productNameByIndex;
    @FindBy(xpath = "./div[%d]//div[contains(@class,'priceInfo')]//p")
    private ExtendedWebElement productPriceByIndex;

    /*@FindBy(xpath = "./div[%d]//div[contains(@class,'priceInfo')]//p/a")
    private ExtendedWebElement*/

    public SaleProductsComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductNameByIndex() {
        return productNameByIndex;
    }

    public ExtendedWebElement getProductPriceByIndex() {
        return productPriceByIndex;
    }
}
