package com.solvd.demoautotesting.web.pages.amazon;

import com.solvd.demoautotesting.web.components.amazon.ProductCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class, 'card-container')]")
    private List<ProductCard> cards;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> getCards() {
        return cards;
    }
}
