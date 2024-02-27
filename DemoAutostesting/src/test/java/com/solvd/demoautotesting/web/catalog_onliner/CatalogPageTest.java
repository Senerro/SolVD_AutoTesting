package com.solvd.demoautotesting.web.catalog_onliner;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.ProductPageButtonsRuEnum;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.UserValidationDataType;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.isValidEnum;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Product;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.User;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.LoginService;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.ProductService;
import com.solvd.demoautotesting.web.catalog_onliner.pages.BookmarksPage;
import com.solvd.demoautotesting.web.catalog_onliner.pages.HomePage;
import com.solvd.demoautotesting.web.catalog_onliner.pages.ProductsCatalogPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class CatalogPageTest extends AbstractTest {
    @Test
    public void verifyFavoritesButton() {
        List<Product> productsSaleList = new ArrayList<>();
        List<Product> productsBookmarksList = new ArrayList<>();
        HomePage homePage = HomePage.getHomePage(getDriver());
        LoginService.loginActions(homePage, User.provideUser(UserValidationDataType.Myself, isValidEnum.VALID));

        ProductsCatalogPage catalogPage = homePage.selectProductCategory(ProductPageButtonsRuEnum.NOTEBOOK);
        productsSaleList.add(catalogPage.getProductByIndex(2));
        productsSaleList.add(catalogPage.getProductByIndex(4));

        catalogPage.clickOnFavoritesButtonByProductName(productsSaleList.get(0).getName());
        catalogPage.clickOnFavoritesButtonByProductName(productsSaleList.get(1).getName());

        Assert.assertTrue(catalogPage.isFavoritesButtonPresent());
        BookmarksPage bookmarksPage = catalogPage.goToBookmarksPage();
        productsSaleList = bookmarksPage.getProductsList();
        Assert.assertTrue(ProductService.productListsEquals(productsSaleList, productsBookmarksList));
    }

}
