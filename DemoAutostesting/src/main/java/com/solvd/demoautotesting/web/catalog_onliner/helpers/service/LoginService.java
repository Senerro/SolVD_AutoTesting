package com.solvd.demoautotesting.web.catalog_onliner.helpers.service;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.User;
import com.solvd.demoautotesting.web.catalog_onliner.pages.HomePage;
import com.solvd.demoautotesting.web.catalog_onliner.pages.MainLoginPage;

public class LoginService {
    public static void login(User user, MainLoginPage page) {
        page.typeLogin(user);
        page.typePass(user);
        page.clickLoginPage();
    }

    public static void loginActions(HomePage page, User user) {
        login(user, page.clickToLoginButton());
    }
}
