package com.solvd.demoautotesting.web.catalog_onliner.pages;

import com.solvd.demoautotesting.web.catalog_onliner.components.ProductSaleComponent;
import com.solvd.demoautotesting.web.catalog_onliner.components.SearchLineComponent;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsCatalogPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='fast-search'][1]")
    private SearchLineComponent searchLineComponent;
    @FindBy(xpath = "//body")
    private ProductSaleComponent productSaleComponent;
    @FindBy(xpath = "//a[contains(@class, 'favorites')]")
    private ExtendedWebElement favoritesButton;

    public ProductsCatalogPage(WebDriver driver) {
        super(driver);
    }

    public Product getProductByIndex(int index){
        return productSaleComponent.getLaptopByIndex(index);
    }

    public void clickOnFavoritesButtonByProductName(String name) {
        productSaleComponent.clickFavoritesButtonByProductName(name);
    }

    public boolean isFavoritesButtonPresent(){
        return favoritesButton.isElementPresent(1);
    }

    public BookmarksPage goToBookmarksPage() {
        favoritesButton.click();
        return new BookmarksPage(driver);
    }
}
