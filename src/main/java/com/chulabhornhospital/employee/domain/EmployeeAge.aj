package com.chulabhornhospital.employee.domain;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public privileged aspect EmployeeAge {

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

}
