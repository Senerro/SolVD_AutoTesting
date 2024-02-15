package com.solvd.demoautotesting.web.EpicGames.pages;

import com.solvd.demoautotesting.web.EpicGames.components.MainNavigationComponents;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//egs-navigation")
    private MainNavigationComponents navigationComponents;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private SearchContext getShadowRoot(WebDriver driver, WebElement rootElement) {
        return (SearchContext) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", rootElement);
    }

    public void setNavigationRootComponents() {
        this.navigationComponents = new MainNavigationComponents(getDriver(), getShadowRoot(driver, driver.findElement(By.xpath("//egs-navigation"))));
    }

    public void clickOnLoginButton(){
        navigationComponents.clickToLoginButton();
    }

    @Override
    public void open(){
        openURL("https://store.epicgames.com");
    }
}
