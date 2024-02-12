package com.solvd.demoautotesting.web.vek21;

import com.solvd.demoautotesting.web.vek21.helpers.models.Product;
import com.solvd.demoautotesting.web.vek21.pages.CartPage;
import com.solvd.demoautotesting.web.vek21.pages.HomePage;
import com.solvd.demoautotesting.web.vek21.pages.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HomePageTest extends AbstractTest {
    @Test
    public void verifyProductInformation() {
        HomePage homePage = getHomePage();
        Product productFromStore = homePage.getProductByIndex(2);
        ProductPage productPage = homePage.clickOnProduct(2);
        Product productFromPage = productPage.getProduct();
        Assert.assertEquals(productFromPage, productFromStore);
    }

    @Test
    public void verifyProductsInCart() {
        HomePage homePage = getHomePage();
        homePage.scrollToSaleProducts();

        List<Product> productListFromHomePage = new ArrayList<>();
        productListFromHomePage.add(homePage.putProductInCartByIndex(2));
        productListFromHomePage.add(homePage.putProductInCartByIndex(3));

        CartPage cartPage = homePage.clickOnCartButton();
        List<Product> productListFromCart = cartPage.getProductsFromCart();
        Assert.assertTrue(productListsComparison(productListFromHomePage, productListFromCart), "products in lists has different names or costs");
        Assert.assertTrue(productCardTotalCostComparison(productListFromHomePage, cartPage.getTotalPrice()));
    }

    @Test
    public void verifyPurgeProductsFromCart() {
        HomePage homePage = getHomePage();
        homePage.scrollToSaleProducts();
        homePage.putProductInCartByIndex(2);
        homePage.putProductInCartByIndex(3);

        CartPage cartPage = homePage.clickOnCartButton();
        List<Product> fullProductList = cartPage.getProductsFromCart();
        Product deletedProduct = cartPage.getProductFromCartByIndex(2);
        List<Product> purgedProductList = cartPage.getProductsFromCartAfterDeletingByIndex(2);

        Assert.assertEquals(purgedProductList.size(), fullProductList.size() - 1, "Product from cart wasn't deleted or delete more than one selected product");
        Assert.assertTrue(fullProductList.contains(deletedProduct), "deleted product wasn't put into cart");
        Assert.assertFalse(purgedProductList.contains(deletedProduct), "product wasn't deleted from cart");
        Assert.assertTrue(productCardTotalCostComparison(purgedProductList, cartPage.getTotalPrice()));
    }

    private HomePage getHomePage() {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        page.open();
        page.submitCookie();
        return page;
    }

    private boolean productListsComparison(List<Product> first, List<Product> second) {
        Assert.assertEquals(first.size(), second.size(), "Amount of product(s) in the cart isn't equals the amount of the selected product(s)");
        for (int i = 1; i < first.size(); i++)
            if (!first.get(i).equals(second.get(i)))
                return false;
        return true;
    }

    private boolean productCardTotalCostComparison(List<Product> products, BigDecimal cartTotal) {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (Product product : products)
            totalCost = totalCost.add(product.getCost());

        return totalCost.equals(cartTotal);
    }
}
