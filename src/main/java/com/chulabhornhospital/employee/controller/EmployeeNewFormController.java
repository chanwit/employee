package com.chulabhornhospital.employee.controller;

import com.chulabhornhospital.employee.domain.Department;
import com.chulabhornhospital.employee.domain.Employee;
import com.chulabhornhospital.employee.form.EmployeeList;
import com.chulabhornhospital.employee.form.EmployeeNew;
import com.chulabhornhospital.employee.mapper.EmployeeMapper;
import com.chulabhornhospital.employee.mapper.custom.DepartmentListMapper;

import java.util.List;

import static com.chulabhornhospital.employee.util.SessionUtils.with;
import static com.chulabhornhospital.employee.util.SessionUtils.withUpdate;

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

    public int insert(Employee employee) throws Throwable {
        return withUpdate(session -> {
            EmployeeMapper em = session.getMapper(EmployeeMapper.class);
            return em.insert(employee);
        });
    }

    public int update(Employee employee) throws Throwable {
        return withUpdate(session -> {
            EmployeeMapper em = session.getMapper(EmployeeMapper.class);
            return em.updateByPrimaryKeySelective(employee);
        });
    }

    public int delete(Employee employee) throws Throwable {
        return withUpdate(session -> {
            EmployeeMapper em = session.getMapper(EmployeeMapper.class);
            return em.deleteByPrimaryKey(employee.getId());
        });
    }
}
