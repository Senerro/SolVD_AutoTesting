package com.solvd.demoautotesting.web.vek21.pages;

import com.solvd.demoautotesting.web.vek21.helpers.models.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class, 'titleWrapper')]/a")
    private List<ExtendedWebElement> cartProductNames;
    @FindBy(xpath = "//div[contains(@class, 'BasketItem_price')]")
    private List<ExtendedWebElement> cartProductCosts;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<Product> getProductsFromCart() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        List<String> names = cartProductNames.stream().map(ExtendedWebElement::getText).map(String::toLowerCase).toList();
        List<String> costs = cartProductCosts.stream().map(ExtendedWebElement::getText).toList();
        List<String> typoCosts = new ArrayList<>();
        for (String cost : costs) {
            typoCosts.add(StringUtils.split(cost.replace(",", ".").replace(" ",""), "р")[0]);
        }

        return Product.getProductList(names, typoCosts);
    }

}
