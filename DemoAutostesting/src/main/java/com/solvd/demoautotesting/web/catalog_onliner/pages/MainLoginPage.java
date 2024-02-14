package com.solvd.demoautotesting.web.catalog_onliner.pages;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainLoginPage extends AbstractPage {
    @FindBy(xpath = "//form//div[@class='auth-form__row auth-form__row_condensed-alter'][1]//input")
    private ExtendedWebElement loginInput;
    @FindBy(xpath = "//form//div[@class='auth-form__row auth-form__row_condensed-alter'][2]//input")
    private ExtendedWebElement passInput;
    @FindBy(xpath = "//form//div[@class='auth-form__control auth-form__control_condensed-additional']//button[@type='submit']")
    private ExtendedWebElement submitButton;

    public MainLoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeLogin(User user){
        loginInput.type(user.getLogin());
    }

    public void typePass(User user){
        passInput.type(user.getPass());
    }

    public void clickLoginPage(){
        submitButton.click();
    }

    public boolean isSubmitButtonPresent() {
        return submitButton.isElementPresent(1);
    }

    public boolean isPassInputPresent() {
        return passInput.isElementPresent(1);
    }

    public boolean isLoginInputPresent() {
        return loginInput.isElementPresent(1);
    }
}
