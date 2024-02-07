package com.solvd.demoautotesting.web.amazon;

import com.solvd.demoautotesting.web.components.amazon.SearchLineComponent;
import com.solvd.demoautotesting.web.pages.amazon.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {
    @Test
    public void verifySearchKineTest() {
        String inputText = "Iphone";
        SoftAssert sa = new SoftAssert();
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(getDriver());
        page.open();

        SearchLineComponent searchLine = page.getHeader().getSearchLineComponent();
        sa.assertTrue(searchLine.getProductTypeSelect().isElementPresent(1), "Product type select isn't present");
        Assert.assertTrue(searchLine.getSearchInput().isElementPresent(1), "Search input isn't present");
        sa.assertEquals(searchLine.getSearchInputPlaceholder(), "Search Amazon", "Serch input has an incorect ph");
        Assert.assertTrue(searchLine.getSearchButton().isElementPresent(1), "Search input isn't present");

        searchLine.typeSearchInputValue("Iphone");
        var newPage = searchLine.clickSearchButton();

        sa.assertTrue(webDriver.getCurrentUrl().toLowerCase().contains(inputText.toLowerCase()), "url doesn't have input text");
       /* List<ProductCard>  cards = newPage.getCards();
        for (ProductCard card : cards) {
            var a = card.getTitleText().toLowerCase();
            sa.assertTrue(card.getTitleText().toLowerCase().contains(inputText.toLowerCase()), String.format("product with name '%s' doesn't contain the input text in title", card.getTitleText()));
        }*/

        sa.assertAll();

        System.out.println();

    }
}
