/*
 * Created by JFormDesigner on Wed Oct 21 22:25:12 ICT 2015
 */

package com.chulabhornhospital.employee.form;

import java.awt.event.*;
import javax.swing.event.*;

import com.chulabhornhospital.Validatable;
import com.chulabhornhospital.employee.controller.EmployeeNewFormController;
import com.chulabhornhospital.employee.domain.Department;
import com.chulabhornhospital.employee.domain.Email;
import com.chulabhornhospital.employee.domain.Employee;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.validation.ConstraintViolation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Worajedt Sitthidumrong
 */
public class EmployeeNew extends JDialog {

    private final EmployeeNewFormController controller;

    public EmployeeNew() {
        initComponents();
        initEmployee();
        controller = new EmployeeNewFormController(this);
        try {
            controller.listDepartments();
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void initEmployee() {
        Employee newEmployee = new Employee();
        newEmployee.setDob(new Date());
        newEmployee.setBeingHired(false);
        newEmployee.setGender(true);
        newEmployee.setBeingHired(false);
        newEmployee.setSalary(new BigDecimal(10000));
        setEmployee(newEmployee);
    }

    private void btnBackActionPerformed(ActionEvent e) {
        this.dispose();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee value) {
        Employee old = this.employee;
        this.employee = value;
        try {
            controller.listEmailsByEmployee(getEmployee());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        firePropertyChange("employee", old, this.employee);
    }

    public void setEmployeeEmails(List<Email> employeeEmails) {
        List<Email> old = this.employeeEmails;
        this.employeeEmails = employeeEmails;
        firePropertyChange("employeeEmails", old, this.employeeEmails);
    }

    private void textField4PropertyChange(PropertyChangeEvent e) {
        firePropertyChange("employee", null, getEmployee());
    }

    private void btnSaveActionPerformed(ActionEvent ev) {
        Set<ConstraintViolation<Employee>> errors = ((Validatable) this.employee).validate();
        String errMsg ="";
        for(ConstraintViolation<Employee> cv: errors) {
            errMsg += String.format("Property '%s' %s.\n", cv.getPropertyPath(), cv.getMessage());
        }
        if(errors.isEmpty() == false) {
            JOptionPane.showMessageDialog(this, errMsg);
            return;
        }

        this.employee.setEmails(employeeEmails);
        try {
            if (this.employee.getId() == null) {
                controller.insert(this.employee);
            } else {
                controller.update(this.employee);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public List<com.chulabhornhospital.employee.domain.Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
        firePropertyChange("departments", null, departments);
    }

    private void departmentItemStateChanged(ItemEvent e) {
        Department department = (Department) e.getItem();
        employee.setDepartmentId(department.getId());
        firePropertyChange("employee", null, employee);
    }

    private void btnDeleteActionPerformed(ActionEvent e) {
        try {
            controller.delete(employee);
            this.dispose();
        } catch (Throwable throwable) {
            JOptionPane.showMessageDialog(this, throwable.getMessage());
        }
    }

    private void checkBox1StateChanged(ChangeEvent e) {
        if(checkBox1.isSelected()) {
            checkBox1.setForeground(Color.GREEN);
            checkBox1.setText("Being Hired");
        } else {
            checkBox1.setForeground(Color.RED);
            checkBox1.setText("Not Hired");
        }
    }

    public List<com.chulabhornhospital.employee.domain.Email> getEmployeeEmails() {
        return employeeEmails;
    }

    private void employeeEmailFocusLost(FocusEvent e) {
        List<Email> list = getEmployeeEmails();
        int index = lstEmployeeEmails.getSelectedIndex();
        setEmployeeEmails(null);
        setEmployeeEmails(list);
        lstEmployeeEmails.setSelectedIndex(index);
    }

    private void addEmail() {
        Email email = new Email();
        email.setId(0L);
        email.setDirty(true);
        email.setEmailAddress("noone@somewhere.com");
        email.setEmployeeId(this.employee.getId());

        List<Email> list = employeeEmails;
        if(employeeEmails == null) {
            list = new ArrayList<Email>();
        }
        list.add(email);
        setEmployeeEmails(null);
        setEmployeeEmails(list);
        lstEmployeeEmails.setSelectedIndex(employeeEmails.size()-1);
    }

    private void btnAddEmailActionPerformed(ActionEvent e) {
        addEmail();
    }

    private void button6ActionPerformed(ActionEvent e) {
        Email emailToDelete = lstEmployeeEmails.getSelectedValue();
        if(emailToDelete != null) {
            try {
                controller.deleteEmail(emailToDelete);
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(this, throwable.getMessage());
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        btnBack = new JButton();
        label2 = new JLabel();
        textField1 = new JTextField();
        label7 = new JLabel();
        textField3 = new JTextField();
        panel1 = new JPanel();
        label3 = new JLabel();
        panel2 = new JPanel();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        label8 = new JLabel();
        textField4 = new JXDatePicker();
        label4 = new JLabel();
        comboBox1 = new JComboBox<>();
        label11 = new JLabel();
        label12 = new JLabel();
        label9 = new JLabel();
        textField5 = new JTextField();
        label5 = new JLabel();
        button5 = new JButton();
        textField6 = new JTextField();
        label10 = new JLabel();
        panel3 = new JPanel();
        button1 = new JButton();
        button6 = new JButton();
        textField7 = new JTextField();
        scrollPane2 = new JScrollPane();
        list2 = new JList();
        scrollPane3 = new JScrollPane();
        lstEmployeeEmails = new JList<>();
        label6 = new JLabel();
        textField2 = new JTextField();
        checkBox1 = new JCheckBox();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        employee = new Employee();

        //======== this ========
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "2*($ugap), default:grow, $ugap, 20dlu:grow, $lcgap, 2*(16dlu:grow), $ugap, default:grow, $ugap, 20dlu:grow, $rgap, 2*(16dlu:grow), $ugap, 2*(default:grow), $ugap",
            "2*($lgap), default, $lgap, 16dlu, 5*($lgap, default), $lgap, top:default, $lgap, default, $lgap, 16dlu, 2*($lgap, default)"));

        //---- label1 ----
        label1.setText("New Employee");
        label1.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(label1, CC.xywh(2, 3, 7, 1));

        //---- btnBack ----
        btnBack.setText("<< Back");
        btnBack.setBackground(new Color(255, 102, 102));
        btnBack.addActionListener(e -> btnBackActionPerformed(e));
        contentPane.add(btnBack, CC.xywh(17, 3, 2, 1));

        //---- label2 ----
        label2.setText("First Name");
        contentPane.add(label2, CC.xywh(2, 7, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(textField1, CC.xywh(5, 7, 4, 1));

        //---- label7 ----
        label7.setText("Last Name");
        contentPane.add(label7, CC.xywh(9, 7, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(textField3, CC.xywh(12, 7, 4, 1));

        //======== panel1 ========
        {
            panel1.setBorder(LineBorder.createBlackLineBorder());
            panel1.setLayout(new FormLayout(
                "default:grow",
                "default:grow"));
        }
        contentPane.add(panel1, CC.xywh(17, 7, 2, 8));

        //---- label3 ----
        label3.setText("Gender");
        contentPane.add(label3, CC.xywh(2, 9, 2, 1, CC.RIGHT, CC.DEFAULT));

        //======== panel2 ========
        {
            panel2.setLayout(new FormLayout(
                "default:grow, $lcgap, default:grow",
                "default"));

            //---- radioButton2 ----
            radioButton2.setText("Male");
            radioButton2.setSelected(true);
            panel2.add(radioButton2, CC.xy(1, 1));

            //---- radioButton3 ----
            radioButton3.setText("Female");
            panel2.add(radioButton3, CC.xy(3, 1));
        }
        contentPane.add(panel2, CC.xywh(5, 9, 4, 1));

        //---- label8 ----
        label8.setText("DOB");
        contentPane.add(label8, CC.xywh(9, 9, 2, 1, CC.RIGHT, CC.DEFAULT));

        //---- textField4 ----
        textField4.addPropertyChangeListener("date", e -> textField4PropertyChange(e));
        contentPane.add(textField4, CC.xywh(12, 9, 4, 1));

        //---- label4 ----
        label4.setText("Department");
        contentPane.add(label4, CC.xywh(2, 11, 2, 1, CC.RIGHT, CC.DEFAULT));

        //---- comboBox1 ----
        comboBox1.addItemListener(e -> departmentItemStateChanged(e));
        contentPane.add(comboBox1, CC.xywh(5, 11, 4, 1));

        //---- label11 ----
        label11.setText("Age");
        contentPane.add(label11, CC.xywh(9, 11, 2, 1, CC.RIGHT, CC.DEFAULT));

        //---- label12 ----
        label12.setText("text");
        contentPane.add(label12, CC.xywh(12, 11, 4, 1));

        //---- label9 ----
        label9.setText("Salary");
        contentPane.add(label9, CC.xywh(9, 13, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(textField5, CC.xywh(12, 13, 4, 1));

        //---- label5 ----
        label5.setText("Tel");
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label5, CC.xy(3, 15));

        //---- button5 ----
        button5.setText("+");
        contentPane.add(button5, CC.xy(5, 15));
        contentPane.add(textField6, CC.xywh(7, 15, 2, 1));

        //---- label10 ----
        label10.setText("Email");
        label10.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label10, CC.xy(10, 15));

        //======== panel3 ========
        {
            panel3.setLayout(new FormLayout(
                "default:grow, pref:grow",
                "default"));

            //---- button1 ----
            button1.setText("+");
            button1.addActionListener(e -> btnAddEmailActionPerformed(e));
            panel3.add(button1, CC.xy(1, 1));

            //---- button6 ----
            button6.setText("-");
            button6.addActionListener(e -> button6ActionPerformed(e));
            panel3.add(button6, CC.xy(2, 1));
        }
        contentPane.add(panel3, CC.xy(12, 15));

        //---- textField7 ----
        textField7.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                employeeEmailFocusLost(e);
            }
        });
        contentPane.add(textField7, CC.xywh(14, 15, 2, 1));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(list2);
        }
        contentPane.add(scrollPane2, CC.xywh(5, 17, 4, 1));

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(lstEmployeeEmails);
        }
        contentPane.add(scrollPane3, CC.xywh(12, 17, 4, 1));

        //---- label6 ----
        label6.setText("Nick Name");
        contentPane.add(label6, CC.xywh(2, 19, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(textField2, CC.xywh(5, 19, 4, 1));

        //---- checkBox1 ----
        checkBox1.setText("Being Hired");
        checkBox1.addChangeListener(e -> checkBox1StateChanged(e));
        contentPane.add(checkBox1, CC.xywh(12, 19, 3, 1));

        //---- button2 ----
        button2.setText("Save");
        button2.setMaximumSize(new Dimension(28, 23));
        button2.setMinimumSize(new Dimension(28, 23));
        button2.setPreferredSize(new Dimension(28, 23));
        button2.setBackground(new Color(0, 153, 51));
        button2.addActionListener(e -> btnSaveActionPerformed(e));
        contentPane.add(button2, CC.xy(5, 23));

        //---- button3 ----
        button3.setText("Cancel");
        button3.setPreferredSize(new Dimension(28, 23));
        button3.setMinimumSize(new Dimension(28, 23));
        button3.setMaximumSize(new Dimension(28, 23));
        contentPane.add(button3, CC.xy(7, 23));

        //---- button4 ----
        button4.setText("Delete");
        button4.setPreferredSize(new Dimension(28, 23));
        button4.setBackground(new Color(255, 102, 102));
        button4.addActionListener(e -> btnDeleteActionPerformed(e));
        contentPane.add(button4, CC.xy(15, 23));
        pack();
        setLocationRelativeTo(null);

        //---- employee ----
        employee.setGender(true);

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);

        //---- bindings ----
        bindingGroup = new BindingGroup();
        {
            Binding binding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
                this, BeanProperty.create("employee.firstName"),
                textField1, BeanProperty.create("text"));
            bindingGroup.addBinding(binding);
            binding.bind();
        }
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            this, BeanProperty.create("employee.lastName"),
            textField3, BeanProperty.create("text")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            this, BeanProperty.create("employee.gender"),
            radioButton2, BeanProperty.create("selected")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            this, BeanProperty.create("employee.dob"),
            textField4, BeanProperty.create("date")));
        bindingGroup.addBinding(SwingBindings.createJComboBoxBinding(UpdateStrategy.READ,
            this, (BeanProperty) BeanProperty.create("departments"), comboBox1));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            this, BeanProperty.create("employee.age"),
            label12, BeanProperty.create("text")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            this, BeanProperty.create("employee.salary"),
            textField5, BeanProperty.create("text")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            this, BeanProperty.create("employee.nickName"),
            textField2, BeanProperty.create("text")));
        {
            Binding binding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
                this, BeanProperty.create("employee.beingHired"),
                checkBox1, BeanProperty.create("selected"));
            binding.setSourceNullValue(false);
            binding.setSourceUnreadableValue(false);
            bindingGroup.addBinding(binding);
        }
        {
            Binding binding = Bindings.createAutoBinding(UpdateStrategy.READ,
                this, BeanProperty.create("employee.fullName"),
                label1, BeanProperty.create("text"));
            binding.setSourceNullValue("New Employee");
            binding.setSourceUnreadableValue("New Employee");
            bindingGroup.addBinding(binding);
        }
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            this, BeanProperty.create("employee.department"),
            comboBox1, BeanProperty.create("selectedItem")));
        bindingGroup.addBinding(SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE,
            this, (BeanProperty) BeanProperty.create("employeeEmails"), lstEmployeeEmails));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            lstEmployeeEmails, BeanProperty.create("selectedElement.emailAddress"),
            textField7, BeanProperty.create("text")));
        bindingGroup.bind();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton btnBack;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label7;
    private JTextField textField3;
    private JPanel panel1;
    private JLabel label3;
    private JPanel panel2;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JLabel label8;
    private JXDatePicker textField4;
    private JLabel label4;
    private JComboBox<com.chulabhornhospital.employee.domain.Department> comboBox1;
    private JLabel label11;
    private JLabel label12;
    private JLabel label9;
    private JTextField textField5;
    private JLabel label5;
    private JButton button5;
    private JTextField textField6;
    private JLabel label10;
    private JPanel panel3;
    private JButton button1;
    private JButton button6;
    private JTextField textField7;
    private JScrollPane scrollPane2;
    private JList list2;
    private JScrollPane scrollPane3;
    private JList<com.chulabhornhospital.employee.domain.Email> lstEmployeeEmails;
    private JLabel label6;
    private JTextField textField2;
    private JCheckBox checkBox1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private Employee employee;
    private List<com.chulabhornhospital.employee.domain.Department> departments;
    private List<com.chulabhornhospital.employee.domain.Email> employeeEmails;
    private List<com.chulabhornhospital.employee.domain.Telephone> employeeTels;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
