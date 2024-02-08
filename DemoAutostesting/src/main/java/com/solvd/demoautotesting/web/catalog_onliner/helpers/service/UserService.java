package com.solvd.demoautotesting.web.catalog_onliner.helpers.service;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.UserValidationDataType;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.User;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.isValidEnum;

public class UserService {
    public User createUser(UserValidationDataType type, isValidEnum is){
        var a =  User.provideUser(type, is);
        return a;
    }
}
