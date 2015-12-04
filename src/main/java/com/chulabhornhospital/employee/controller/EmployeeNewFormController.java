package com.chulabhornhospital.employee.controller;

import com.chulabhornhospital.employee.domain.Department;
import com.chulabhornhospital.employee.domain.Email;
import com.chulabhornhospital.employee.domain.Employee;
import com.chulabhornhospital.employee.form.EmployeeNew;
import com.chulabhornhospital.employee.mapper.EmailMapper;
import com.chulabhornhospital.employee.mapper.EmployeeMapper;
import com.chulabhornhospital.employee.mapper.custom.DepartmentListMapper;
import com.chulabhornhospital.employee.mapper.custom.EmailListMapper;

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
            int result = 0;

            EmployeeMapper em = session.getMapper(EmployeeMapper.class);
            result = em.insert(employee);

            EmailMapper emailMapper = session.getMapper(EmailMapper.class);
            for (Email email : employee.getEmails()) {
                email.setId(null);
                email.setEmployeeId(employee.getId());
                result = result + emailMapper.insert(email);
            }
            return result;
        });
    }

    public int update(Employee employee) throws Throwable {
        return withUpdate(session -> {
            int result = 0;
            EmployeeMapper em = session.getMapper(EmployeeMapper.class);
            result = em.updateByPrimaryKeySelective(employee);

            EmailMapper emailMapper = session.getMapper(EmailMapper.class);
            for (Email email : employee.getEmails()) {
                if(email.getId() == 0L) {
                    email.setEmployeeId(employee.getId());
                    email.setId(null);
                    result = result + emailMapper.insert(email);
                } else if (email.getDirty() == true) {
                    result = result + emailMapper.updateByPrimaryKey(email);
                }
            }
            return result;
        });
    }

    public int delete(Employee employee) throws Throwable {
        return withUpdate(session -> {
            int result = 0;
            // change to cascade delete for better performance
            EmailListMapper elm = session.getMapper(EmailListMapper.class);
            result = elm.deleteByEmployeeId(employee.getId());

            EmployeeMapper em = session.getMapper(EmployeeMapper.class);
            result = result + em.deleteByPrimaryKey(employee.getId());

            return result;
        });
    }

    public void listEmailsByEmployee(Employee employee) throws Throwable {
        if (employee == null) {
            form.setEmployeeEmails(null);
            return;
        }

        if (employee.getId() == null || employee.getId() <= 0) {
            form.setEmployeeEmails(null);
            return;
        }

        with(session -> {
            EmailListMapper em = session.getMapper(EmailListMapper.class);
            List<Email> emails = em.listByEmployee(employee.getId());
            emails.forEach(it -> it.setDirty(false));
            form.setEmployeeEmails(emails);
        });
    }

    public void deleteEmail(Email email) throws Throwable {
        Long employeeId = email.getEmployeeId();
        int result = withUpdate(session -> {
            EmailMapper em = session.getMapper(EmailMapper.class);
            return em.deleteByPrimaryKey(email.getId());
        });
        if (result > 0) {
            Employee employee = new Employee();
            employee.setId(employeeId);
            listEmailsByEmployee(employee);
        }
    }
}
