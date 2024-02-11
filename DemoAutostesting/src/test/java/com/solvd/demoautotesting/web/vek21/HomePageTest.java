package com.solvd.demoautotesting.web.vek21;

import com.solvd.demoautotesting.web.vek21.helpers.models.Product;
import com.solvd.demoautotesting.web.vek21.pages.HomePage;
import com.solvd.demoautotesting.web.vek21.pages.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class HomePageTest extends AbstractTest {
    @Test
    public void verifyProductInformation(){
        HomePage homePage = getHomePage();
        Product productFromStore = homePage.getProductByIndex(2);
        ProductPage productPage = homePage.clickOnProduct(2);
        Product productFromPage = productPage.getProduct();
        Assert.assertEquals(productFromPage, productFromStore);
    }

    private HomePage getHomePage(){
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        page.open();
        page.submitCookie();
        return page;
    }
}
