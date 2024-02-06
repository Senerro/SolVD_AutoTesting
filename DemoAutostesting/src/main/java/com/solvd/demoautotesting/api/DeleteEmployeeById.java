package com.solvd.demoautotesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = " ${config.api_url}/delete/${id}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/employee/delete_employee_rs.json")
public class DeleteEmployeeById extends AbstractApiMethodV2 {
    public DeleteEmployeeById(int id) {
        replaceUrlPlaceholder("id", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
