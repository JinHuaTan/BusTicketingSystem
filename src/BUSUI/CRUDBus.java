/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSCONTROL.MaintainBusControl;
import BUSCONTROL.MaintainBustypeControl;
import BUSDOMAIN.Bus;
import BUSDOMAIN.Bustype;
import BUSDOMAIN.Counter;
import BUSDOMAIN.Staff;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CRUDBus extends JFrame {

    private JPanel jpContentHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));//header
    private JPanel jpContentCenter = new JPanel(new BorderLayout(30, 30));//content
    private JPanel jpLeft;//form
    private JPanel jpRight;//form
    private JPanel jpTable;
    private JPanel jpContent;
    private JScrollPane JSPane;
    private JPanel jpBg = new JPanel(new BorderLayout());

    private ArrayList<Bus> busInPanel;
    private MaintainBusControl mbc;
    private MaintainBustypeControl mbtc;
    private String fdridate = "";
    private JButton jbtLeft = new JButton("<");
    private JButton jbtRight = new JButton(">");
    private JComboBox[] comboBox = new JComboBox[5];
    private JButton jbtExtra = new JButton();
    private JTextField jtfCarplate = new JTextField();
    private DefaultComboBoxModel busIDModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel busTypeModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel dayModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel monthModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel yearModel = new DefaultComboBoxModel();
    private Image imgBg;

    public CRUDBus(Counter ds, Staff s) {
        mbc = new MaintainBusControl();
        mbtc = new MaintainBustypeControl();
        busInPanel = mbc.getAllRecord();

        design();
        crudField();

        try {
            imgBg = ImageIO.read(this.getClass().getResource("../images/background/bc16.png"));;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Background image of CRUDBus  cannot be displayed.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        jpContent = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension d = getSize();
                Graphics2D g2 = (Graphics2D) g;
                g2.fill(new Rectangle(0, 0, d.width, d.height));
                g.drawImage(imgBg, 0, 0, d.width, d.height, null);
            }
        };
        jpContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jpContent.add(jpContentHeader, BorderLayout.NORTH);
        jpContent.add(jpContentCenter, BorderLayout.CENTER);
        designPanel(ds, s);
        add(jpBg);

        setTitle("GoToMalaysia - CRUD of Bus");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void design() {
        jpContentHeader.setPreferredSize(new Dimension(getWidth(), 50));
        ImageIcon icon = createImageIcon("../images/GreyIcon/bus.png", 30, 30);
        JButton jlHeader = new JButton(" Manage Bus", icon);
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
        ArrayList<String> columnName = mbc.getAllColumnName();
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
                busInPanel = mbc.searchRecordByColumn((String) comboBox.getSelectedItem(), jtfSearch.getText());
                CreateButtonsInPanel(busInPanel);
            }
        });
        ImageIcon imgClearT = createImageIcon("../images/crud/refresh.png", 18, 18);
        JButton jbtClear = new JButton(imgClearT);
        jbtClear.setBackground(Color.BLUE);
        jbtClear.setForeground(Color.WHITE);
        jpHeaNorth.add(jbtClear);
        jbtClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mbc = new MaintainBusControl();
                busInPanel = mbc.getAllRecord();
                CreateButtonsInPanel(busInPanel);
                jtfSearch.setText("");
            }
        });

        jpTable = new JPanel();
        jpTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jpTable.setBackground(Color.WHITE);
        CreateButtonsInPanel(busInPanel);
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
        jpRight.setPreferredSize(new Dimension(700, getHeight()));
        jpContentCenter.add(jpLeft, BorderLayout.CENTER);
        jpContentCenter.add(jpRight, BorderLayout.EAST);
    }

    public void crudField() {
        JPanel jpInfo = new JPanel(new SpringLayout());
        JPanel jpButtons = new JPanel(new GridLayout(1, 6, 5, 5));
        jpInfo.setBackground(new Color(0, 0, 0, 0));
        jpInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        jpButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        jpButtons.setBackground(new Color(0, 0, 0, 0));
        jpButtons.setPreferredSize(new Dimension(getWidth(), 60));
        JLabel[] jlSide = new JLabel[4];
        JButton jbtAdd = new JButton("Add/ Update");
        ImageIcon imgRetrieve = createImageIcon("../images/crud/search.png", 18, 18);
        JButton jbtRetrieve = new JButton(imgRetrieve);
        ImageIcon imgDelete = createImageIcon("../images/crud/delete.png", 18, 18);
        JButton jbtDelete = new JButton(imgDelete);
        ImageIcon imgRefresh = createImageIcon("../images/crud/refresh.png", 18, 18);
        JButton jbtClear = new JButton(imgRefresh);

        jtfCarplate.setPreferredSize(new Dimension(150, 40));
        jtfCarplate.setFont(new Font("Arial", Font.PLAIN, 15));
        jbtLeft.setBackground(new Color(52, 70, 93));
        jbtLeft.setForeground(Color.WHITE);
        jbtRight.setBackground(new Color(52, 70, 93));
        jbtRight.setForeground(Color.WHITE);
        jbtRetrieve.setBackground(new Color(46, 204, 113));
        jbtRetrieve.setForeground(Color.WHITE);
        jbtAdd.setBackground(new Color(72, 133, 237));
        jbtAdd.setForeground(Color.WHITE);
        jbtDelete.setBackground(new Color(219, 50, 54));
        jbtDelete.setForeground(Color.WHITE);
        jbtClear.setBackground(new Color(244, 115, 33));
        jbtClear.setForeground(Color.WHITE);

        mbc = new MaintainBusControl();
        mbtc = new MaintainBustypeControl();
        for (int i = 0; i < mbc.getAllRecord().size(); i++) {
            busIDModel.addElement(mbc.getAllRecord().get(i).getBusid());
        }

        for (int i = 0; i < mbtc.getAllRecord().size(); i++) {
            busTypeModel.addElement(mbtc.getAllRecord().get(i).getBustypeid());
        }

        for (int i = 1; i <= 31; i++) {
            dayModel.addElement(String.format("%02d", i) + "");
        }

        for (int i = 1; i <= 12; i++) {
            monthModel.addElement(String.format("%02d", i) + "");
        }

        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1999; i <= year; i++) {
            yearModel.addElement(String.format("%04d", i) + "");
        }

        jlSide[0] = new JLabel("BusID", JLabel.TRAILING);
        jpInfo.add(jlSide[0]);
        JPanel jp = new JPanel(new BorderLayout());
        jlSide[0].setLabelFor(jp);
        comboBox[0] = new JComboBox(busIDModel);
        jp.add(comboBox[0], BorderLayout.CENTER);
        jbtExtra = new JButton(" Add ");
        jp.add(jbtExtra, BorderLayout.EAST);
        jpInfo.add(jp);
        jbtExtra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newBusID = JOptionPane.showInputDialog("Enter new busID that starts with BS and follows by 4 digits:\n (The ID will be deleted if this bus is not added to database)");
                Pattern p = Pattern.compile("^[bB][sS][0-9]{4}$");
                Matcher m = p.matcher(newBusID);
                while (!m.find()) {
                    newBusID = "";
                    String nBusID;
                    nBusID = JOptionPane.showInputDialog("Please enter busID that starts with BS and follows by 4 digits.");
                    if (nBusID == null) {
                        break;
                    } else {
                        newBusID = nBusID;
                        m = p.matcher(newBusID);
                    }
                }
                if (!newBusID.equals("")) {
                    busIDModel.addElement(newBusID.toUpperCase());
                    comboBox[0].setSelectedItem(newBusID.toUpperCase());
                }
            }
        });

        jlSide[1] = new JLabel("Car Plate", JLabel.TRAILING);
        jpInfo.add(jlSide[1]);
        jlSide[1].setLabelFor(jtfCarplate);
        jpInfo.add(jtfCarplate);

        jlSide[2] = new JLabel("Bus Type ID", JLabel.TRAILING);
        jpInfo.add(jlSide[2]);
        JPanel jp2 = new JPanel(new BorderLayout(10, 0));
        jlSide[2].setLabelFor(jp2);
        comboBox[1] = new JComboBox(busTypeModel);
        comboBox[1].setPreferredSize(new Dimension(245, getHeight()));
        jp2.add(comboBox[1], BorderLayout.WEST);
        JTextField jtfView = new JTextField(" View Bus Type Here");
        jtfView.setEditable(false);
        jp2.add(jtfView, BorderLayout.CENTER);
        comboBox[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Bustype btView = mbtc.selectRecord((String) comboBox[1].getSelectedItem());
                jtfView.setText(" " + btView.getBustype());
            }
        });
        jpInfo.add(jp2);

        jlSide[3] = new JLabel("First Dri Date", JLabel.TRAILING);
        jpInfo.add(jlSide[3]);
        JPanel jp3 = new JPanel(new GridLayout(1, 3));
        jlSide[3].setLabelFor(jp3);
        comboBox[2] = new JComboBox(dayModel);
        jp3.add(comboBox[2]);
        comboBox[3] = new JComboBox(monthModel);
        jp3.add(comboBox[3]);
        comboBox[4] = new JComboBox(yearModel);
        jp3.add(comboBox[4]);
        jpInfo.add(jp3);

        for (int l = 0; l < 4; l++) {
            jlSide[l].setFont(new Font("Arial", Font.BOLD, 20));
            jlSide[l].setForeground(new Color(246, 62, 98));
        }

        jbtExtra.setForeground(Color.WHITE);
        jbtExtra.setBackground(new Color(60, 186, 84));
        SpringUtilities.makeCompactGrid(jpInfo,
                4, 2, //rows, cols
                2, 2, //initX, initY
                5, 5);       //xPad, yPad

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
                String carplate = jtfCarplate.getText();
                String bustypeid = comboBox[1].getSelectedItem().toString();
                fdridate = comboBox[2].getSelectedItem().toString() + "-" + comboBox[3].getSelectedItem().toString() + "-" + comboBox[4].getSelectedItem().toString();

                if (carplate.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in the carplate.", "Error in CRUD Bus", JOptionPane.ERROR_MESSAGE);

                } else {
                    Bus b = mbc.selectRecord(id);
                    if (b != null) {
                        try {
                            Bustype bt = mbtc.selectRecord(bustypeid);
                            b.setCarplate(carplate);
                            b.setBustypeid(bt);
                            b.setFirstdridate(fdridate);
                            mbc.updateRecord(b);
                            JOptionPane.showMessageDialog(null, id + ", " + carplate + " is updated Successful.\n", "Insert Successful", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "update listener Error: " + ex.getMessage(), "Error in CRUD Bus", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        try {
                            Bustype bt = mbtc.selectRecord(bustypeid);
                            b = new Bus(id, carplate, bt, fdridate);
                            mbc.addRecord(b);
                        } catch (Exception exc) {
                            JOptionPane.showMessageDialog(null, "add listener Error: " + exc.getMessage(), "Error in CRUD Bus", JOptionPane.ERROR_MESSAGE);
                        }
                        b = mbc.selectRecord(id);
                        if (b != null) {
                            JOptionPane.showMessageDialog(null, id + ", " + carplate + " is inserted Successful.\n", "Insert Successful", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });

        jbtRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = ((String) comboBox[0].getSelectedItem()).toUpperCase();
                clear();
                retrieveBus(mbc.selectRecord(ID));
            }
        });

        jbtDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = comboBox[0].getSelectedItem().toString();
                Bus c = mbc.selectRecord(id);
                if (c != null) {
                    int opt = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if (opt == JOptionPane.YES_OPTION) {
                        mbc.deleteRecord(c);
                        clear();
                        retrieveBus(mbc.displayRecord('L'));
                        JOptionPane.showMessageDialog(null, id + " is deleted Successful.\n", "Deleted Successful", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    clear();
                    JOptionPane.showMessageDialog(null, "No such bus.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jbtClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        JLabel jlEast = new JLabel("View Bus");
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
                retrieveBus(mbc.displayRecord('L'));
            } else if (e.getSource() == jbtRight) {
                retrieveBus(mbc.displayRecord('R'));
            }
        }
    }

    public void retrieveBus(Bus c) {
        if (c != null) {
            comboBox[0].setSelectedItem(c.getBusid());
            jtfCarplate.setText(c.getCarplate());
            comboBox[1].setSelectedItem(c.getBustypeid().getBustypeid());
            comboBox[2].setSelectedItem(c.getFirstdridate().charAt(0) + "" + c.getFirstdridate().charAt(1));
            comboBox[3].setSelectedItem(c.getFirstdridate().charAt(3) + "" + c.getFirstdridate().charAt(4));
            comboBox[4].setSelectedItem(c.getFirstdridate().charAt(6) + "" + c.getFirstdridate().charAt(7) + "" + c.getFirstdridate().charAt(8) + "" + c.getFirstdridate().charAt(9));
        } else {
            JOptionPane.showMessageDialog(null, "No such bus.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void clear() {
        for (JComboBox j : comboBox) {
            j.setSelectedIndex(0);
        }
        jtfCarplate.setText("");

        mbc = new MaintainBusControl();
        mbtc = new MaintainBustypeControl();

        busIDModel.removeAllElements();
        busTypeModel.removeAllElements();

        for (int i = 0; i < mbc.getAllRecord().size(); i++) {
            busIDModel.addElement(mbc.getAllRecord().get(i).getBusid());
        }

        for (int i = 0; i < mbtc.getAllRecord().size(); i++) {
            busTypeModel.addElement(mbtc.getAllRecord().get(i).getBustypeid());
        }

    }

    public void CreateButtonsInPanel(ArrayList<Bus> busList) {
        jpTable.removeAll();
        jpTable.revalidate();
        jpTable.repaint();
        jpTable.setLayout(new GridLayout(busList.size(), 1));

        int count = 1, y = 1;
        ImageIcon imgJbt = createImageIcon("../images/crud/bus.png", 30, 30);

        if (busList.size() < 1) {
            JLabel jlTable = new JLabel("No Bus to be displayed.");
            jpTable.add(jlTable);
        } else {
            for (Bus c : busList) {
                String info = String.format("Busid: %6s | Carplate: %10s | Bustypeid: %6s", c.getBusid(), c.getCarplate(), c.getBustypeid().getBustypeid());
                try {
                    JButton jbt = new JButton(info, imgJbt);
                    jbt.setBackground(new Color(72, 133, 237));
                    jbt.setVerticalAlignment(SwingConstants.CENTER);
                    jbt.setHorizontalAlignment(SwingConstants.LEFT);
                    jbt.setVerticalTextPosition(SwingConstants.CENTER);
                    jbt.setHorizontalTextPosition(SwingConstants.RIGHT);
                    jbt.setForeground(Color.WHITE);
                    jbt.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            retrieveBus(c);
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
        java.net.URL imgURL = CRUDBus.class.getResource(path);

        try {
            img = new ImageIcon(CRUDBus.class.getResource(path));
            icon = new ImageIcon((img.getImage()).getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
            return icon;
        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(null, "Image of " + path + " cannot be displayed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void designPanel(Counter ds, Staff s) {
        JPanel jpHeader = new JPanel(new BorderLayout(100, 10));
        JPanel jpLogo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jpDate = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel jpHeader2 = new JPanel(new GridLayout(2, 1));
        String[] navList = {"Welcome, " + s.getStaffname(), ds.getDestid().getDestl(), "Back To Counter", "Log Out"};
        String[] navImg = {"person", "counter", "back", "logout"};
        JButton[] jbtNav = new JButton[navList.length];
        JPanel jpNav = new JPanel(new GridLayout(1, navList.length));
        String[] sideList = {"Dashboard", "Ticket Management", "Ticket Info/Purchasing", "Refund/ Cancellation of Ticket",
            "Transport Management", "Bus",
            "Route", "Trip", "Staff Management", "Staff Info", "P & C Info", "Report Management",
            "Exception Report", "Transaction Report", "Summary Report"};
        String[] sideImg = {"dashboard", "ticketmgt", "ticketinfo", "refund", "transportmgt", "bus", "route", "trip",
            "staffmgt", "staffinfo", "pnc", "reportmgt", "exception", "trans", "summary"};
        JButton[] jbtSide = new JButton[sideList.length];
        JPanel jpSide = new JPanel(new GridLayout(sideList.length, 1));
        JPanel jpWest = new JPanel(new BorderLayout());
        ImageIcon hideImg = createImageIcon("../images/arrowToRight.png", 20, 20);
        JButton jbtHide = new JButton(hideImg);

        ImageIcon busImg = createImageIcon("../images/busIcon.png", 100, 100);
        JLabel busLabel = new JLabel(busImg);
        JLabel nameLabel = new JLabel("GoToMalaysia");
        nameLabel.setForeground(new Color(117, 117, 117));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 35));
        jpLogo.add(busLabel);
        jpLogo.add(nameLabel);
        jpLogo.setBackground(Color.WHITE);
        jpHeader.setBackground(Color.WHITE);
        jpHeader.add(jpLogo, BorderLayout.WEST);
        jpHeader.setPreferredSize(new Dimension(getWidth(), 100));

        jpNav.setBackground(Color.WHITE);
        for (int i = 0; i < navList.length; i++) {
            ImageIcon imgNav = createImageIcon("../images/Mainui/" + navImg[i] + ".png", 18, 18);
            jbtNav[i] = new JButton(navList[i], imgNav);
            jbtNav[i].setPreferredSize(new Dimension(40, 50));
            jbtNav[i].setForeground(Color.WHITE);
            jbtNav[i].setBackground(new Color(8, 8, 8));
            jbtNav[i].setFont(new Font("Arial", Font.BOLD, 12));
            jpNav.add(jbtNav[i]);
        }

        jbtNav[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChooseCounter f = new ChooseCounter(s);
                dispose();
            }
        });

        jbtNav[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login l = new Login();
                dispose();
            }
        });

        jpHeader2.add(jpNav);
        SimpleDateFormat sdf = new SimpleDateFormat("EE, dd MMMMM yyyy");
        Date now = new Date();
        JLabel l2 = new JLabel("Today's Date - " + sdf.format(now));
        jpDate.add(l2);
        jpDate.setBackground(Color.WHITE);
        jpHeader2.add(jpDate);
        jpHeader.add(jpHeader2, BorderLayout.CENTER);

        jpSide.setBackground(new Color(52, 73, 94));

        for (int i = 0; i < sideList.length; i++) {
            ImageIcon img = createImageIcon("../images/Mainui/" + sideImg[i] + ".png", 18, 18);
            jbtSide[i] = new JButton(sideList[i], img);
            jbtSide[i].setBackground(new Color(34, 34, 34));
            jbtSide[i].setForeground(new Color(125, 125, 131));
            jbtSide[i].setFont(new Font("Arial", Font.BOLD, 12));
            jbtSide[i].setHorizontalAlignment(SwingConstants.LEFT);
            jpSide.add(jbtSide[i]);
        }

        jbtSide[0].setBackground(new Color(0, 119, 181));
        jbtSide[0].setForeground(Color.WHITE);
        jbtSide[1].setEnabled(false);
        jbtSide[1].setBackground(new Color(8, 8, 8));
        jbtSide[1].setForeground(Color.WHITE);
        jbtSide[4].setEnabled(false);
        jbtSide[4].setBackground(new Color(8, 8, 8));
        jbtSide[4].setForeground(Color.WHITE);
        jbtSide[8].setEnabled(false);
        jbtSide[8].setBackground(new Color(8, 8, 8));
        jbtSide[8].setForeground(Color.WHITE);
        jbtSide[11].setEnabled(false);
        jbtSide[11].setBackground(new Color(8, 8, 8));
        jbtSide[11].setForeground(Color.WHITE);
        jbtHide.setBackground(new Color(8, 8, 8));
        jbtHide.setForeground(Color.WHITE);
        jbtHide.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        jbtHide.setHorizontalAlignment(SwingConstants.RIGHT);
        jpWest.setBackground(new Color(8, 8, 8));
        jpSide.setVisible(false);
        jbtHide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jpSide.isVisible()) {
                    jpSide.setVisible(false);
                    ImageIcon showImg = createImageIcon("../images/arrowToRight.png", 20, 20);
                    jbtHide.setIcon(showImg);

                } else {
                    jpSide.setVisible(true);
                    ImageIcon shideImg = createImageIcon("../images/arrowToLeft.png", 20, 20);
                    jbtHide.setIcon(shideImg);
                }
            }
        });

        jbtSide[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainUI f = new MainUI(ds, s);
                dispose();
            }
        });

        jbtSide[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TicketTripInfo f = new TicketTripInfo(ds, s);
                dispose();
            }
        });

        jbtSide[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (s.getJobposition().getPositionid().equals("P00003") || s.getJobposition().getPositionid().equals("P00001")) {
                    RefundCancelMain f = new RefundCancelMain(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (s.getJobposition().getPositionid().equals("P00003") || s.getJobposition().getPositionid().equals("P00001")) {
                    CRUDBus f = new CRUDBus(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (s.getJobposition().getPositionid().equals("P00003") || s.getJobposition().getPositionid().equals("P00001")) {
                    CRUDRoute f = new CRUDRoute(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        jbtSide[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (s.getJobposition().getPositionid().equals("P00003") || s.getJobposition().getPositionid().equals("P00001")) {
                    CRUDTrip f = new CRUDTrip(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        jbtSide[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (s.getJobposition().getPositionid().equals("P00003")) {
                    StaffCRUD f = new StaffCRUD(ds, s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StaffPNCMain f = new StaffPNCMain(ds, s);
                dispose();

            }
        });

        jbtSide[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (s.getJobposition().getPositionid().equals("P00003")) {
                    TransactioReportSelection f = new TransactioReportSelection();

                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (s.getJobposition().getPositionid().equals("P00003")) {
                    ExceptionReportSelection f = new ExceptionReportSelection();

                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtSide[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (s.getJobposition().getPositionid().equals("P00003")) {
                    SummaryReportSelection f = new SummaryReportSelection();

                } else {
                    JOptionPane.showMessageDialog(null, "You are not authorise to access this information.", "Not Authorise User", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        jpWest.add(jbtHide, BorderLayout.NORTH);
        jpWest.add(jpSide, BorderLayout.CENTER);
        jpBg.add(jpHeader, BorderLayout.NORTH);
        jpBg.add(jpWest, BorderLayout.WEST);
        jpBg.add(jpContent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
    }

}
