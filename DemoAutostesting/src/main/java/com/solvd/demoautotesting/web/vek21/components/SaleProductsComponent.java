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
    @FindBy(xpath = "./div[%d]//div[contains(@class,'actions')]/button")
    private ExtendedWebElement putInCartButton;

    public SaleProductsComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductNameByIndex(int index) {
        return productNameByIndex.format(index);
    }

    public ExtendedWebElement getProductPriceByIndex(int index) {
        return productPriceByIndex.format(index);
    }

    public void putInCartByIndex(int index) {
        putInCartButton.format(index).click();
    }

    public boolean isProductByIndexHidden(int index) {
        return productNameByIndex.format(index).isElementNotPresent(1);
    }

    public boolean isProductByIndexRevealed(int index) {
        return productNameByIndex.format(index).isElementPresent(1);
    }
}
