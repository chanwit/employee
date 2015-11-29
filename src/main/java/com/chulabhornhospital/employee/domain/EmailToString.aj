package com.chulabhornhospital.employee.domain;

/**
 * Created by Administrator on 11/27/2015.
 */
public privileged aspect EmailToString {

    public String Email.toString() {
        return String.format("%d: %s", this.getId(), this.getEmailAddress());
    }

}
