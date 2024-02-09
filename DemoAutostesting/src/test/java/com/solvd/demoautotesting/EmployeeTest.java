package com.solvd.demoautotesting;

import com.solvd.demoautotesting.api.DeleteEmployeeById;
import com.solvd.demoautotesting.api.GetEmployeeDataById;
import com.solvd.demoautotesting.api.PostEmployeeByJson;
import com.solvd.demoautotesting.api.PutEmployeeDataById;
import com.solvd.demoautotesting.models.Employee;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

import java.util.Objects;

public class EmployeeTest {
    @Test
    public void verifyEmployeeByIdTest() {
        Employee employee = new Employee(1, "Tiger Nixon", 320800, 61);

        GetEmployeeDataById employeeDataById = new GetEmployeeDataById(1);
        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<Integer>withPredicate("id", id -> Objects.equals(id, employee.getId()))
                .<Integer>withPredicate("salary", salary -> Objects.equals(salary, employee.getSalary()))
                .<Integer>withPredicate("age", age -> Objects.equals(age, employee.getAge()));
        invokeEmployeeTestApi(employeeDataById, employee, comparatorContext);
    }

    @Test
    public void verifyDeleteByIdTest() {
        Employee employee = new Employee(1, "Tiger Nixon", 320800, 61);
        DeleteEmployeeById deleteEmployeeById = new DeleteEmployeeById(employee.getId());
        invokeEmployeeTestApi(deleteEmployeeById, employee);
    }

    @Test
    public void verifyPostTest() {
        Employee employee = new Employee(25, "test", 123, 23);
        PostEmployeeByJson postEmployeeByJson = new PostEmployeeByJson();
        invokeEmployeeTestApi(postEmployeeByJson, employee);
    }

    @Test
    public void verifyPutByIdTest() {
        Employee employee = new Employee(25, "test", 123, 23);
        PutEmployeeDataById putEmployeeByJson = new PutEmployeeDataById(employee.getId());
        invokeEmployeeTestApi(putEmployeeByJson, employee);
    }

    private void invokeEmployeeTestApi(AbstractApiMethodV2 test, Employee employee, JsonComparatorContext comparatorContext ) {
        test.addProperty("employee", employee);
        test.expectResponseStatus(HttpResponseStatusType.OK_200);
        test.callAPI();
        test.validateResponse(comparatorContext);
    }

    private void invokeEmployeeTestApi(AbstractApiMethodV2 test, Employee employee ) {
        invokeEmployeeTestApi(test, employee, null);
    }
}
