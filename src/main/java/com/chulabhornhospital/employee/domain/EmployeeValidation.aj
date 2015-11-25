package com.chulabhornhospital.employee.domain;

import javax.validation.constraints.NotNull;
import com.chulabhornhospital.Validatable;

public privileged aspect EmployeeValidation {

    declare @field: String Employee.firstName: @NotNull;
    declare @field: String Employee.lastName: @NotNull;

    declare parents: Employee implements Validatable<Employee>;

}
