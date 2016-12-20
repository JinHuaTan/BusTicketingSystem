/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSCONTROL.MaintainCounterControl;
import BUSCONTROL.MaintainDslocationControl;
import BUSCONTROL.MaintainStaffControl;
import BUSDOMAIN.Counter;
import BUSDOMAIN.Dslocation;
import BUSDOMAIN.Staff;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CRUDCounter extends JFrame {

    private JPanel jpContentHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));//header
    private JPanel jpContentCenter = new JPanel(new BorderLayout(30, 30));//content
    private JPanel jpLeft;//form
    private JPanel jpRight;//form
    private JPanel jpTable;
    private JPanel jpContent;

    private ArrayList<Counter> countersinPanel;
    private MaintainCounterControl mcc;
    private MaintainDslocationControl mdc;
    private MaintainStaffControl msc;
    private String fdridate = "";
    private JButton jbtLeft = new JButton("<");
    private JButton jbtRight = new JButton(">");
    private JComboBox[] comboBox = new JComboBox[3];
    private JButton[] jbtExtra = new JButton[5];
    private JTextField jtfContact = new JTextField();
    private JTextArea taAddress = new JTextArea();
    private DefaultComboBoxModel counterModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel svModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel destModel = new DefaultComboBoxModel();
    private Image imgBg;

    public CRUDCounter() {

        mcc = new MaintainCounterControl();
        mdc = new MaintainDslocationControl();
        msc = new MaintainStaffControl();
        countersinPanel = mcc.getAllRecord();

        design();
        crudField();


        jpContent = new JPanel(new BorderLayout());
        jpContent.setBackground(new Color(254,196,61));
        jpContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jpContent.add(jpContentHeader, BorderLayout.NORTH);
        jpContent.add(jpContentCenter, BorderLayout.CENTER);
        add(jpContent);

        setTitle("GoToMalaysia - CRUD of Counter");
        setSize(new Dimension(1000,500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void design() {
        jpContentHeader.setPreferredSize(new Dimension(getWidth(), 50));
        ImageIcon icon = createImageIcon("../images/GreyIcon/counter.png", 30, 30);
        JButton jlHeader = new JButton(" Manage Counter", icon);
        jlHeader.setBackground(new Color(0, 0, 0, 0));
        jlHeader.setOpaque(false);
        jlHeader.setBorder(null);
        jlHeader.setAlignmentX(LEFT_ALIGNMENT);
        jlHeader.setFont(new Font("Arial", Font.BOLD, 32));
        jlHeader.setForeground(new Color(117, 117, 117));
        jpContentHeader.add(jlHeader);

        jpContentHeader.setBackground(new Color(0, 0, 0, 0));
        jpContentHeader.setOpaque(false);
        jpContentHeader.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        jpContentCenter.setBackground(new Color(0, 0, 0, 0));
        jpContentCenter.setOpaque(false);
        jpContentCenter.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        jpLeft = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(50, 50);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
                graphics.setColor(Color.WHITE);
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border}
            }
        };
        jpLeft.setOpaque(false);
        jpLeft.setBackground(new Color(0, 0, 0, 0));
        jpLeft.setBorder(BorderFactory.createEmptyBorder(10, 20, 25, 20));

        JPanel jpHeaNorth = new JPanel();
        jpHeaNorth.setBackground(new Color(0, 0, 0, 0));
        jpHeaNorth.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        jpHeaNorth.setLayout(new BoxLayout(jpHeaNorth, BoxLayout.X_AXIS));
        DefaultComboBoxModel chooseModel = new DefaultComboBoxModel();
        ArrayList<String> columnName = mcc.getAllColumnName();
        for (String l : columnName) {
            chooseModel.addElement(l);
        }
        JComboBox comboBox = new JComboBox(chooseModel);
        comboBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        jpHeaNorth.add(comboBox);
        JTextField jtfSearch = new JTextField();
        jtfSearch.setUI(new PlaceholderUI("Press Enter To Search", true));
        jtfSearch.setAlignmentY(Component.CENTER_ALIGNMENT);
        jpHeaNorth.add(jtfSearch);
        jtfSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countersinPanel = mcc.searchRecordByColumn((String) comboBox.getSelectedItem(), jtfSearch.getText());
                CreateButtonsInPanel(countersinPanel);
            }
        });
        ImageIcon imgClearT = createImageIcon("../images/crud/refresh.png", 18, 18);
        JButton jbtClear = new JButton(imgClearT);
        jbtClear.setBackground(Color.BLUE);
        jbtClear.setForeground(Color.WHITE);
        jpHeaNorth.add(jbtClear);
        jbtClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mcc = new MaintainCounterControl();
                countersinPanel = mcc.getAllRecord();
                CreateButtonsInPanel(countersinPanel);
                jtfSearch.setText("");
            }
        });

        jpTable = new JPanel();
        jpTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jpTable.setBackground(Color.WHITE);
        CreateButtonsInPanel(countersinPanel);
        JScrollPane jsPane = new JScrollPane(jpTable);
        jsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jpLeft.add(jpHeaNorth, BorderLayout.NORTH);
        jpLeft.add(jsPane, BorderLayout.CENTER);

        jpRight = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(50, 50);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
                graphics.setColor(Color.WHITE);
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border}
            }
        };
        jpRight.setOpaque(false);
        jpRight.setBackground(new Color(0, 0, 0, 0));
        jpRight.setBorder(BorderFactory.createEmptyBorder(30, 20, 25, 20));
        jpRight.setPreferredSize(new Dimension(450, getHeight()));
        jpContentCenter.add(jpLeft, BorderLayout.CENTER);
        jpContentCenter.add(jpRight, BorderLayout.EAST);
    }

    public void crudField() {
        JLabel[] jlSide = new JLabel[5];
        JPanel jpInfo = new JPanel(new SpringLayout());
        jpInfo.setBackground(new Color(0, 0, 0, 0));
        jpInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel jpButtons = new JPanel(new GridLayout(2, 3, 5, 5));
        jpButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        jpButtons.setBackground(new Color(0, 0, 0, 0));
        jpButtons.setPreferredSize(new Dimension(getWidth(), 80));

        JButton jbtAdd = new JButton("Add/ Update");
        ImageIcon imgRetrieve = createImageIcon("../images/crud/search.png", 18, 18);
        JButton jbtRetrieve = new JButton(imgRetrieve);
        ImageIcon imgDelete = createImageIcon("../images/crud/delete.png", 18, 18);
        JButton jbtDelete = new JButton(imgDelete);
        ImageIcon imgRefresh = createImageIcon("../images/crud/refresh.png", 18, 18);
        JButton jbtClear = new JButton(imgRefresh);

        for (int i = 0; i < mcc.getAllRecord().size(); i++) {
            counterModel.addElement(mcc.getAllRecord().get(i).getCounterid());
        }

        for (int i = 0; i < msc.getAllRecord().size(); i++) {
            svModel.addElement(msc.getAllRecord().get(i).getStaffid());
        }

        for (int i = 0; i < mdc.getAllRecord().size(); i++) {
            destModel.addElement(mdc.getAllRecord().get(i).getDestid());
        }
        taAddress.setColumns(10);
        taAddress.setLineWrap(true);
        taAddress.setRows(3);
        taAddress.setWrapStyleWord(true);
        JScrollPane jsTA = new JScrollPane(taAddress);
        jsTA.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jtfContact.setFont(new Font("Arial", Font.PLAIN, 15));
        jbtLeft.setBackground(new Color(231, 76, 60));
        jbtLeft.setForeground(Color.WHITE);
        jbtRight.setBackground(new Color(192, 57, 43));
        jbtRight.setForeground(Color.WHITE);
        jbtRetrieve.setBackground(new Color(241, 196, 15));
        jbtRetrieve.setForeground(Color.WHITE);
        jbtAdd.setBackground(new Color(230, 126, 34));
        jbtAdd.setForeground(Color.WHITE);
        jbtDelete.setBackground(new Color(243, 156, 18));
        jbtDelete.setForeground(Color.WHITE);
        jbtClear.setBackground(new Color(211, 84, 0));
        jbtClear.setForeground(Color.WHITE);

        jlSide[0] = new JLabel("CounterID", JLabel.TRAILING);
        jpInfo.add(jlSide[0]);
        JPanel jp = new JPanel(new BorderLayout());
        jlSide[0].setLabelFor(jp);
        comboBox[0] = new JComboBox(counterModel);
        jp.add(comboBox[0], BorderLayout.CENTER);
        jbtExtra[0] = new JButton(" Add ");
        jp.add(jbtExtra[0], BorderLayout.EAST);
        jpInfo.add(jp);
        jbtExtra[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newCounterID = JOptionPane.showInputDialog("Enter enter new CounterID that starts with C and follows by 5 digits:\n (The ID will be deleted if this counter is not added to database)");
                if (newCounterID != null) {
                    Pattern p = Pattern.compile("^[cC][0-9]{5}$");
                    Matcher m = p.matcher(newCounterID);
                    while (!m.find()) {
                        newCounterID = "";
                        String nCounterID;
                        nCounterID = JOptionPane.showInputDialog("Please enter Counter ID that starts with C and follows by 5 digits.");
                        if (nCounterID == null) {
                            break;
                        } else {
                            newCounterID = nCounterID;
                            m = p.matcher(newCounterID);
                        }
                    }
                    if (!newCounterID.equals("")) {
                        counterModel.addElement(newCounterID.toUpperCase());
                        comboBox[0].setSelectedItem(newCounterID.toUpperCase());
                    }
                }
            }
        });

        jlSide[1] = new JLabel("Supervisor", JLabel.TRAILING);
        jpInfo.add(jlSide[1]);
        JPanel jp2 = new JPanel(new BorderLayout());
        jlSide[1].setLabelFor(jp2);
        comboBox[1] = new JComboBox(svModel);
        jp2.add(comboBox[1], BorderLayout.CENTER);
        jbtExtra[1] = new JButton("View");
        jp2.add(jbtExtra[1], BorderLayout.EAST);
        jpInfo.add(jp2);
        jbtExtra[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewSupervisor frame = new ViewSupervisor(comboBox[1].getSelectedItem().toString());
            }
        });

        jlSide[2] = new JLabel("Location", JLabel.TRAILING);
        jpInfo.add(jlSide[2]);
        JPanel jp3 = new JPanel(new BorderLayout());
        jlSide[2].setLabelFor(jp3);
        comboBox[2] = new JComboBox(destModel);
        jp3.add(comboBox[2], BorderLayout.CENTER);
        jbtExtra[2] = new JButton("View");
        jp3.add(jbtExtra[2], BorderLayout.EAST);
        jpInfo.add(jp3);
        jbtExtra[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewLocation frame = new ViewLocation(comboBox[2].getSelectedItem().toString());
            }
        });

        jlSide[3] = new JLabel("CounterAdd", JLabel.TRAILING);
        jpInfo.add(jlSide[3]);
        jlSide[3].setLabelFor(jsTA);
        jpInfo.add(jsTA);

        jlSide[4] = new JLabel("Contact No.", JLabel.TRAILING);
        jpInfo.add(jlSide[4]);
        jlSide[4].setLabelFor(jtfContact);
        jpInfo.add(jtfContact);

        for (int l = 0; l < 5; l++) {
            jlSide[l].setFont(new Font("Arial", Font.BOLD, 15));
            jlSide[l].setForeground(Color.WHITE);
        }

        for (int l = 0; l < 3; l++) {
            jbtExtra[l].setForeground(Color.WHITE);
            jbtExtra[l].setBackground(new Color(60, 186, 84));
        }

        SpringUtilities.makeCompactGrid(jpInfo,
                5, 2, //rows, cols
                8, 8, //initX, initY
                10, 10);       //xPad, yPad

        jpButtons.add(jbtLeft);
        jpButtons.add(jbtAdd);
        jpButtons.add(jbtRetrieve);
        jpButtons.add(jbtDelete);
        jpButtons.add(jbtClear);
        jpButtons.add(jbtRight);

        ButtonListener listener = new ButtonListener();
        jbtLeft.addActionListener(listener);
        jbtRight.addActionListener(listener);

        jbtAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = comboBox[0].getSelectedItem().toString();
                String staffID = comboBox[1].getSelectedItem().toString();
                String destID = comboBox[2].getSelectedItem().toString();
                String address = taAddress.getText();
                String contact = jtfContact.getText();
                if (address.equals("") || contact.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in address and contact number.", "Error in CRUD Counter", JOptionPane.ERROR_MESSAGE);

                } else {
                    Counter c = mcc.selectRecord(id);
                    if (c != null) {
                        try {
                            Staff staff = msc.selectRecord(staffID);
                            Dslocation dest = mdc.selectRecord(destID);
                            c.setSupervisorid(staff);
                            c.setDestid(dest);
                            c.setCounteradd(address);
                            c.setContactnum(contact);
                            mcc.updateRecord(c);
                            JOptionPane.showMessageDialog(null, id + ", " + address + " is updated Successful.\n", "Insert Successful", JOptionPane.INFORMATION_MESSAGE);

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "update listener Error: " + ex.getMessage(), "Error in CRUD Counter", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        try {
                            Staff staff = msc.selectRecord(staffID);
                            Dslocation dest = mdc.selectRecord(destID);
                            c = new Counter(id, staff, dest, address, contact);
                            mcc.addRecord(c);
                            mcc = new MaintainCounterControl();
                            countersinPanel = mcc.getAllRecord();
                            CreateButtonsInPanel(countersinPanel);
                        } catch (Exception exc) {
                            JOptionPane.showMessageDialog(null, "add listener Error: " + exc.getMessage(), "Error in CRUD Counter", JOptionPane.ERROR_MESSAGE);
                        }
                        c = mcc.selectRecord(id);
                        if (c != null) {
                            JOptionPane.showMessageDialog(null, id + ", " + address + " is inserted Successful.\n", "Insert Successful", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });

        jbtRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = ((String) comboBox[0].getSelectedItem()).toUpperCase();
                retrieveCounter(mcc.selectRecord(ID));
            }
        });

        jbtDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = comboBox[0].getSelectedItem().toString();
                Counter c = mcc.selectRecord(id);
                if (c != null) {
                    int opt = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if (opt == JOptionPane.YES_OPTION) {
                        mcc.deleteRecord(c);
                        mcc = new MaintainCounterControl();
                        countersinPanel = mcc.getAllRecord();
                        CreateButtonsInPanel(countersinPanel);
                        clear();
                        retrieveCounter(mcc.displayRecord('L'));
                        JOptionPane.showMessageDialog(null, id + " is deleted Successful.\n", "Deleted Successful", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    clear();
                    JOptionPane.showMessageDialog(null, "No such counter.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jbtClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        JLabel jlEast = new JLabel("View Counter");
        jlEast.setForeground(new Color(255, 87, 0));
        jlEast.setFont(new Font("Arial", Font.BOLD, 32));
        jpRight.add(jlEast, BorderLayout.NORTH);
        jpRight.add(jpInfo, BorderLayout.CENTER);
        jpRight.add(jpButtons, BorderLayout.SOUTH);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtLeft) {
                retrieveCounter(mcc.displayRecord('L'));
            } else if (e.getSource() == jbtRight) {
                retrieveCounter(mcc.displayRecord('R'));
            }
        }
    }

    public void retrieveCounter(Counter c) {
        if (c != null) {
            comboBox[0].setSelectedItem(c.getCounterid());
            comboBox[1].setSelectedItem(c.getSupervisorid().getStaffid());
            comboBox[2].setSelectedItem(c.getDestid().getDestid());
            taAddress.setText(c.getCounteradd());
            jtfContact.setText(c.getContactnum());
        } else {
            JOptionPane.showMessageDialog(null, "No such counter, CRUD Counter", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void clear() {
        for (JComboBox j : comboBox) {
            j.setSelectedIndex(0);
        }
        taAddress.setText("");
        jtfContact.setText("");
        mcc = new MaintainCounterControl();
        mdc = new MaintainDslocationControl();
        msc = new MaintainStaffControl();

        counterModel.removeAllElements();
        svModel.removeAllElements();
        destModel.removeAllElements();

        for (int i = 0; i < mcc.getAllRecord().size(); i++) {
            counterModel.addElement(mcc.getAllRecord().get(i).getCounterid());
        }

        for (int i = 0; i < msc.getAllRecord().size(); i++) {
            svModel.addElement(msc.getAllRecord().get(i).getStaffid());
        }

        for (int i = 0; i < mdc.getAllRecord().size(); i++) {
            destModel.addElement(mdc.getAllRecord().get(i).getDestid());
        }
    }

    public void CreateButtonsInPanel(ArrayList<Counter> busList) {
        jpTable.removeAll();
        jpTable.revalidate();
        jpTable.repaint();
        jpTable.setLayout(new GridLayout(busList.size(), 1));

        int count = 1, y = 1;
        ImageIcon imgJbt = createImageIcon("../images/crud/counterLocation.png", 30, 30);

        if (busList.size() < 1) {
            JLabel jlTable = new JLabel("No counter to be displayed.");
            jpTable.add(jlTable);
        } else {
            for (Counter c : busList) {
                String info = String.format("Counterid: %6s | Supervisorid: %6s | Contact No.: %11s", c.getCounterid(), c.getSupervisorid().getStaffid(), c.getContactnum());
                try {
                    JButton jbt = new JButton(info, imgJbt);
                    jbt.setBackground(new Color(243, 156, 18));
                    jbt.setVerticalAlignment(SwingConstants.CENTER);
                    jbt.setHorizontalAlignment(SwingConstants.LEFT);
                    jbt.setVerticalTextPosition(SwingConstants.CENTER);
                    jbt.setHorizontalTextPosition(SwingConstants.RIGHT);
                    jbt.setForeground(Color.WHITE);
                    jbt.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            retrieveCounter(c);
                        }
                    });

                    jpTable.add(jbt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error in Create Bus Button", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

    public static ImageIcon createImageIcon(String path, int w, int h) {
        ImageIcon img = null;
        ImageIcon icon = null;
        java.net.URL imgURL = CRUDCounter.class.getResource(path);

        try {
            img = new ImageIcon(CRUDCounter.class.getResource(path));
            icon = new ImageIcon((img.getImage()).getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
            return icon;
        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(null, "Image of " + path + " cannot be displayed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    
    public static void main(String[] args) {
    }

}
