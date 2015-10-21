package com.chulabhornhospital.employee;

import com.chulabhornhospital.employee.form.EmployeeList;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        EmployeeList mainForm = new EmployeeList();
        mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainForm.pack();
        mainForm.setVisible(true);
    }

}
