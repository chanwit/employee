package com.chulabhornhospital.employee.domain;

/**
 * Created by Administrator on 11/14/2015.
 */
public privileged aspect EmployeeFullName {

    public String Employee.getFullName() {
        if (this.getFirstName() == null && this.getLastName() == null) {
            return null;
        }

        String firstName = this.getFirstName()==null? "": this.getFirstName();
        String lastName = this.getLastName()==null? "": this.getLastName();

        return String.format("%s %s", firstName, lastName).trim();
    }

}
