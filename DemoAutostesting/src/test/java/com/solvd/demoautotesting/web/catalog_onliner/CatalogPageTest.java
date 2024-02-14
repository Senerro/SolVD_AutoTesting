package com.solvd.demoautotesting.web.catalog_onliner;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Laptop;
import com.solvd.demoautotesting.web.catalog_onliner.pages.LaptopCatalogPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CatalogPageTest extends AbstractTest {
    @Test
    public void verifyFavoritesButton(){
        List<Laptop> laptopList = new ArrayList<>();
        LaptopCatalogPage catalogPage = new LaptopCatalogPage(getDriver());
        catalogPage.open();

        laptopList.add(catalogPage.getLaptopByIndex(2));
        laptopList.add(catalogPage.getLaptopByIndex(3));
        laptopList.add(catalogPage.getLaptopByIndex(4));


    }
}
