package com.chulabhornhospital.employee.controller;

import com.chulabhornhospital.employee.domain.Department;
import com.chulabhornhospital.employee.domain.Employee;
import com.chulabhornhospital.employee.form.EmployeeList;
import com.chulabhornhospital.employee.mapper.custom.DepartmentListMapper;
import com.chulabhornhospital.employee.mapper.custom.EmployeeListMapper;

import java.util.List;

import static com.chulabhornhospital.employee.util.SessionUtils.with;

public class EmployeeListFormController {

    private final EmployeeList form;

    public EmployeeListFormController(EmployeeList mainForm) {
        this.form = mainForm;
    }

    public void listEmployees() throws Throwable {
        with((session) -> {
            EmployeeListMapper em = session.getMapper(EmployeeListMapper.class);
            final List<Employee> result = em.list(10L);
            form.setEmployees(result);
        });
    }


    public void search(String text) throws Throwable {
        with((session) -> {
            EmployeeListMapper em = session.getMapper(EmployeeListMapper.class);
            final List<Employee> result = em.search("%" + text + "%");
            form.setEmployees(result);
        });
    }
}
