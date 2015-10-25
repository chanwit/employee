/*
 * Created by JFormDesigner on Wed Oct 21 21:24:56 ICT 2015
 */

package com.chulabhornhospital.employee.form;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Worajedt Sitthidumrong
 */
public class EmployeeList extends JFrame {

    private static final String SEARCH_PLACE_HOLDER = "Search ...";
    private EmployeeNew employeeNew;

    public EmployeeList() {
        initComponents();
        tbEmployee.requestFocus();
    }

    private void btnNewActionPerformed(ActionEvent e) {
        employeeNew = new EmployeeNew();
        employeeNew.pack();
        employeeNew.setVisible(true);
    }

    private void txtSearchKeyPressed(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
            e.consume();
            doSearch(txtSearch.getText());
        }
    }

    private void doSearch(String searchQuery) {
        JOptionPane.showMessageDialog(this, searchQuery);
    }

    private void txtSearchFocusGained(FocusEvent e) {
        if(txtSearch.getText().equals(SEARCH_PLACE_HOLDER)) {
            txtSearch.setText("");
        }
    }

    private void txtSearchFocusLost(FocusEvent e) {
        if(txtSearch.getText().equals("")) {
            txtSearch.setText(SEARCH_PLACE_HOLDER);
        }
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
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                txtSearchKeyPressed(e);
            }
        });
        txtSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSearchFocusGained(e);
            }
            @Override
            public void focusLost(FocusEvent e) {
                txtSearchFocusLost(e);
            }
        });
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
        btnNew.addActionListener(e -> btnNewActionPerformed(e));
        contentPane.add(btnNew, CC.xywh(2, 11, 2, 1));
        pack();
        setLocationRelativeTo(null);
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
