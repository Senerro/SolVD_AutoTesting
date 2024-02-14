package com.solvd.demoautotesting.web.vek21.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CookieComponent extends AbstractUIObject {
    @FindBy(xpath = ".//button[2]")
    private ExtendedWebElement submitCookieButton;

    public CookieComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void submitCookie(){
        submitCookieButton.clickIfPresent(1);
    }

    public ExtendedWebElement getSubmitCookieButton() {
        return submitCookieButton;
    }
}
