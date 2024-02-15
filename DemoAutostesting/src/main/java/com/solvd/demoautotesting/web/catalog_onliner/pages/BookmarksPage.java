package com.solvd.demoautotesting.web.catalog_onliner.pages;

import com.solvd.demoautotesting.web.catalog_onliner.components.ProductBookmarksComponent;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Product;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.ProductService;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BookmarksPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class, 'offers-list')]/div")
    private List<ProductBookmarksComponent> productOffersComponentList;

    public BookmarksPage(WebDriver driver) {
        super(driver);
    }

    public Product getProductFromBookmarksByIndex(int index) {
        String name = productOffersComponentList.get(index - 1).getProductName();
        String price = productOffersComponentList.get(index - 1).getProductPrice();
        return ProductService.getProduct(name, price);
    }

    public List<Product> getProductsList() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productOffersComponentList.size(); i++)
            products.add(getProductFromBookmarksByIndex(i+1));
        return products;
    }
}
