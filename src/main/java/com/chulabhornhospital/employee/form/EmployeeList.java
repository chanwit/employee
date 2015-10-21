/*
 * Created by JFormDesigner on Wed Oct 21 21:24:56 ICT 2015
 */

package com.chulabhornhospital.employee.form;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Worajedt Sitthidumrong
 */
public class EmployeeList extends JFrame {
    public EmployeeList() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        txtSearch = new JTextField();
        scrollPane1 = new JScrollPane();
        tbEmployee = new JTable();
        btnNew = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(800, 600));
        setTitle("Employee Directory");
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "$ugap, 12*(default:grow), $ugap",
            "2*($lgap), default, $lgap, 16dlu, 3*($lgap, default)"));

        //---- label1 ----
        label1.setText("Employee Directory");
        label1.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(label1, CC.xywh(2, 3, 6, 1));

        //---- txtSearch ----
        txtSearch.setText("Search ...");
        contentPane.add(txtSearch, CC.xywh(10, 3, 4, 1));

        //======== scrollPane1 ========
        {

            //---- tbEmployee ----
            tbEmployee.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, false},
                    {null, null, null, null},
                },
                new String[] {
                    "Name", "Age", "Nick name", "Employ?"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, Integer.class, String.class, Boolean.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, true, true, true
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = tbEmployee.getColumnModel();
                cm.getColumn(0).setPreferredWidth(300);
                cm.getColumn(1).setMaxWidth(50);
                cm.getColumn(2).setPreferredWidth(150);
                cm.getColumn(3).setMaxWidth(50);
            }
            scrollPane1.setViewportView(tbEmployee);
        }
        contentPane.add(scrollPane1, CC.xywh(2, 7, 12, 1));

        //---- btnNew ----
        btnNew.setText("New Employee");
        contentPane.add(btnNew, CC.xywh(2, 11, 2, 1));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField txtSearch;
    private JScrollPane scrollPane1;
    private JTable tbEmployee;
    private JButton btnNew;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
