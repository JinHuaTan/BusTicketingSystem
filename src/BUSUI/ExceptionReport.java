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
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class ExceptionReport extends JPanel {

    private TopPlacesTableModel tableModel;
    private JTextField jtfToDate;
    private JTextField jtfFromDate;
    private TableRowSorter<TableModel> sorter;
    private JButton submitButton = new JButton("Search");
    private JTable resultTable;
    private JTextField totalCount = new JTextField("");
    private JTextField totalPayment = new JTextField("");
    UtilDateModel model = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    Properties p = new Properties();
    Properties p2 = new Properties();
    JDatePanelImpl datePanel;
    JDatePanelImpl datePanel2;
    JDatePickerImpl datePicker;
    JDatePickerImpl datePicker2;

    public ExceptionReport() {
        try {
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
            p2.put("text.today", "Today");
            p2.put("text.month", "Month");
            p2.put("text.year", "Year");
            datePanel = new JDatePanelImpl(model, p);
            datePanel2 = new JDatePanelImpl(model2, p2);
            datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
            datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
            totalCount.setEditable(false);
            totalPayment.setEditable(false);
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            tableModel = new TopPlacesTableModel();
            jtfFromDate = new JTextField("");
            jtfToDate = new JTextField("");
            resultTable = new JTable(tableModel);
            int total = 0;
            double totalsales = 0;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                totalsales = total + Double.parseDouble(tableModel.getValueAt(i, 2) + "");
                total = total + Integer.parseInt(tableModel.getValueAt(i, 1) + "");
            }
            totalCount.setText(total + "");
            totalPayment.setText(String.format("%.2f", totalsales) + "");
            // create Box to manage placement of queryArea and submitButton in GUI
            Box boxNorth = Box.createHorizontalBox();
            JLabel jlbtitle = new JLabel("Places Ticket Sold Count between Dates");
            jlbtitle.setFont(new Font("Arial", Font.BOLD, 20));
            boxNorth.add(jlbtitle);
            boxNorth.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 10));

            Box boxCenter = Box.createHorizontalBox();
            jtfFromDate.setSize(30, 30);
            boxCenter.add(new JLabel("From : "));
            boxCenter.add(datePicker);
            boxCenter.add(new JLabel("To : "));
            jtfToDate.setSize(30, 30);
            boxCenter.add(datePicker2);
            JLabel jlbformat = new JLabel("                                              ");
            jlbformat.setForeground(Color.red);
            boxCenter.add(jlbformat);
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
            boxNorth2.add(new JLabel("Total Ticket Sold : "));
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
                if(((Date) datePicker.getModel().getValue()).after((Date) datePicker2.getModel().getValue())){
                     JOptionPane.showMessageDialog(null,"From Date must be before To Date" , "Invalid Date", JOptionPane.ERROR_MESSAGE);
                }
                else{
                tableModel.retrieveByDate(datePicker.getJFormattedTextField().getText(), datePicker2.getJFormattedTextField().getText());
                jtfFromDate.setText("");
                jtfToDate.setText("");
                System.out.println("***TRACE: in SubmitButtonListener");
                int total = 0;
                double totalsales = 0;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    totalsales = total + Double.parseDouble(tableModel.getValueAt(i, 2) + "");
                    total = total + Integer.parseInt(tableModel.getValueAt(i, 1) + "");
                }
                if (tableModel.getValueAt(0, 0).equals("")) {
                    JOptionPane.showMessageDialog(null, "No Record Found!!", "No Record", JOptionPane.ERROR_MESSAGE);
                }
                totalCount.setText(total + "");
                totalPayment.setText(String.format("%.2f", totalsales) + "");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Transaction Report");
        frame.add(new ExceptionReport());
        frame.setSize(700, 520);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }
}
