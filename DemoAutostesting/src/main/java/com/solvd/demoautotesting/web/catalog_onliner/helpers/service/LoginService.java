package com.solvd.demoautotesting.web.catalog_onliner.helpers.service;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.User;
import com.solvd.demoautotesting.web.catalog_onliner.pages.HomePage;
import com.solvd.demoautotesting.web.catalog_onliner.pages.MainLoginPage;

public class LoginService {
    public void login(User user, MainLoginPage page){
        page.typeLogin(user);
        page.typePass(user);
        page.clickLoginPage();
    }
}
