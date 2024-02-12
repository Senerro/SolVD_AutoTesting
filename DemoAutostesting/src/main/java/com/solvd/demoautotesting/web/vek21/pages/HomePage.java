package com.solvd.demoautotesting.web.vek21.pages;

import com.solvd.demoautotesting.web.vek21.components.CookieComponent;
import com.solvd.demoautotesting.web.vek21.components.SaleProductsComponent;
import com.solvd.demoautotesting.web.vek21.helpers.models.Product;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//body//div[contains(@class,'AgreementCookie_buttons')]")
    private CookieComponent cookieComponent;
    //div[@aria-hidden='false']//div[@data-observable='false']//
    @FindBy(xpath = "//div[contains(@class,'EntitiesList_items')]")
    private SaleProductsComponent saleProductsComponent;
    @FindBy(xpath = "//div[contains(@class,\"headerCart\")]")
    private ExtendedWebElement curtButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void submitCookie() {
        if (cookieComponent.getSubmitCookieButton().isElementPresent(5))
            cookieComponent.submitCookie();
    }

    public Product getProductByIndex(int index) {
        String name = saleProductsComponent.getProductNameByIndex().format(index).getText().toLowerCase();
        String stringPrice = saleProductsComponent.getProductPriceByIndex().format(index).getText().replace(",", ".").replace(" ", "").replace("р.", "");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(stringPrice));

        return new Product(name, price);
    }

    public ProductPage clickOnProduct(int index) {
        saleProductsComponent.getProductNameByIndex().format(index).click();
        return new ProductPage(driver);
    }

    public CartPage clickOnCartButton() {
        curtButton.click();
        return new CartPage(driver);
    }

    public Product putProductInCartByIndex(int index) {
        addProductInCart(index);
        return getProductByIndex(index);
    }

    public void addProductInCart(int index) {
        saleProductsComponent.putInCartByIndex(index);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("vek21_home_url"));
    }
}
