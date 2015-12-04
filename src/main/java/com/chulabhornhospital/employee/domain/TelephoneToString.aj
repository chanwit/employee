package com.chulabhornhospital.employee.domain;

/**
 * Created by Administrator on 12/4/2015.
 */
public privileged aspect TelephoneToString {

    public String Telephone.toString() {
            return String.format("%d: %s", this.getId(), this.getTelNumber());
    }

}
