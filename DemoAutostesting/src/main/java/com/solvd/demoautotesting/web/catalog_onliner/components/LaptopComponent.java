package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Laptop;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.LaptopService;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LaptopComponent extends AbstractUIObject {
    @FindBy(xpath = ".[%d]//a[contains(@class, 'catalog-form__link catalog-form__link_primary-')]")
    private ExtendedWebElement laptopName;
    @FindBy(xpath = ".[%d]//a[contains(@class, 'catalog-form__link catalog-form__link_nodecor')]")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//div[./div/div/a[contains(text(), '[%s]')]]//div[contains(@class, 'handle_interactive')]//div[@class='i-checkbox__faux']")
    private ExtendedWebElement favoriteButtonByProductName;

    public LaptopComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Laptop getLaptopByIndex(int index){
        return LaptopService.getLaptop(laptopName.format(index).getText(), price.format(index).getText());
    }
}
