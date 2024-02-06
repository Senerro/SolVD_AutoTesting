package com.solvd.demoautotesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.utils.config.Configuration;

public class GetEmployeeDataById extends AbstractApiMethodV2 {
    public GetEmployeeDataById(final int id) {
        super(null, "api/employee/get_employee_rs.json");
        replaceUrlPlaceholder("domain", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("id", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
