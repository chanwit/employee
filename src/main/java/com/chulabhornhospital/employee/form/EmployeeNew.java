/*
 * Created by JFormDesigner on Wed Oct 21 22:25:12 ICT 2015
 */

package com.chulabhornhospital.employee.form;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Worajedt Sitthidumrong
 */
public class EmployeeNew extends JFrame {
    public EmployeeNew() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        button1 = new JButton();
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
        textField4 = new JTextField();
        label4 = new JLabel();
        comboBox1 = new JComboBox();
        label11 = new JLabel();
        label12 = new JLabel();
        label9 = new JLabel();
        textField5 = new JTextField();
        label5 = new JLabel();
        scrollPane2 = new JScrollPane();
        list2 = new JList();
        label10 = new JLabel();
        scrollPane3 = new JScrollPane();
        list3 = new JList();
        label6 = new JLabel();
        textField2 = new JTextField();
        checkBox1 = new JCheckBox();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(800, 600));
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "2*($ugap), default:grow, $ugap, 3*(16dlu:grow), $ugap, default:grow, $ugap, 3*(16dlu:grow), $ugap, 2*(default:grow), $ugap",
            "2*($lgap), default, $lgap, 16dlu, 4*($lgap, default), $lgap, top:default, $lgap, default, $lgap, 16dlu, 2*($lgap, default)"));

        //---- label1 ----
        label1.setText("New Employee");
        label1.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(label1, CC.xywh(2, 3, 6, 1));

        //---- button1 ----
        button1.setText("<< Back");
        contentPane.add(button1, CC.xywh(15, 3, 2, 1));

        //---- label2 ----
        label2.setText("First Name");
        contentPane.add(label2, CC.xywh(2, 7, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(textField1, CC.xywh(5, 7, 3, 1));

        //---- label7 ----
        label7.setText("Last Name");
        contentPane.add(label7, CC.xywh(8, 7, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(textField3, CC.xywh(11, 7, 3, 1));

        //======== panel1 ========
        {
            panel1.setBorder(LineBorder.createBlackLineBorder());
            panel1.setLayout(new FormLayout(
                "default:grow",
                "default:grow"));
        }
        contentPane.add(panel1, CC.xywh(15, 7, 2, 8));

        //---- label3 ----
        label3.setText("Gender");
        contentPane.add(label3, CC.xywh(2, 9, 2, 1, CC.RIGHT, CC.DEFAULT));

        //======== panel2 ========
        {
            panel2.setLayout(new FormLayout(
                "default:grow, $lcgap, default:grow",
                "default"));

            //---- radioButton2 ----
            radioButton2.setText("text");
            panel2.add(radioButton2, CC.xy(1, 1));

            //---- radioButton3 ----
            radioButton3.setText("text");
            panel2.add(radioButton3, CC.xy(3, 1));
        }
        contentPane.add(panel2, CC.xywh(5, 9, 3, 1));

        //---- label8 ----
        label8.setText("DOB");
        contentPane.add(label8, CC.xywh(8, 9, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(textField4, CC.xywh(11, 9, 2, 1));

        //---- label4 ----
        label4.setText("Department");
        contentPane.add(label4, CC.xywh(2, 11, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(comboBox1, CC.xywh(5, 11, 3, 1));

        //---- label11 ----
        label11.setText("Age");
        contentPane.add(label11, CC.xywh(8, 11, 2, 1, CC.RIGHT, CC.DEFAULT));

        //---- label12 ----
        label12.setText("text");
        contentPane.add(label12, CC.xywh(11, 11, 3, 1));

        //---- label9 ----
        label9.setText("Salary");
        contentPane.add(label9, CC.xywh(8, 13, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(textField5, CC.xywh(11, 13, 3, 1));

        //---- label5 ----
        label5.setText("Tel");
        contentPane.add(label5, CC.xywh(2, 15, 2, 1, CC.RIGHT, CC.DEFAULT));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(list2);
        }
        contentPane.add(scrollPane2, CC.xywh(5, 15, 3, 1));

        //---- label10 ----
        label10.setText("Email");
        contentPane.add(label10, CC.xywh(8, 15, 2, 1, CC.RIGHT, CC.DEFAULT));

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(list3);
        }
        contentPane.add(scrollPane3, CC.xywh(11, 15, 3, 1));

        //---- label6 ----
        label6.setText("Nick Name");
        contentPane.add(label6, CC.xywh(2, 17, 2, 1, CC.RIGHT, CC.DEFAULT));
        contentPane.add(textField2, CC.xywh(5, 17, 3, 1));

        //---- checkBox1 ----
        checkBox1.setText("Not Hired");
        contentPane.add(checkBox1, CC.xywh(11, 17, 2, 1));

        //---- button2 ----
        button2.setText("Save");
        button2.setMaximumSize(new Dimension(28, 23));
        button2.setMinimumSize(new Dimension(28, 23));
        button2.setPreferredSize(new Dimension(28, 23));
        button2.setBackground(new Color(0, 153, 51));
        contentPane.add(button2, CC.xy(5, 21));

        //---- button3 ----
        button3.setText("Cancel");
        button3.setPreferredSize(new Dimension(28, 23));
        button3.setMinimumSize(new Dimension(28, 23));
        button3.setMaximumSize(new Dimension(28, 23));
        contentPane.add(button3, CC.xy(6, 21));

        //---- button4 ----
        button4.setText("Delete");
        button4.setPreferredSize(new Dimension(28, 23));
        button4.setBackground(new Color(255, 102, 102));
        contentPane.add(button4, CC.xy(13, 21));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton button1;
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
    private JTextField textField4;
    private JLabel label4;
    private JComboBox comboBox1;
    private JLabel label11;
    private JLabel label12;
    private JLabel label9;
    private JTextField textField5;
    private JLabel label5;
    private JScrollPane scrollPane2;
    private JList list2;
    private JLabel label10;
    private JScrollPane scrollPane3;
    private JList list3;
    private JLabel label6;
    private JTextField textField2;
    private JCheckBox checkBox1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
