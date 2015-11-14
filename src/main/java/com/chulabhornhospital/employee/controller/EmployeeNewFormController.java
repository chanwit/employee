package com.chulabhornhospital.employee.controller;

import com.chulabhornhospital.employee.domain.Department;
import com.chulabhornhospital.employee.form.EmployeeList;
import com.chulabhornhospital.employee.form.EmployeeNew;
import com.chulabhornhospital.employee.mapper.custom.DepartmentListMapper;

import java.util.List;

import static com.chulabhornhospital.employee.util.SessionUtils.with;

/**
 * Created by Administrator on 11/14/2015.
 */
public class EmployeeNewFormController {

    private final EmployeeNew form;

    public EmployeeNewFormController(EmployeeNew mainForm) {
        this.form = mainForm;
    }

    public void listDepartments() throws Throwable {
        with(session -> {
            DepartmentListMapper dm = session.getMapper(DepartmentListMapper.class);
            final List<Department> result = dm.list(20L);
            form.setDepartments(result);
        });
    }

}
