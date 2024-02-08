package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserBarComponent extends AbstractUIObject {
    @FindBy(xpath = ".//div[contains(@class, '--text')]")
    private ExtendedWebElement logByMyself;
    @FindBy(xpath = ".//div[contains(@class, '--gg')]")

    private ExtendedWebElement logByGoogle;
    @FindBy(xpath = ".//div[contains(@class, '--fb')]")

    private ExtendedWebElement logByFacebook;
    @FindBy(xpath = ".//div[contains(@class, '--vk')]")

    private ExtendedWebElement logByVK;
    public UserBarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getLogByMyself() {
        return logByMyself;
    }

    public ExtendedWebElement getLogByGoogle() {
        return logByGoogle;
    }

    public ExtendedWebElement getLogByFacebook() {
        return logByFacebook;
    }

    public ExtendedWebElement getLogByVK() {
        return logByVK;
    }
}
