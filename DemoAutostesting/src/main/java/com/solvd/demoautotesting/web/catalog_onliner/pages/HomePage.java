package com.solvd.demoautotesting.web.catalog_onliner.pages;

import com.solvd.demoautotesting.web.catalog_onliner.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//header")
    private Header header;
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public Header getHeader() {
        return header;
    }

    @Override
    public void open(){
        openURL(Configuration.getRequired("catalog_onliner_home_url"));
    }
}
