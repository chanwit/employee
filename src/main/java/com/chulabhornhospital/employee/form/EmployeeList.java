/*
 * Created by JFormDesigner on Wed Oct 21 21:24:56 ICT 2015
 */

package com.chulabhornhospital.employee.form;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.function.BooleanSupplier;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

import com.chulabhornhospital.employee.controller.EmployeeListFormController;
import com.chulabhornhospital.employee.domain.Employee;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.*;

/**
 * @author Worajedt Sitthidumrong
 */
public class EmployeeList extends JFrame {

    private static final String SEARCH_PLACE_HOLDER = "Search ...";
    private EmployeeListFormController controller;

    private ImageIcon check = new ImageIcon("src/main/resources/fa-check-circle_18_2_24ff00_none.png");
    private ImageIcon cross = new ImageIcon("src/main/resources/fa-times-circle_18_2_ff0000_none.png");

    public EmployeeList() {
        initComponents();
        controller = new EmployeeListFormController(this);
        refreshData();
        tbEmployee.removeColumn(tbEmployee.getColumnModel().getColumn(0));
        tbEmployee.requestFocus();
        System.out.println(tbEmployee.getDefaultRenderer(Boolean.class).getClass());

        tbEmployee.setDefaultRenderer(Boolean.class, new DefaultTableCellRenderer() {
            private JLabel label = new JLabel();
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                Rectangle cell = table.getCellRect(row, col, false);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setSize(cell.getSize());
                if(value.equals(Boolean.TRUE)) {
                    label.setIcon(check);
                } else {
                    label.setIcon(cross);
                }
                return label;
            }
        });
    }

    private void refreshData() {
        try {
            controller.listEmployees();
        } catch (Throwable e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void btnNewActionPerformed(ActionEvent e) {
        EmployeeNew newForm = new EmployeeNew();
        newForm.pack();
        newForm.setVisible(true);
        refreshData();
    }

    private void txtSearchKeyPressed(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
            e.consume();
            try {
                controller.search(txtSearch.getText());
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(this, throwable.getMessage());
            }
        }
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

    public void setEmployees(List<Employee> val) {
        List<Employee> old = this.employees;
        this.employees = val;
        firePropertyChange("employees", old, val);
    }

    public List<com.chulabhornhospital.employee.domain.Employee> getEmployees() {
        return employees;
    }

    private void tbEmployeeMousePressed(MouseEvent event) {
        JTable table =(JTable) event.getSource();
        Point p = event.getPoint();
        int row = table.rowAtPoint(p);
        if (event.getClickCount() == 2 && row >= 0) {
            Long id = (Long) tbEmployee.getModel().getValueAt(row, 0);
            EmployeeNew newForm = new EmployeeNew();
            try {
                newForm.setEmployee(controller.get(id));
                newForm.pack();
                newForm.setVisible(true);
                refreshData();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(this, throwable.getMessage());
            }
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
            tbEmployee.setModel(new DefaultTableModel());
            tbEmployee.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    tbEmployeeMousePressed(e);
                }
            });
            scrollPane1.setViewportView(tbEmployee);
        }
        contentPane.add(scrollPane1, CC.xywh(2, 7, 12, 1));

        //---- btnNew ----
        btnNew.setText("New Employee");
        btnNew.addActionListener(e -> btnNewActionPerformed(e));
        contentPane.add(btnNew, CC.xywh(2, 11, 2, 1));
        pack();
        setLocationRelativeTo(null);

        //---- bindings ----
        bindingGroup = new BindingGroup();
        {
            JTableBinding binding = SwingBindings.createJTableBinding(UpdateStrategy.READ,
                this, (BeanProperty) BeanProperty.create("employees"), tbEmployee);
            binding.setEditable(false);
            binding.addColumnBinding(BeanProperty.create("id"))
                .setColumnName("Id")
                .setColumnClass(Long.class)
                .setEditable(false);
            binding.addColumnBinding(ELProperty.create("${firstName} ${lastName}"))
                .setColumnName("Name")
                .setColumnClass(String.class)
                .setEditable(false);
            binding.addColumnBinding(BeanProperty.create("dob"))
                .setColumnName("Date of Birth")
                .setColumnClass(Date.class)
                .setEditable(false);
            binding.addColumnBinding(BeanProperty.create("nickName"))
                .setColumnName("Nick Name")
                .setColumnClass(String.class)
                .setEditable(false);
            binding.addColumnBinding(BeanProperty.create("beingHired"))
                .setColumnName("Being Hired")
                .setColumnClass(Boolean.class)
                .setEditable(false);
            bindingGroup.addBinding(binding);
        }
        bindingGroup.bind();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField txtSearch;
    private JScrollPane scrollPane1;
    private JTable tbEmployee;
    private JButton btnNew;
    private List<com.chulabhornhospital.employee.domain.Employee> employees;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
