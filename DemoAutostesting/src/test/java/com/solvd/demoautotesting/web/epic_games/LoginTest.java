package com.solvd.demoautotesting.web.epic_games;

import com.solvd.demoautotesting.web.EpicGames.pages.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {
    @Test
    public void verifyValidLogin() {
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\chromedriver.exe");
        /*WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://store.epicgames.com");*/

        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        page.open();
        page.setNavigationRootComponents();


        page.clickOnLoginButton();
        System.out.println();
    }

    private SearchContext getShadowRoot(WebDriver driver, WebElement rootElement) {
        return (SearchContext) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", rootElement);
    }

}
