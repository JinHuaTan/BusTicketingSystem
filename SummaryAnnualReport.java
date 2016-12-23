
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.Month;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shaun Lee
 */
public class SummaryAnnualReport extends JPanel{
      private AnnualSalesReportTableModel tableModel;
    private JTextField jtfYear;
    private TableRowSorter<TableModel> sorter;
    private JButton submitButton = new JButton("Search");
    private JTable resultTable;
    private JTextField totalCount = new JTextField("");
    private JTextField totalPayment = new JTextField("");
    private JTextField topMonth = new JTextField();
    private DefaultComboBoxModel yearModel = new DefaultComboBoxModel();
    private JComboBox jcbDate = new JComboBox();

    public SummaryAnnualReport() {
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
            topMonth.setEditable(false);
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            tableModel = new AnnualSalesReportTableModel();
            jtfYear = new JTextField("");
            resultTable = new JTable(tableModel);
            int total = 0;
            double totalsales = 0;
            int topSaleMonth = 0;
            double tempTopSale = 0;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tempTopSale < Double.parseDouble(tableModel.getValueAt(i, 2) + "")) {
                    topSaleMonth = i + 1;

                }
                totalsales = total + Double.parseDouble(tableModel.getValueAt(i, 2) + "");
                total = total + Integer.parseInt(tableModel.getValueAt(i, 1) + "");
            }
            // create Box to manage placement of queryArea and submitButton in GUI
            Box boxNorth = Box.createHorizontalBox();
            JLabel jlbtitle = new JLabel("Annual Sales Report");
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
            boxCenter3.add(new JLabel("Month With Highest Sale : "));
            boxCenter3.add(topMonth);
            boxCenter3.add(new JLabel("                                                                                                                                                     "));
            boxCenter3.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
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
            boxCombined2.add(boxCenter3);
            boxCombined2.add(boxNorth2);
            boxCombined2.add(boxCenter2);
            add(boxCombined2, BorderLayout.SOUTH);
            submitButton.addActionListener(new SubmitButtonListener());
            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
            resultTable.setVisible(false);
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
                System.out.println("***TRACE: in SubmitButtonListener");
                int total = 0;
                double totalsales = 0;
                int topSaleMonth = 0;
                double tempTopSale = 0;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    if (tempTopSale < Double.parseDouble(tableModel.getValueAt(i, 2) + "")) {
                        topSaleMonth = i + 1;
                        resultTable.setValueAt(Month.of(i + 1).name(), i, 0);
                        System.out.println("***TRACE: loop" + i);
                    }
                    totalsales = total + Double.parseDouble(tableModel.getValueAt(i, 2) + "");
                    total = total + Integer.parseInt(tableModel.getValueAt(i, 1) + "");
                }
                try {
                    topMonth.setText(Month.of(topSaleMonth).name());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No Record Found!!", "No Record", JOptionPane.ERROR_MESSAGE);
                }

                totalCount.setText(total + "");
                totalPayment.setText(String.format("%.2f", totalsales) + "");
                resultTable.setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new SummaryAnnualReport());
        frame.setSize(700, 520);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }
    
}
