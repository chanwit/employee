package com.chulabhornhospital.employee.domain;

/**
 * Created by Administrator on 11/14/2015.
 */
public privileged aspect DepartmentToString {

    public String Department.toString() {
        return String.format("%d: %s", this.getId(), this.getName());
    }


}
