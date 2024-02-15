package com.solvd.demoautotesting.web.EpicGames.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MainNavigationComponents extends AbstractUIObject {
    @FindBy(css = "a")
    private ExtendedWebElement logButton;

    public MainNavigationComponents(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickToLoginButton(){
        logButton.click();
    }
}
