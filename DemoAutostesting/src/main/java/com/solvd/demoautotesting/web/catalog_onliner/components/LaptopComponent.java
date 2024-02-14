package com.solvd.demoautotesting.web.catalog_onliner.components;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.UserValidationDataType;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.isValidEnum;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Laptop;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.User;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.LaptopService;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.service.LoginService;
import com.solvd.demoautotesting.web.catalog_onliner.pages.MainLoginPage;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LaptopComponent extends AbstractUIObject {
    @FindBy(xpath = ".//div[contains(@class,'offers-unit')][2]//a[contains(@class, 'link catalog-form__link_primary-')]")
    private ExtendedWebElement laptopName;
    @FindBy(xpath = ".//div[contains(@class,'offers-unit')][2]//a[contains(@class, 'link catalog-form__link_nodecor')]")
    private ExtendedWebElement price;
    @FindBy(xpath = "//div[./div/div/div/div/a[contains(text(), 'NX.ADDER.01S')]]//div[contains(@class, 'handle_interactive')]/div[3]/label/div")
    private ExtendedWebElement favoriteButtonByProductName;

    public LaptopComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Laptop getLaptopByIndex(int index){
        return LaptopService.getLaptop(laptopName.getText(), price.format(index).getText());
    }

    public void clickFavoritesButtonByProductName(String name) {

        CommonUtils.pause(2);
        favoriteButtonByProductName.format(name).click();
        MainLoginPage loginPage = new MainLoginPage(driver);
        if (loginPage.isLoginInputPresent())
            new LoginService().login(User.provideUser(UserValidationDataType.Myself, isValidEnum.VALID), loginPage);
    }
}
