package com.solvd.demoautotesting.web.vek21.pages;

import com.solvd.demoautotesting.web.vek21.components.SubmitDeleteModal;
import com.solvd.demoautotesting.web.vek21.helpers.models.Product;
import com.zebrunner.carina.utils.common.CommonUtils;
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
    @FindBy(xpath = "//div[@data-testid='basket-item'][%d]//button[contains(@class, 'reactButton')][1]")
    private ExtendedWebElement deleteProductButton;
    @FindBy(xpath = "//div[contains(@class, 'modalWrappe')]")
    private SubmitDeleteModal submitDeleteModal;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<Product> getProductsFromCart() {
        CommonUtils.pause(2);

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

    public List<Product> getProductsFromCartAfterDeletingByIndex(int index) {
        deleteProductByIndex(index);
        submitDeleteModal.confirm();

        return getProductsFromCart();
    }

    public void deleteProductByIndex(int index) {
        deleteProductButton.format(index).click();
    }

    public Product getProductFromCartByIndex(int index) {
        List<Product> productList = getProductsFromCart();
        if(productList.size() < index)
            throw new IllegalArgumentException("sent index of product from cart was bigger than size of product cart list.");
        return productList.get(index-1);
    }
}
