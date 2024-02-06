package com.solvd.demoautotesting;

import com.solvd.demoautotesting.api.DeleteEmployeeById;
import com.solvd.demoautotesting.api.GetEmployeeDataById;
import com.solvd.demoautotesting.api.PostEmployeeByJson;
import com.solvd.demoautotesting.api.PutEmployeeDataById;
import com.solvd.demoautotesting.models.Employee;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

import java.util.Objects;

public class EmployeeTest {
    @Test
    public void verifyEmployeeByIdTest() {
        Employee employee = new Employee(1, "Tiger Nixon", 320800, 61);

        GetEmployeeDataById employeeDataById = new GetEmployeeDataById(1);
        employeeDataById.addProperty("employee", employee);

        employeeDataById.expectResponseStatus(HttpResponseStatusType.OK_200);
        employeeDataById.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<Integer>withPredicate("id", id -> Objects.equals(id, employee.getId()))
                .<Integer>withPredicate("salary", salary -> Objects.equals(salary, employee.getSalary()))
                .<Integer>withPredicate("age", age -> Objects.equals(age, employee.getAge()));

        employeeDataById.validateResponse(comparatorContext);
    }

    @Test
    public void verifyDeleteByIdTest() {
        Employee employee = new Employee(1, "Tiger Nixon", 320800, 61);
        DeleteEmployeeById deleteEmployeeById = new DeleteEmployeeById(employee.getId());

        deleteEmployeeById.addProperty("employee", employee);

        deleteEmployeeById.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteEmployeeById.callAPI();
        deleteEmployeeById.validateResponse();
    }
    @Test
    public void verifyPostTest() {
        Employee employee = new Employee(25, "test", 123, 23);
        PostEmployeeByJson postEmployeeByJson = new PostEmployeeByJson();

        postEmployeeByJson.addProperty("employee", employee);
        postEmployeeByJson.expectResponseStatus(HttpResponseStatusType.OK_200);
        postEmployeeByJson.callAPI();
        postEmployeeByJson.validateResponse();
    }
    @Test
    public void verifyPutByIdTest() {
        Employee employee = new Employee(25, "test", 123, 23);
        PutEmployeeDataById putEmployeeByJson = new PutEmployeeDataById(employee.getId());

        putEmployeeByJson.addProperty("employee", employee);
        putEmployeeByJson.expectResponseStatus(HttpResponseStatusType.OK_200);
        putEmployeeByJson.callAPI();
        putEmployeeByJson.validateResponse();
    }
}
