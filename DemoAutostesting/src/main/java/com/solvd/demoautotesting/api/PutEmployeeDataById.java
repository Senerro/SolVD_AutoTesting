/*
package com.solvd.demoautotesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = " ${config.api_url}/update/${id}", methodType = HttpMethodType.PUT)
@ResponseTemplatePath(path = "api/employee/put_employee_rs.json")
@RequestTemplatePath(path = "api/employee/put_employee_rq.json")
public class PutEmployeeDataById extends AbstractApiMethodV2 {
    public PutEmployeeDataById(int id){
        replaceUrlPlaceholder("id", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
*/
