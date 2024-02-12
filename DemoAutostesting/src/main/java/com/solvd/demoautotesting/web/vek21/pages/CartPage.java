package com.solvd.demoautotesting.web.vek21.pages;

import com.solvd.demoautotesting.web.vek21.helpers.models.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class, 'titleWrapper')]/a")
    private List<ExtendedWebElement> cartProductNames;
    @FindBy(xpath = "//div[contains(@class, 'BasketItem_price')]")
    private List<ExtendedWebElement> cartProductCosts;

    @FindBy(xpath = "//div[@data-testid='total-price']")
    private ExtendedWebElement totalPrice;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<Product> getProductsFromCart() {

        List<String> names = cartProductNames.stream().map(ExtendedWebElement::getText).map(String::toLowerCase).toList();
        List<String> costs = cartProductCosts.stream().map(ExtendedWebElement::getText).toList();
        List<String> typoCosts = new ArrayList<>();
        for (String cost : costs)
            typoCosts.add(StringUtils.split(cost.replace(",", ".").replace(" ",""), "р")[0]);

        return Product.getProductList(names, typoCosts);
    }

    public BigDecimal getTotalPrice() {
        String stringPrice = totalPrice.getText();
        var finalStringPrice = StringUtils.split(stringPrice.replace(",", ".").replace(" ",""), "р")[0];
        return BigDecimal.valueOf(Double.parseDouble(finalStringPrice));
    }
}
