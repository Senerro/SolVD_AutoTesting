package com.solvd.demoautotesting.web.vek21.pages;

import com.solvd.demoautotesting.web.vek21.components.SubmitDeleteModal;
import com.solvd.demoautotesting.web.vek21.helpers.models.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='content__header']//h1")
    private ExtendedWebElement productNameByIndex;

    @FindBy(xpath = "//div[@class='item-price']//span/span")
    private ExtendedWebElement productPriceByIndex;

    @FindBy(xpath = "//div[contains(@class, 'modalWrappe')]")
    private SubmitDeleteModal submitDeleteModal;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public Product getProduct(){

        String name = productNameByIndex.getText().toLowerCase();
        String stringPrice =productPriceByIndex.getAttribute("data-price");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(stringPrice));
        return new Product(name, price);
    }
}
