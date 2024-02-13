package com.solvd.demoautotesting.web.catalog_onliner.helpers.models;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.UserValidationDataType;
import com.solvd.demoautotesting.web.catalog_onliner.helpers.enums.isValidEnum;
import com.zebrunner.carina.utils.R;

public class User {
    private final String login;
    private final String pass;

    private User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public static User provideUser(UserValidationDataType userType, isValidEnum isValid) {
        return isValid.equals(isValidEnum.VALID) ? getValidUserByDataType(userType) : getInvalidUserByType();
    }

    private static User getInvalidUserByType() {
        return new User(R.TESTDATA.get("invalid.log"), R.TESTDATA.get("invalid.pass"));
    }

    private static User getValidUserByDataType(UserValidationDataType userType) {
        return switch (userType) {
            case VK -> new User(R.TESTDATA.get("VK.valid.log"), R.TESTDATA.get("VK.valid.pass"));
            case Google -> new User(R.TESTDATA.get("Google.valid.log"), R.TESTDATA.get("Google.valid.pass"));
            case FaceBook -> new User(R.TESTDATA.get("FB.valid.log"), R.TESTDATA.get("FB.valid.pass"));
            case Myself -> new User(R.TESTDATA.get("Myself.valid.log"), R.TESTDATA.get("Myself.valid.pass"));
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
