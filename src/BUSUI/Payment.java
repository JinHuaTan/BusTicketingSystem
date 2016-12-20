package BUSUI;

import BUSDOMAIN.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import BUSCONTROL.*;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Payment extends JFrame {

    //controls
    MaintainTransControl transControl = new MaintainTransControl();
    MaintainPaymenttypeControl ptControl = new MaintainPaymenttypeControl();
    MaintainPaymenttypeControl paymentControl = new MaintainPaymenttypeControl();
    MaintainTicketControl ticketControl = new MaintainTicketControl();
    private JPanel rightPanel = new JPanel(new BorderLayout());
    private JPanel leftPanel = new JPanel(new BorderLayout());
    private JPanel header = new JPanel(new FlowLayout());
    private JLabel transID = new JLabel();
    private JLabel jlbHeader = new JLabel("Transaction ID : #");
    private String transIDString = "";
    private JPanel body = new JPanel(new GridLayout(10, 2));
    private JLabel jlbStaffID = new JLabel("Staff ID :");
    private JTextField jtfStaffID = new JTextField();
    private JLabel jlbCustomerName = new JLabel("Customer's Name :");
    private JTextField jtfCustomerName = new JTextField();
    private JLabel jlbContactNum = new JLabel("Contact Number");
    private JTextField jtfContactNum = new JTextField();
    private JLabel jlbPaymentType = new JLabel("Payment Type");
    private Object[] paymentType = new Object[]{"Cash", "Credit Card"};
    private JComboBox jcbPaymentType = new JComboBox(paymentType);
    private JLabel jlbCreditCardNo = new JLabel("Credit Card No :");
    private JTextField jtfCreditCardNo = new JTextField();
    private JLabel jlbPaymentBank = new JLabel("Bank Selection :");
    private Object[] BankSelection = new Object[]{"-", "MayBank", "CIMB", "Public Bank Berhad", "RHB Bank", "Hong Leong Bank", "AMMB Holdings", "United Overseas Bank (Malaysia)", "Bank Rakyat", "OCBC Bank (Malaysia)", "HSBC Bank Malaysia"};
    private JComboBox jcbBankSelection = new JComboBox(BankSelection);
    private JLabel jlbIsDiscount = new JLabel("Discount ?");
    private JPanel isDiscount = new JPanel(new FlowLayout());
    private JRadioButton jrbIsDiscount = new JRadioButton("Yes");
    private JRadioButton jrbIsNotDisount = new JRadioButton("No");
    private ButtonGroup gp = new ButtonGroup();
    private JLabel jlbTypeOfDiscount = new JLabel("Type Of Discount :");
    private JTextField jtfTypeOfDiscount = new JTextField();
    private JLabel jlbAmountDiscount = new JLabel("Discount Amount :");
    private JTextField jtfAmountDiscount = new JTextField();
    private JPanel botPanel = new JPanel(new FlowLayout());
    private JButton jbtProceed = new JButton("Proceed");
    private JLabel jlbEmpty = new JLabel();
    private JButton jbtBack = new JButton("Back to Selection");
    private JPanel title = new JPanel(new GridLayout(1, 4));
    private JLabel jlbName = new JLabel("Name");
    private JLabel jlbQty = new JLabel("Quantity");
    private JLabel jlbEach = new JLabel("Each");
    private JLabel jlbTotal = new JLabel("Total");
    private JPanel qtyPanel = new JPanel(new GridLayout(1, 2));
    private JPanel totalPanel = new JPanel(new GridLayout(3, 2));
    private JPanel flowLayoutDiscount = new JPanel(new FlowLayout());
    private JPanel flowLayoutSubTotal = new JPanel(new FlowLayout());
    private JPanel flowLayoutTax = new JPanel(new FlowLayout());
    private JPanel flowLayoutTotal = new JPanel(new FlowLayout());
    private JPanel flowLayoutBalanceDue = new JPanel(new FlowLayout());
    private JPanel flowLayoutChanges = new JPanel(new FlowLayout());
    private JLabel jlbTotalDiscount = new JLabel("Discount:");
    private JLabel jlbSubTotal = new JLabel("Sub Total :");
    private JLabel jlbGST = new JLabel("GST (6%) :");
    private JLabel jlbGrandTotal = new JLabel("Grand Total :");
    private JLabel jlbBalanceDue = new JLabel("Balance Due :");
    private JLabel jlbChange = new JLabel("Change :");
    private JLabel jlbTotalDiscountI = new JLabel("");
    private JLabel jlbSubTotalI = new JLabel("");
    private JLabel jlbGSTI = new JLabel("");
    private JLabel jlbGrandTotalI = new JLabel("");
    private JLabel jlbBalanceDueI = new JLabel("");
    private JLabel jlbChangeI = new JLabel("");
    private JPanel tablePanel = new JPanel();
    private String[] columnNames = {"No.",
        "TicketID/Seat No.",
        "From/To",
        "Departure Date/Time",
        "Price (RM)"};
    Object[][] data;
    private Staff currentStaff;
    private Counter currentCounter;
    private Ticket[] purchasedTicketlist;
    private Ticket ticket;
    private double totalDiscount = 0;
    private double gst = 0;
    private double subTotal = 0;
    private double grandTotal = 0;
    private double balanceDue = 0;
    private double change = 0;
    private Trans transUpdate;

    //data test
    ArrayList<Ticket> purchasedTicketArraylist;

    public Payment(Staff cs, Counter counter, ArrayList<Ticket> t) {
        currentStaff = cs;
        currentCounter = counter;
        int count = 1;
        purchasedTicketlist = t.toArray(new Ticket[t.size()]);
        data = new Object[purchasedTicketlist.length][5];
        for (int i = 0; i < purchasedTicketlist.length; i++) {
            ticket = null;
            ticket = purchasedTicketlist[i];
            data[i][0] = count + ".";
            data[i][1] = ticket.getTicketid() + "-" + ticket.getSeatid().getSeatnumber();
            data[i][2] = ticket.getTripid().getRouteid().getSourceid().getDestl() + "-" + ticket.getTripid().getRouteid().getDestid().getDestl();
            data[i][3] = ticket.getTripid().getDepartdate();
            data[i][4] = ticket.getTripid().getFareperticket() + "";
            subTotal = subTotal + ticket.getTripid().getFareperticket();
            count++;

        }
        gst = subTotal * 0.06;
        jlbGSTI.setText(String.format("%.2f", gst) + "");
        jlbSubTotalI.setText(String.format("%.2f", subTotal) + "");
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(490, 390));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        setLayout(new BorderLayout());
        transID.setText(transControl.getLastTransID());
        jlbHeader.setSize(100, 100);
        header.add(jlbHeader);
        header.add(transID);
        rightPanel.add(header, BorderLayout.NORTH);
        body.add(jlbStaffID);
        jtfStaffID.setEditable(false);
        jtfStaffID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jtfStaffID.setText(cs.getStaffid() + "- " + counter.getDestid().getDestl());
        body.add(jtfStaffID);
        body.add(jlbCustomerName);
        body.add(jtfCustomerName);
        body.add(jlbContactNum);
        body.add(jtfContactNum);
        body.add(jlbPaymentType);
        body.add(jcbPaymentType);
        body.add(jlbCreditCardNo);
        body.add(jtfCreditCardNo);
        jtfCreditCardNo.setEditable(false);
        body.add(jlbPaymentBank);
        body.add(jcbBankSelection);
        jcbBankSelection.setEnabled(false);
        body.add(jlbIsDiscount);
        isDiscount.add(jrbIsDiscount);
        isDiscount.add(jrbIsNotDisount);
        gp.add(jrbIsDiscount);
        gp.add(jrbIsNotDisount);
        jrbIsNotDisount.setSelected(true);
        body.add(isDiscount);
        body.add(jlbTypeOfDiscount);
        body.add(jtfTypeOfDiscount);
        jtfTypeOfDiscount.setEditable(false);
        body.add(jlbAmountDiscount);
        body.add(jtfAmountDiscount);
        jtfAmountDiscount.setEditable(false);
        jrbIsNotDisount.setSelected(true);
        jtfAmountDiscount.setText("0");
        //actionListener
        jrbIsDiscount.addActionListener(new IsDiscountListener());
        jrbIsNotDisount.addActionListener(new IsNotDiscountListener());
        jcbPaymentType.addItemListener(new PaymentTypeListener());
        jbtProceed.addActionListener(new ProceedListener());
        jbtBack.addActionListener(new BackListener());
        jtfAmountDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAmountDiscountKeyTyped(evt);
            }
        });
        rightPanel.add(body, BorderLayout.CENTER);
        botPanel.add(jbtProceed);
        botPanel.add(jbtBack);
        rightPanel.add(botPanel, BorderLayout.SOUTH);
        leftPanel.add(tablePanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.CENTER);
        totalPanel.add(flowLayoutDiscount);
        flowLayoutDiscount.add(jlbTotalDiscount);
        flowLayoutDiscount.add(jlbTotalDiscountI);
        totalPanel.add(flowLayoutTax);
        flowLayoutTax.add(jlbGST);
        flowLayoutTax.add(jlbGSTI);
        totalPanel.add(flowLayoutSubTotal);
        flowLayoutSubTotal.add(jlbSubTotal);
        flowLayoutSubTotal.add(jlbSubTotalI);
        totalPanel.add(flowLayoutTotal);
        flowLayoutTotal.add(jlbGrandTotal);
        jlbGrandTotal.setFont(new Font("Arial", Font.BOLD, 20));
        flowLayoutTotal.add(jlbGrandTotalI);
        jlbGrandTotalI.setFont(new Font("Arial", Font.BOLD, 20));
        totalPanel.add(flowLayoutChanges);
        flowLayoutChanges.add(jlbChange);
        jlbChange.setFont(new Font("Arial", Font.BOLD, 20));
        flowLayoutChanges.add(jlbChangeI);
        jlbChangeI.setFont(new Font("Arial", Font.BOLD, 20));
        totalPanel.add(flowLayoutBalanceDue);
        flowLayoutBalanceDue.add(jlbBalanceDue);
        jlbBalanceDue.setForeground(Color.red);
        jlbBalanceDue.setFont(new Font("Arial", Font.BOLD, 20));
        flowLayoutBalanceDue.add(jlbBalanceDueI);
        jlbBalanceDueI.setFont(new Font("Arial", Font.BOLD, 20));
        jlbBalanceDueI.setForeground(Color.red);
        leftPanel.add(totalPanel, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);
        setTitle("GOTO Malaysia Payment");
        setSize(1000, 520);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    public class BackListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public class IsDiscountListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (jrbIsDiscount.isSelected()) {
                jtfAmountDiscount.setEditable(true);
                jtfTypeOfDiscount.setEditable(true);
            }
        }
    }

    public class IsNotDiscountListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (jrbIsNotDisount.isSelected()) {
                jtfAmountDiscount.setText("");
                jtfAmountDiscount.setEditable(false);
                jtfTypeOfDiscount.setText("");
                jtfTypeOfDiscount.setEditable(false);
                jtfAmountDiscount.setText("0");
            }
        }
    }

    public class PaymentTypeListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            if (e.getItem() == paymentType[1]) {
                jtfCreditCardNo.setEditable(true);
                jcbBankSelection.setEnabled(true);
            } else {
                jtfCreditCardNo.setText("");
                jtfCreditCardNo.setEditable(false);
                jcbBankSelection.setEnabled(false);
                jcbBankSelection.setSelectedIndex(0);
            }
        }
    }

    private void jtfAmountDiscountKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:char c = evt.getKeyChar();
        char c = evt.getKeyChar();

        if (Character.isDigit(c) || c == '.' && jtfAmountDiscount.getText().length() < 14) {
            // OK

        } else {
            // Ignore this character
            evt.consume();
        }
    }

    public class ProceedListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            double amountPaid = 0;
            boolean exception = true;

            if (jrbIsDiscount.isSelected()) {
                totalDiscount = Double.parseDouble(jtfAmountDiscount.getText());
            }
            jlbTotalDiscountI.setText(String.format("%.2f", totalDiscount) + "");
            grandTotal = subTotal - totalDiscount - gst;
            jlbGrandTotalI.setText(String.format("%.2f", grandTotal) + "");
            balanceDue = grandTotal;
            jlbBalanceDueI.setText(String.format("%.2f", balanceDue) + "");
            double balanceDue2 = 0;
            do {
                try {
                    do {
                        if (JOptionPane.showConfirmDialog(null, "Proceed to payment?", "Payment", JOptionPane.WARNING_MESSAGE) == 0) {
                            amountPaid = Double.parseDouble(JOptionPane.showInputDialog(null, "Amount Paid :", "Payment", JOptionPane.INFORMATION_MESSAGE));
                            balanceDue2 = balanceDue - amountPaid;
                            if (balanceDue2 <= 0) {
                                jlbBalanceDueI.setText("0.00");
                                change = amountPaid - balanceDue;
                                jlbChangeI.setText(String.format("%.2f", change) + "");
                                balanceDue = 0;
                            } else {
                                balanceDue = balanceDue2;
                                JOptionPane.showMessageDialog(null, "Insufficient Amount", "Payment", JOptionPane.ERROR_MESSAGE);
                            }
                            exception = false;
                        }

                    } while (balanceDue2 > 0);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter Only Integer!");
                    exception = true;
                }
            } while (exception == true);
            newTrans();
            ((Window) getRootPane().getParent()).dispose();
        }
    }

    public static void main(String[] args) {
    }

    public void newTrans() {
        JFrame receiptFrame = new JFrame();
        JTextArea jtaReceipt = new JTextArea("");
        JTextArea jtaTicket = new JTextArea("");
        jtaReceipt.setEditable(false);
        jtaTicket.setEditable(false);
        Paymenttype pymtid = paymentControl.selectRecordbyPayment("" + jcbBankSelection.getSelectedItem());
        try {
            pymtid.getPymtid();
        } catch (NullPointerException ex) {
            pymtid = paymentControl.selectRecordbyPayment("Cash");
        }
        transUpdate = new Trans(transID.getText(), null, currentStaff, currentCounter, "PAID", pymtid,
                jtfCustomerName.getText(), jtfContactNum.getText(),
                jtfCreditCardNo.getText(), jtfTypeOfDiscount.getText(), Double.parseDouble(jtfAmountDiscount.getText()), grandTotal, new Timestamp(new Date().getTime()));
        transControl.addRecord(transUpdate);
        for (int i = 0; i < purchasedTicketlist.length; i++) {
            ticket = null;
            ticket = purchasedTicketlist[i];
            ticket.setTransid(transUpdate);
            ticket.setAvailability(1);
            ticketControl.updateRecord(ticket);
            PrintWriter writer2 = null;
            try {
                //create a temporary file
                String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                writer2 = new PrintWriter("src\\Ticket\\" + ticket.getTicketid() + "-" + timeLog + ".txt", "UTF-8");
                writer2.printf("GotoMalaysia Official Ticket\n");
                writer2.printf("==========================================================================================\n");
                writer2.printf("+   #Ticket ID : " + ticket.getTicketid() + "                                                                  +\n");
                writer2.printf("==========================================================================================\n");
                writer2.printf("+ From/To     : " + ticket.getTripid().getRouteid().getSourceid().getDestl() + "-" + ticket.getTripid().getRouteid().getDestid().getDestl() + "                                                     +\n");
                writer2.printf("+ Date/Time   : " + ticket.getTripid().getDepartdate() + "                                                      +\n");
                writer2.printf("+ Bus Number  : " + ticket.getTripid().getBusid().getCarplate() + "                                                                 +\n");
                writer2.printf("+ Seat Number : " + ticket.getSeatid().getSeatnumber() + "                                                                      +\n");
                writer2.printf("+                                                                                        +\n");
                writer2.printf("+ Company Chop :                     Handling Staff:" + transUpdate.getStaffid().getStaffid() + " - " + transUpdate.getStaffid().getStaffname() + "                  +\n");
                writer2.printf("==========================================================================================");
                jtaTicket.append("GotoMalaysia Official Ticket\n");
                jtaTicket.append("==========================================================================================\n");
                jtaTicket.append("+   #Ticket ID : " + ticket.getTicketid() + "                                                                                                                                                                       +\n");
                jtaTicket.append("==========================================================================================\n");
                jtaTicket.append("+ From/To     : " + ticket.getTripid().getRouteid().getSourceid().getDestl() + "-" + ticket.getTripid().getRouteid().getDestid().getDestl() + "\n");
                jtaTicket.append("+ Date/Time   : " + ticket.getTripid().getDepartdate() + "\n");
                jtaTicket.append("+ Bus Number  : " + ticket.getTripid().getBusid().getCarplate() + "\n");
                jtaTicket.append("+ Seat Number : " + ticket.getSeatid().getSeatnumber() + "\n");
                jtaTicket.append("+ \n");
                jtaTicket.append("+ Company Chop :                     Handling Staff:" + transUpdate.getStaffid().getStaffid() + " - " + transUpdate.getStaffid().getStaffname() + "\n");
                jtaTicket.append("==========================================================================================\n\n\n\n");
                writer2.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ticket Generator Fail" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        PrintWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            writer = new PrintWriter("src\\Receipt\\" + transID.getText() + "-" + timeLog + ".txt", "UTF-8");
            writer.printf("GotoMalaysia Official Receipt\n#" + transID.getText() + "\n===========\n\n");
            writer.printf("%-3s %-18s %-35s %-30s %-12s \n", "No.", "TicketID/SeatNo", "From/To", "Departure Date/Time", "Price(RM)");
            jtaReceipt.append("GotoMalaysia Official Receipt\n#" + transID.getText() + "\n===========\n\n");
            jtaReceipt.append(String.format("%-3s", "No.") + String.format("%-18s", "TicketID/SeatNo") + String.format("%-35s", "From/To") + String.format("%-30s", "Departure Date/Time") + String.format("%-12s", "Price(RM)") + "\n");
            for (int i = 0; i < purchasedTicketlist.length; i++) {
                writer.printf("%-3s %-18s %-35s %-30s %-12s \n", data[i][0] + "", data[i][1] + "", data[i][2] + "", data[i][3] + "", data[i][4]);
                jtaReceipt.append(String.format("%-3s", data[i][0] + "") + String.format("%-18s", data[i][1] + "") + String.format("%-35s", data[i][2] + "") + String.format("%-30s", data[i][3] + "") + String.format("%-12s", data[i][4]) + "\n");
            }
            writer.printf("\nSub Total : RM " + String.format("%.2f", subTotal));
            writer.printf("\nDiscount : RM " + String.format("%.2f", totalDiscount) + "(" + jtfTypeOfDiscount.getText() + ")");
            writer.printf("\nGst : RM " + String.format("%.2f", gst));
            writer.printf("\nGrand Total : RM " + String.format("%.2f", grandTotal));
            writer.printf("\nChange : RM " + String.format("%.2f", change));
            jtaReceipt.append("\nSub Total : RM " + String.format("%.2f", subTotal));
            jtaReceipt.append("\nDiscount : RM " + String.format("%.2f", totalDiscount) + "(" + jtfTypeOfDiscount.getText() + ")");
            jtaReceipt.append("\nGst : RM " + String.format("%.2f", gst));
            jtaReceipt.append("\nGrand Total : RM " + String.format("%.2f", grandTotal));
            jtaReceipt.append("\nChange : RM " + String.format("%.2f", change));
            writer.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, "Payment Success =D");
        receiptFrame.setTitle("Receipt and Ticket");
        receiptFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        receiptFrame.setVisible(true);
        receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        receiptFrame.setLocationRelativeTo(null);
        receiptFrame.setResizable(false);
        receiptFrame.setLayout(new GridLayout(1, 2));
        JScrollPane scrollPane1 = new JScrollPane(jtaTicket);
        JScrollPane scrollPane2 = new JScrollPane(jtaReceipt);
        receiptFrame.add(scrollPane2);
        receiptFrame.add(scrollPane1);
    }
}
