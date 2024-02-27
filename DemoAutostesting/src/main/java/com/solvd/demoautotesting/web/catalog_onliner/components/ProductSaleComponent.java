package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.UserValidationDataType;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.isValidEnum;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Product;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.User;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.ProductService;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.LoginService;
import com.solvd.demoautotesting.web.catalog_onliner.pages.MainLoginPage;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductSaleComponent extends AbstractUIObject {
    @FindBy(xpath = ".//div[contains(@class,'offers-unit')][2]//a[contains(@class, 'link catalog-form__link_primary-')]")
    private ExtendedWebElement laptopName;
    @FindBy(xpath = ".//div[contains(@class,'offers-unit')][2]//a[contains(@class, 'link catalog-form__link_nodecor')]")
    private ExtendedWebElement price;

   // @FindBy(xpath = "//a[contains(text(), '%s')]/ancestor::div[contains(@class, 'offers-unit')]//div[contains(@class, 'handle_interactive')]")
    @FindBy(xpath = "//div[contains(@class ,'catalog-form__offers-item catalog-form')][.//a[contains(text(), '%s')]]//div[@class = 'catalog-form__offers-part catalog-form__offers-part_image']/label")
    private ExtendedWebElement favoriteButtonByProductName;

    public ProductSaleComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Product getLaptopByIndex(int index){
        return ProductService.getProduct(laptopName.getText(), price.format(index).getText());
    }

    public void clickFavoritesButtonByProductName(String name) {
        favoriteButtonByProductName.format(name).click();
    }
}
