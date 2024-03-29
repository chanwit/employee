package com.chulabhornhospital.employee.domain;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/14/2015.
 */
public privileged aspect EmployeeAdditionFields {

    public String Employee.getAge() {
        DateTime bd = new DateTime(this.getDob());
        Period period = new Period(bd, new DateTime());
        PeriodFormatter formatter = new PeriodFormatterBuilder()
                .appendYears().appendSuffix(" yr ")
                .appendMonths().appendSuffix(" mo ")
                .printZeroNever()
                .toFormatter();
        String elapsed = formatter.print(period).trim();
        return elapsed;
    }

    public String Employee.getFullName() {
        if (this.getFirstName() == null && this.getLastName() == null) {
            return null;
        }

        String firstName = this.getFirstName() == null ? "" : this.getFirstName();
        String lastName = this.getLastName() == null ? "" : this.getLastName();

        return String.format("%s %s", firstName, lastName).trim();
    }

    public Department Employee.getDepartment() {
        Department result = new Department();
        result.setId(this.getDepartmentId());
        return result;
    }

    private List<Email> Employee.emails;
    public List<Email> Employee.getEmails() {
        return this.emails;
    }
    public void Employee.setEmails(List<Email> value) {
        this.emails = value;
    }

    private List<Telephone> Employee.telephones;
    public List<Telephone> Employee.getTelephones() {
        return telephones;
    }
    public void Employee.setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }



}
