package com.solvd.demoautotesting.web.catalog_onliner.pages;

import com.solvd.demoautotesting.web.catalog_onliner.components.LaptopComponent;
import com.solvd.demoautotesting.web.catalog_onliner.components.SearchLineComponent;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Laptop;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LaptopCatalogPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='fast-search'][1]")
    private SearchLineComponent searchLineComponent;
    @FindBy(xpath = "//body")
    private LaptopComponent laptopComponent;

    public LaptopCatalogPage(WebDriver driver) {
        super(driver);
    }

    public Laptop getLaptopByIndex(int index){
        return laptopComponent.getLaptopByIndex(index);
    }

    @Override
    public void open(){
        openURL(Configuration.getRequired("catalog_onliner_laptop_url"));
    }

    public void clickOnFavoritesButtonByProductName(String name) {
        laptopComponent.clickFavoritesButtonByProductName(name);
    }
}
