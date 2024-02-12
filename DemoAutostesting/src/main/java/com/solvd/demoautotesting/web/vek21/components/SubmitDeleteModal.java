package com.solvd.demoautotesting.web.vek21.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubmitDeleteModal extends AbstractUIObject {
    @FindBy(xpath = ".//button[@data-testid='modal-confirmation-button']")
    private ExtendedWebElement deleteButton;

    public SubmitDeleteModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void confirm(){
        deleteButton.click();
    }

}
