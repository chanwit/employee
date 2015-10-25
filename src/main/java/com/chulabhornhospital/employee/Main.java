package com.chulabhornhospital.employee;

import com.chulabhornhospital.employee.form.EmployeeList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.io.Reader;

public class Main {

    private static SqlSessionFactory factory;

    public static SqlSessionFactory getFactory() throws Throwable {
        if(factory == null) {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        }
        return factory;
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        EmployeeList mainForm = new EmployeeList();
        mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainForm.pack();
        mainForm.setVisible(true);
    }

}
