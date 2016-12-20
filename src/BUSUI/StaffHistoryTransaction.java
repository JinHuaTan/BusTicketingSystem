/*
 Author Soo Xingliang
 */
package BUSUI;

import BUSDA.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import BUSDA.*;
import BUSDOMAIN.*;
import BUSCONTROL.*;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StaffHistoryTransaction extends JPanel {

    private TransactionTableModel tableModel;
    private JTextField queryField;
    private TableRowSorter<TableModel> sorter;
    private JButton submitButton = new JButton("Search");
    private JTable resultTable;
    private JComboBox jcbo;
    private JTextField totalCount = new JTextField("");
    private JTextField totalPayment = new JTextField("");

    public StaffHistoryTransaction() {
        try {
            totalCount.setEditable(false);
            totalPayment.setEditable(false);
            jcbo = new JComboBox(new Object[]{"Staff ID", "Transaction ID"});

            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            tableModel = new TransactionTableModel();
            queryField = new JTextField("");

            resultTable = new JTable(tableModel);
            double total = 0;
            for (int i = 0; i < tableModel.getRowCount(); i++) {

                total = total + Double.parseDouble(tableModel.getValueAt(i, 3) + "");
            }
            totalCount.setText(tableModel.getRowCount() + "");
            totalPayment.setText(String.format("%.2f", total) + "");
            // create Box to manage placement of queryArea and submitButton in GUI
            Box boxNorth = Box.createHorizontalBox();

            boxNorth.add(new JLabel("Search Criteria:  "));
            boxNorth.add(jcbo);
            boxNorth.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 10));

            Box boxCenter = Box.createHorizontalBox();
            boxCenter.add(queryField);
            boxCenter.add(submitButton);
            boxCenter.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            Box boxCombined = Box.createVerticalBox();
            boxCombined.add(boxNorth);
            boxCombined.add(boxCenter);
            add(boxCombined, BorderLayout.NORTH);
            JScrollPane scrollResult = new JScrollPane(resultTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            add(scrollResult, BorderLayout.CENTER);
            Box boxNorth2 = Box.createHorizontalBox();
            boxNorth2.add(new JLabel("Total Transaction : "));
            boxNorth2.add(totalCount);
            boxNorth2.add(new JLabel("                                                                                                                                                                        "));
            boxNorth2.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 10));
            Box boxCenter2 = Box.createHorizontalBox();
            boxCenter2.add(new JLabel("Total Sales : RM"));
            boxCenter2.add(totalPayment);
            boxCenter2.add(new JLabel("                                                                                                                                                     "));
            boxCenter2.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            Box boxCombined2 = Box.createVerticalBox();
            boxCombined2.add(boxNorth2);
            boxCombined2.add(boxCenter2);
            add(boxCombined2, BorderLayout.SOUTH);
            submitButton.addActionListener(new SubmitButtonListener());
            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);

            setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            //tableModel.disconnectFromDatabase();
            System.exit(1);
        }
    }

    private class SubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                if (jcbo.getSelectedItem().toString().equals("Transaction ID")) {
                    tableModel.retrieveByTransID(queryField.getText());
                    queryField.setText("");
                } else if (jcbo.getSelectedItem().toString().equals("Staff ID")) {
                    tableModel.retrieveByStaffID(queryField.getText());
                    queryField.setText("");
                }
                double total = 0;
                for (int i = 0; i < tableModel.getRowCount(); i++) {

                    total = total + Double.parseDouble(tableModel.getValueAt(i, 3) + "");
                }
                totalCount.setText(tableModel.getRowCount() + "");
                totalPayment.setText(String.format("%.2f", total) + "");
                System.out.println("***TRACE: in SubmitButtonListener");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Staff Transaction History");
        frame.add(new StaffHistoryTransaction());
        frame.setSize(700, 520);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }
}
