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

public class SummaryReportPopularPlaces extends JPanel {

    private AnnualReportPopularPlaces tableModel;
    private JTextField jtfYear;
    private TableRowSorter<TableModel> sorter;
    private JButton submitButton = new JButton("Search");
    private JTable resultTable;
    private JTextField totalCount = new JTextField("");
    private JTextField totalPayment = new JTextField("");
    private JTextField topPlace = new JTextField();
    private DefaultComboBoxModel yearModel = new DefaultComboBoxModel();
    private JComboBox jcbDate = new JComboBox();

    public SummaryReportPopularPlaces() {
        try {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            for (int i = year; i < year + 5; i++) {
                yearModel.addElement(String.format("%04d", i - 5) + "");
            }
            for (int i = year; i <= year + 5; i++) {
                yearModel.addElement(String.format("%04d", i) + "");
            }
            jcbDate = new JComboBox(yearModel);
            totalCount.setEditable(false);
            totalPayment.setEditable(false);
            topPlace.setEditable(false);
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            tableModel = new AnnualReportPopularPlaces();
            jtfYear = new JTextField("");
            resultTable = new JTable(tableModel);
            int total = 0;
            double totalsales = 0;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                totalsales = total + Double.parseDouble(tableModel.getValueAt(i, 2) + "");
                total = total + Integer.parseInt(tableModel.getValueAt(i, 1) + "");
            }
            topPlace.setText(tableModel.getValueAt(0, 0) + "");
            totalCount.setText(total + "");
            totalPayment.setText(String.format("%.2f", totalsales) + "");
            // create Box to manage placement of queryArea and submitButton in GUI
            Box boxNorth = Box.createHorizontalBox();
            JLabel jlbtitle = new JLabel("Annual Report : Popular Places");
            jlbtitle.setFont(new Font("Arial", Font.BOLD, 20));
            boxNorth.add(jlbtitle);
            boxNorth.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 10));

            Box boxCenter = Box.createHorizontalBox();

            boxCenter.add(new JLabel("Year : "));
            jtfYear.setSize(30, 30);
            boxCenter.add(jcbDate);
            JLabel jlbformat = new JLabel("                                                                                                                                          ");
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
            Box boxCenter3 = Box.createHorizontalBox();
            boxCenter3.add(new JLabel("Most Popular Place : "));
            boxCenter3.add(topPlace);
            boxCenter3.add(new JLabel("                                                                                                                                                     "));
            boxCenter3.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
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
            boxCombined2.add(boxCenter3);
            boxCombined2.add(boxNorth2);
            boxCombined2.add(boxCenter2);
            add(boxCombined2, BorderLayout.SOUTH);
            submitButton.addActionListener(new SubmitButtonListener());
            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
            jcbDate.setSelectedItem("2016");
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
                tableModel.retrieveByDate(jcbDate.getSelectedItem() + "");
                jtfYear.setText("");
                System.out.println("***TRACE: in SubmitButtonListener");
                int total = 0;
                double totalsales = 0;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    totalsales = total + Double.parseDouble(tableModel.getValueAt(i, 2) + "");
                    total = total + Integer.parseInt(tableModel.getValueAt(i, 1) + "");
                }
                if (tableModel.getValueAt(0, 0).equals("")) {
                    JOptionPane.showMessageDialog(null, "No Record Found!!", "No Record", JOptionPane.ERROR_MESSAGE);
                    topPlace.setText("");

                } else {
                    topPlace.setText(tableModel.getValueAt(0, 0) + "");
                }

                totalCount.setText(total + "");
                totalPayment.setText(String.format("%.2f", totalsales) + "");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Transaction Report");
        frame.add(new SummaryReportPopularPlaces());
        frame.setSize(700, 520);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }
}
